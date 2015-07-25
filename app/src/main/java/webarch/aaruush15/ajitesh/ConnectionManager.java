package webarch.aaruush15.ajitesh;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by AJITESH on 12-07-2015.
 */
public class ConnectionManager{

    final DatabaseHandler dbHandler;
    Context context;
    ListView listView;
    SwipeRefreshLayout swipeRefreshLayout;

    ConnectionManager(Context context,SwipeRefreshLayout swipeRefreshLayout,ListView listView)
    {
        dbHandler=new DatabaseHandler(context);
        this.context=context;
        this.swipeRefreshLayout=swipeRefreshLayout;
        this.listView=listView;
    }



    public void getDatabaseUpdate(int version)throws JSONException{
        RequestParams params=new RequestParams();
        params.put("version",version);
        AaruushRestClient.get("webacrh2.php", params, new JsonHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();
                Log.d("AARUUSH","onStart");
                swipeRefreshLayout.setRefreshing(true);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                Log.d("AARUUSH", "onFinish");
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                Log.d("AARUUSH", "onSuccess");
                new RunThread().execute(response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Log.d("AARUUSH", "onFailure() - " + String.valueOf(statusCode));
            }


        });



    }
    private class RunThread extends AsyncTask<JSONArray, Void,Void> {
        @Override
        protected Void doInBackground(JSONArray... jsonArrays) {
            JSONArray response=jsonArrays[0];

            try {
                dbHandler.setVersion(response.getJSONObject(0).getInt("version"));

                for(int i=1;i<response.length();i++)
                {
                    JSONObject Jobj=response.getJSONObject(i);
                    if(dbHandler.dataExists(Jobj.getInt("id")))
                    {

                        Log.d("AARUUSH", "Update");
                        dbHandler.updateData(new Data(Jobj.getInt("id"),
                                Jobj.getString("name"),
                                Jobj.getString("type"),
                                Jobj.getString("domain"),
                                Jobj.getString("venue"),
                                Jobj.getString("time"),
                                Jobj.getString("date"),
                                Jobj.getString("desc"),
                                Jobj.getString("image")
                        ));
                    }
                    else
                    {
                        Log.d("AARUUSH", "Add");
                        dbHandler.addData(new Data(Jobj.getInt("id"),
                                Jobj.getString("name"),
                                Jobj.getString("type"),
                                Jobj.getString("domain"),
                                Jobj.getString("venue"),
                                Jobj.getString("time"),
                                Jobj.getString("date"),
                                Jobj.getString("desc"),
                                Jobj.getString("image")
                        ));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            listView.setAdapter(new ListAdapter(context,dbHandler.getAllData()));
        }
    }

}

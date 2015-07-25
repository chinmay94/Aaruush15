package webarch.aaruush15.ajitesh;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;

import java.util.List;

import webarch.aaruush15.R;


public class MainActivity extends ActionBarActivity implements SwipeRefreshLayout.OnRefreshListener{


    ListView mainlist;
    DatabaseHandler dbHandler;
    ConnectionManager con;
    Context context;
    List<Data> list;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("AARUUSH","onCreate()");
        dbHandler=new DatabaseHandler(this);
        mainlist=(ListView)findViewById(R.id.listView);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        context=this;
        con=new ConnectionManager(this,swipeRefreshLayout,mainlist);
        //dbHandler.onUpgrade(dbHandler.getWritableDatabase(),1,1);
        //Log.d("AARUUSH",dbHandler.getData(1).getName());
        list=dbHandler.getAllData();
        if(list!=null)
            mainlist.setAdapter(new ListAdapter(context,dbHandler.getAllData()));
        mainlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Selected Card " + (position + 1), Toast.LENGTH_SHORT).show();
            }
        });

        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                onRun();
            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRefresh() {
        onRun();
    }
    public void onRun(){

        try {
            con.getDatabaseUpdate(dbHandler.getVersion());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

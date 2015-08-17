package webarch.aaruush15.ui_fragments;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;

import java.util.List;

import webarch.aaruush15.BackEnd.ConnectionManager;
import webarch.aaruush15.BackEnd.Data;
import webarch.aaruush15.BackEnd.DatabaseHandler;
import webarch.aaruush15.BackEnd.ListAdapter;
import webarch.aaruush15.R;
import webarch.aaruush15.WorkshopFragments.WorkshopDetails;

/**
 * Created by Chinmay on 07-Jul-15.
 */
//public class FragmentHighlights extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
public class FragmentHighlights extends Fragment{

    /*DatabaseHandler dbHandler;
    ListView list;
    SwipeRefreshLayout swipeRefreshLayout;
    ConnectionManager con;
    Context context;*/
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View rootview=inflater.inflate(R.layout.fragment_highlights,container,false);
        View rootview=inflater.inflate(R.layout.comingsoon,container,false);
        /*list=(ListView)rootview.findViewById(R.id.listView);
        dbHandler=new DatabaseHandler(getActivity());
        swipeRefreshLayout=(SwipeRefreshLayout)rootview.findViewById(R.id.swipe_refresh_layout);
        con=new ConnectionManager(getActivity(),swipeRefreshLayout,list,"3",null);
        context=getActivity();
        final List<Data> highlightList=dbHandler.getDatabyType("3");
        if(highlightList!=null) {
            ListAdapter adapter = new ListAdapter(getActivity(), -1,highlightList);
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(getActivity(), WorkshopDetails.class);
                    Bundle bundle = highlightList.get(i).getAsBundle();
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                onRun();
            }
        });*/
        return rootview;
    }
    /*public void onRefresh() {
        onRun();
    }
    public void onRun(){
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if(isConnected)
        {
            try {
                con.getDatabaseUpdate(dbHandler.getVersion());

            } catch (JSONException e) {
                e.printStackTrace();
            }}
        else
        {
            swipeRefreshLayout.setRefreshing(false);
            Toast.makeText(context, "Please Connect To The Internet", Toast.LENGTH_SHORT).show();
        }
    }*/
}
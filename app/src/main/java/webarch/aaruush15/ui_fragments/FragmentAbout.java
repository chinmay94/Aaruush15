package webarch.aaruush15.ui_fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import webarch.aaruush15.BackEnd.ConnectionManager;
import webarch.aaruush15.R;

/**
 * Created by Chinmay on 07-Jul-15.
 */
public class FragmentAbout extends Fragment {

    ConnectionManager con;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.fragment_about,container,false);
        SharedPreferences sharedpreferences = getActivity().getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String isFirstRun=sharedpreferences.getString("isFirstRun","true");
        Log.d("AARUUSHSFTEST",isFirstRun);
        if(isFirstRun.equals("true")) {
            con = new ConnectionManager(getActivity(), null, null, "-1", null);
            try {
                rnrStatic();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString("isFirstRun", "false");
            editor.apply();
            editor.commit();
        }
        FloatingActionsMenu rightLabels = (FloatingActionsMenu) rootview.findViewById(R.id.right_labels);

        FloatingActionButton facebook = new FloatingActionButton(getActivity());
        facebook.setImageResource(R.drawable.actionfb);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(getOpenFacebookIntent(getActivity()));
                //Toast.makeText(getActivity(), "Facebook", Toast.LENGTH_SHORT).show();
            }
        });
        facebook.setTitle("Facebook");
        rightLabels.addButton(facebook);

        FloatingActionButton youtube = new FloatingActionButton(getActivity());
        youtube.setImageResource(R.drawable.actionyoutube);
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(getOpenutubeIntent(getActivity()));
                //Toast.makeText(getActivity(), "Youtube", Toast.LENGTH_SHORT).show();
            }
        });
        youtube.setTitle("Youtube");
        rightLabels.addButton(youtube);

        FloatingActionButton twitter = new FloatingActionButton(getActivity());
        twitter.setImageResource(R.drawable.actiontwitter);
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(getOpentwitterIntent(getActivity()));
                //Toast.makeText(getActivity(),"Twitter",Toast.LENGTH_SHORT).show();
            }
        });
        twitter.setTitle("Twitter");
        rightLabels.addButton(twitter);

        TextView text=(TextView)rootview.findViewById(R.id.text);
        text.setMovementMethod(new ScrollingMovementMethod());
        return rootview;
    }
    public static Intent getOpenFacebookIntent(Context context)
    {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://page/172731949541472"));
        } catch (Exception e)
        {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/aaruush.srm"));
        }
    }
    public static Intent getOpentwitterIntent(Context context)
    {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.twitter.android", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("twitter://user?user_id=1357708807"));
        } catch (Exception e)
        {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://twitter.com/Aaruush_Srmuniv"));
        }
    }
    public static Intent getOpenutubeIntent(Context context)
    {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.google.android.youtube", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.youtube.com/user/aaruush12"));
        } catch (Exception e)
        {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.youtube.com/user/aaruush12"));
        }
    }
    public void rnrStatic()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(getActivity().getAssets().open("staticdata.txt")));
        String readLine = null;
        String data="";
        while ((readLine = br.readLine()) != null)
            data+=readLine;
        try {
            JSONArray response=new JSONArray(data);
            con.forceRead(response);
        } catch (JSONException e) {
            Log.d("MA KI ANKH", "problem with starting force read");
            e.printStackTrace();
        }
    }
}
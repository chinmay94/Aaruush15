package webarch.aaruush15.ui_fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import webarch.aaruush15.R;

/**
 * Created by Chinmay on 07-Jul-15.
 */
public class FragmentDomains extends Fragment {


    GridView gv;
    Context context;

    public static String[] Member = {"MAGEFFICIE", "VIMANAZ", "MACHINATIONS", "ELECTRIZITE", "YUDDHAME", "FUNDAZ"};
    public static int[] MemberImages = {R.drawable.bg_magefficie, R.drawable.bg_vimaz, R.drawable.bg_machinations, R.drawable.bg_electrizite, R.drawable.bg_yudhamme, R.drawable.bg_fundaz};

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootview=inflater.inflate(R.layout.fragment_domains,container,false);
        setHasOptionsMenu(true);
        gv = (GridView) rootview.findViewById(R.id.gridView1);
        gv.setAdapter(new ImageAdapterDomains(getActivity(), Member, MemberImages));
        return rootview;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        inflater.inflate(R.menu.menu_main,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            Toast.makeText(getActivity(), "Hello", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
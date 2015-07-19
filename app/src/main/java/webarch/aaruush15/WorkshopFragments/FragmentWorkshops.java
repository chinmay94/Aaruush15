package webarch.aaruush15.WorkshopFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import webarch.aaruush15.R;

/**
 * Created by Chinmay on 07-Jul-15.
 */
public class FragmentWorkshops extends Fragment {

    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.fragment_workshops, container, false);
        list=(ListView)rootview.findViewById(R.id.listView);
        ArrayList<Workshop> workshopList=new WorkshopHandler().getWorkshops();
        WorkshopsAdapter adapter=new WorkshopsAdapter(getActivity(),-1,workshopList);
        list.setAdapter(adapter);
        return rootview;
    }
}
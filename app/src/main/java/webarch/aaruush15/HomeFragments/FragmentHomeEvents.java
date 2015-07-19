package webarch.aaruush15.HomeFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import webarch.aaruush15.R;

/**
 * Created by Chinmay on 09-Jul-15.
 */
public class FragmentHomeEvents extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootview=inflater.inflate(R.layout.fragment_home_events, container, false);
        return rootview;
    }
}

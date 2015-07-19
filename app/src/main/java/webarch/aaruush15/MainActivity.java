
package webarch.aaruush15;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import webarch.aaruush15.ui_fragments.FragmentAbout;
import webarch.aaruush15.ui_fragments.FragmentCredits;
import webarch.aaruush15.ui_fragments.FragmentDomains;
import webarch.aaruush15.ui_fragments.FragmentHighlights;
import webarch.aaruush15.HomeFragments.FragmentHome;
import webarch.aaruush15.ui_fragments.FragmentSponsors;
import webarch.aaruush15.TeamFragments.FragmentTeam;
import webarch.aaruush15.WorkshopFragments.FragmentWorkshops;

public class MainActivity extends MaterialNavigationDrawer
{

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public void init(Bundle savedInstanceState)
    {
        View drawerHeaderView = LayoutInflater.from(this).inflate(R.layout.custom_drawer,null);
        setDrawerHeaderCustom(drawerHeaderView);
        this.addSection(newSectionWithRealColor("Home", R.drawable.drawer_home, new FragmentHome()));
        this.addSection(newSectionWithRealColor("About", R.drawable.drawer_about, new FragmentAbout()));
        this.addSection(newSectionWithRealColor("Domains", R.drawable.drawer_domains, new FragmentDomains()));
        this.addSection(newSectionWithRealColor("Workshops", R.drawable.drawer_workshops, new FragmentWorkshops()));
        this.addSection(newSectionWithRealColor("Highlights", R.drawable.drawer_highlights, new FragmentHighlights()));
        this.addSection(newSectionWithRealColor("Sponsors", R.drawable.drawer_sponsors, new FragmentSponsors()));
        this.addSection(newSectionWithRealColor("Team", R.drawable.drawer_team, new FragmentTeam()));
        this.addBottomSection(newSectionWithRealColor("Credits", R.drawable.drawer_credits, new FragmentCredits()));

        this.allowArrowAnimation();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        this.closeDrawer();
    }
}
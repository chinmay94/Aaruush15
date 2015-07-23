package webarch.aaruush15.TeamFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import webarch.aaruush15.R;
import webarch.aaruush15.ViewFlipperLibraryFiles.BaseFlipAdapter;
import webarch.aaruush15.ViewFlipperLibraryFiles.FlipSettings;

/**
 * @author Yalantis
 */
public class FriendsActivity extends Fragment {

    final Context context = getActivity();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootview=inflater.inflate(R.layout.activity_friends, container, false);
        final ListView patrons = (ListView) rootview.findViewById(R.id.patrons);
        //final ListView core = (ListView) rootview.findViewById(R.id.core);
        FlipSettings settings = new FlipSettings.Builder().defaultPage(1).build();
        patrons.setAdapter(new MemberModelAdapter(getActivity(), Utils.patrons, settings));
        //core.setAdapter(new MemberModelAdapter(getActivity(), Utils.patrons, settings));
        /*patrons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Hello");

                // set dialog message
                alertDialogBuilder
                        .setMessage("Choose your option ")
                        .setCancelable(false)
                        .setPositiveButton("Facebook", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, close
                                // current activity
                                disp();
                            }
                            public void disp() {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                                        "https://www.facebook.com/chinmay.kapoor.9"));
                                startActivity(browserIntent);
                            }
                        })
                        .setNegativeButton("Call", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                String x = "tel:9314871195";
                                Intent calli = new Intent(Intent.ACTION_DIAL);
                                calli.setData((Uri.parse(x)));
                                startActivity(calli);
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();
                alertDialog.setCanceledOnTouchOutside(true);
                alertDialog.setCancelable(true);
            }
        });*/
        return rootview;
    }

    class MemberModelAdapter extends BaseFlipAdapter<MemberModel>
    {
        private final int PAGES = 3;
        private int[] IDS_INTEREST = {R.id.interest_1,R.id.interest_2};
        public MemberModelAdapter(Context context, List<MemberModel> items, FlipSettings settings)
        {
            super(context, items, settings);
        }

        @Override
        public View getPage(int position, View convertView, ViewGroup parent, MemberModel model1, MemberModel model2)
        {
            final MembersHolder holder;
            if (convertView == null)
            {
                holder = new MembersHolder();
                convertView = getActivity().getLayoutInflater().inflate(R.layout.team_item_normal, parent, false);
                holder.leftAvatar = (ImageView) convertView.findViewById(R.id.first);
                holder.rightAvatar = (ImageView) convertView.findViewById(R.id.second);
                holder.infoPage = getActivity().getLayoutInflater().inflate(R.layout.team_item_flipped, parent, false);
                holder.nickName = (TextView) holder.infoPage.findViewById(R.id.nickname);
                for (int id : IDS_INTEREST)
                    holder.interests.add((TextView) holder.infoPage.findViewById(id));
                convertView.setTag(holder);
            }
            else
            {
                holder = (MembersHolder) convertView.getTag();
            }

            switch (position)
            {
                case 1:
                    holder.leftAvatar.setImageResource(model1.getAvatar());
                    if (model2 != null)
                        holder.rightAvatar.setImageResource(model2.getAvatar());
                    break;
                default:
                    fillHolder(holder, position == 0 ? model1 : model2);
                    holder.infoPage.setTag(holder);
                    return holder.infoPage;
            }
            return convertView;
        }

        @Override
        public int getPagesCount()
        {
            return PAGES;
        }

        private void fillHolder(MembersHolder holder, MemberModel model)
        {
            if (model == null)
                return;
            Iterator<TextView> iViews = holder.interests.iterator();
            Iterator<String> iInterests = model.getInterests().iterator();
            while (iViews.hasNext() && iInterests.hasNext())
                iViews.next().setText(iInterests.next());
            holder.infoPage.setBackgroundColor(getResources().getColor(model.getBackground()));
            holder.nickName.setText(model.getNickname());
        }

        class MembersHolder
        {
            ImageView leftAvatar;
            ImageView rightAvatar;
            View infoPage;
            List<TextView> interests = new ArrayList<>();
            TextView nickName;
            TextView team;
        }
    }
}
package webarch.aaruush15.ui_fragments;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import webarch.aaruush15.R;


public class ImageAdapterDomains extends BaseAdapter
{
    String[] result;
    Context context;
    int[] imageId;
    private static LayoutInflater inflater = null;

    public ImageAdapterDomains(Context context, String[] prgmNameList, int[] prgmImages)
    {
        result = prgmNameList;
        this.context = context;
        imageId = prgmImages;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return result.length;
    }

    @Override
    public Object getItem(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }


    public class Holder {
        TextView tv;
        ImageView img;
        LinearLayout ll;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        Holder holder = new Holder();
        View rowView;

        //rowView = inflater.inflate(R.layout.domain_grid_layout, null);
        rowView = inflater.inflate(R.layout.testitem, null);
        /*holder.tv = (TextView) rowView.findViewById(R.id.textView1);
        holder.ll = (LinearLayout) rowView.findViewById(R.id.layout);

        holder.ll.setBackgroundResource(imageId[position]);
        holder.tv.setText(result[position]);*/

        return rowView;
    }
}


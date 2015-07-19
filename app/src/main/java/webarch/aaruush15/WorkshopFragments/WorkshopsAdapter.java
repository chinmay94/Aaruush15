package webarch.aaruush15.WorkshopFragments;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import webarch.aaruush15.R;

/**
 * Created by Chinmay on 18-Jul-15.
 */
public class WorkshopsAdapter extends ArrayAdapter<Workshop> {

    List<Workshop> list;
    Context context;
    public WorkshopsAdapter(Context context, int resource, List<Workshop> objects) {
        super(context, resource, objects);
        this.context=context;
        this.list=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.workshops_list_item, parent, false);
        Workshop current=list.get(position);
        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView price = (TextView) rowView.findViewById(R.id.price);
        TextView date = (TextView) rowView.findViewById(R.id.date);
        ImageView image= (ImageView) rowView.findViewById(R.id.image);
        title.setText(current.title);
        price.setText(current.price);
        date.setText(current.date);
        image.setImageResource(current.image);
        return rowView;
    }
}

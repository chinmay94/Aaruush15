package webarch.aaruush15;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import webarch.aaruush15.WorkshopFragments.Workshop;

/**
 * Created by Chinmay on 26-Jul-15.
 */
public class EventAdapter extends ArrayAdapter<Event> {

    List<Event> list;
    Context context;
    public EventAdapter(Context context, int resource, List<Event> objects) {
        super(context, resource, objects);
        this.context=context;
        this.list=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.card_view, parent, false);
        Event current=list.get(position);
        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView desc = (TextView) rowView.findViewById(R.id.txtName);
        ImageView image= (ImageView) rowView.findViewById(R.id.picdesc);
        title.setText(current.title);
        desc.setText(current.desc);
        image.setImageResource(current.image);
        return rowView;
    }
}

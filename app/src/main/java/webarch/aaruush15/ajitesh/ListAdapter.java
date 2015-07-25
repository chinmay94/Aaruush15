package webarch.aaruush15.ajitesh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import webarch.aaruush15.R;

public class ListAdapter extends ArrayAdapter<Data> {

    List<Data> list;
    private Context context;

    public ListAdapter(Context context,List<Data> list) {
        //super()
        super(context, -1,list);
        this.list=list;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        For Events ->
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.card_view, parent, false);
        TextView eventname = (TextView) rowView.findViewById(R.id.title);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.picdesc);
        TextView eventdesc = (TextView) rowView.findViewById(R.id.txtName);
//
        eventname.setText(list.get(position).getName());
        eventdesc.setText(list.get(position).getDesc());
        //imageView.setImageResource(Integer.parseInt(list.get(position).getImage()));

//      For Highlights Page ->
//        LayoutInflater inflater = (LayoutInflater) context
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View rowView = inflater.inflate(R.layout.highlights, parent, false);
//        TextView eventname = (TextView) rowView.findViewById(R.id.txtName);
//        ImageView imageView = (ImageView) rowView.findViewById(R.id.picdesc);
//
//        eventname.setText("Event Name "+ title[position]);
//        imageView.setImageResource(images[position]);

//        For Workshops ->
//        LayoutInflater inflater = (LayoutInflater) context
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View rowView = inflater.inflate(R.layout.workshops, parent, false);
//        TextView eventname = (TextView) rowView.findViewById(R.id.wtitle);
//        ImageView imageView = (ImageView) rowView.findViewById(R.id.picdesc);
//
//        eventname.setText("Workshop Name "+ title[position]);
//        imageView.setImageResource(images[position]);


        return rowView;

    }
}

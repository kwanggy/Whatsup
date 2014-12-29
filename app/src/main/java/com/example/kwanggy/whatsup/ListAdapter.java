package com.example.kwanggy.whatsup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kwanggy on 2014-12-26.
 */
public class ListAdapter extends BaseAdapter{
    private List<Market> mItems = new ArrayList<Market>();
    private LayoutInflater inflater;
    private final Context context;

    public ListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addItem(Market m) {
        mItems.add(m);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item,parent,false);
        TextView name = (TextView)rowView.findViewById(R.id.nameItem);
        TextView url = (TextView)rowView.findViewById(R.id.urlItem);
        ImageView icon = (ImageView)rowView.findViewById(R.id.iconItem);
        Market m = mItems.get(position);
        name.setText(m.getName());
        url.setText(m.getUrl());
        icon.setImageDrawable(m.getIcon());
        return rowView;
    }
}
 
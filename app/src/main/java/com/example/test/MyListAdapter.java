package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {
    private LayoutInflater LInflater;
    private ArrayList<DataFlags> list;

    public MyListAdapter(Context context, ArrayList<DataFlags> data) {

        list = data;
        LInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public DataFlags getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        View v = convertView;

        if (v == null) {
            holder = new ViewHolder();
            v = LInflater.inflate(R.layout.listview, parent, false);
            holder.flag = (ImageView) v.findViewById(R.id.flagImage);
            holder.name = (TextView) v.findViewById(R.id.name);
            holder.abbreviation = ((TextView) v.findViewById(R.id.abbreviation));
            v.setTag(holder);
        }

        holder = (ViewHolder) v.getTag();
        DataFlags dataFlags = getData(position);

        holder.flag.setImageResource(dataFlags.getFlagID());
        holder.name.setText(v.getResources().getString(dataFlags.getNameID()));
        holder.abbreviation.setText(v.getResources().getString(dataFlags.getAbbreviationID()));

        return v;
    }

    DataFlags getData(int position) {
        return (getItem(position));
    }

    private static class ViewHolder {
        private ImageView flag;
        private TextView name;
        private TextView abbreviation;
    }
}
package com.example.pondd.dessertmaker.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pondd.dessertmaker.view.DessertListItem;

/**
 * Created by Pondd on 12/25/14 AD.
 */
public class DessertListAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return 10000;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position){
        return position % 2 == 0?0 : 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (position % 2 == 0) {
            TextView item;
            if(convertView != null && convertView instanceof TextView)
                item = (TextView)convertView;
            else
                item = new TextView(parent.getContext());
            item.setText("RowCount"+position);
            return item ;
        } else {
            DessertListItem item;
            if (convertView != null && convertView instanceof DessertListItem)
                item = (DessertListItem) convertView;
            else
                item = new DessertListItem(parent.getContext());

            return item;
        }

    }
}

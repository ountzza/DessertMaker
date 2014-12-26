package com.example.pondd.dessertmaker.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pondd.dessertmaker.R;
import com.example.pondd.dessertmaker.dao.DessertItemDao;
import com.example.pondd.dessertmaker.manager.DessertItemManager;
import com.example.pondd.dessertmaker.view.DessertListItem;

/**
 * Created by Pondd on 12/25/14 AD.
 */
public class DessertListAdapter extends BaseAdapter {

    private int lastPosition = 1;

    @Override
    public int getCount() {
        if (DessertItemManager.getInstance().getData() == null)
            return 0;
        if (DessertItemManager.getInstance().getData().getData() == null)
            return 0;
        return DessertItemManager.getInstance().getData().getData().length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

//    @Override
//    public int getViewTypeCount() {
//        return 2;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        return position % 2 == 0 ? 0 : 1;
//    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DessertListItem item;
        if (convertView != null && convertView instanceof DessertListItem)
            item = (DessertListItem) convertView;
        else
            item = new DessertListItem(parent.getContext());


        //Set Data Here
        DessertItemDao dao = DessertItemManager.getInstance().getData().getData()[position];
        item.setTopText(dao.getName());
        item.setBottomText(dao.getDescription());
        item.setImageViewURL(dao.getImageUrl());

        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(parent.getContext(), R.anim.fly_up);
            item.startAnimation(animation);
            lastPosition = position;
        }
        return item;
    }
}

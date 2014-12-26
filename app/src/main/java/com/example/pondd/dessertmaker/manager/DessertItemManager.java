package com.example.pondd.dessertmaker.manager;

import android.content.Context;

import com.example.pondd.dessertmaker.dao.DessertItemCollectionDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class DessertItemManager {

    private static DessertItemManager instance;

    private DessertItemCollectionDao data;

    public static DessertItemManager getInstance() {
        if (instance == null)
            instance = new DessertItemManager();
        return instance;
    }

    private Context mContext;

    private DessertItemManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public DessertItemCollectionDao getData() {
        return data;
    }

    public void setData(DessertItemCollectionDao data) {
        this.data = data;
    }

}

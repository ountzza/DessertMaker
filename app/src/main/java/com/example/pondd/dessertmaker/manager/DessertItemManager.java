package com.example.pondd.dessertmaker.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.pondd.dessertmaker.dao.DessertItemCollectionDao;
import com.google.gson.Gson;
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
        loadData();
    }

    public DessertItemCollectionDao getData() {
        return data;
    }

    public void setData(DessertItemCollectionDao data) {
        this.data = data;
        saveData();
    }

    private void saveData(){
        String json = new Gson().toJson(data);

        SharedPreferences pref = mContext.getSharedPreferences("dessert", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("json",json);
        editor.commit();
    }
    private void loadData(){
        SharedPreferences pref = mContext.getSharedPreferences("dessert", Context.MODE_PRIVATE);
        String json = pref.getString("json","");
        if(json.equals(""))
            return;
        data = new Gson().fromJson(json,DessertItemCollectionDao.class);
    }

}

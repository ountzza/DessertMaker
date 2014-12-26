package com.example.pondd.dessertmaker.dao;

import com.google.gson.annotations.SerializedName;
import com.inthecheesefactory.thecheeselibrary.dao.BaseDao;

/**
 * Created by Pondd on 12/26/14 AD.
 */
public class DessertItemCollectionDao extends BaseDao {
    @SerializedName("data")
    private DessertItemDao[] data;

    public DessertItemDao[] getData() {
        return data;
    }

    public void setData(DessertItemDao[] data) {
        this.data = data;
    }


}

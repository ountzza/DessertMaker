package com.example.pondd.dessertmaker.manager.http;

import com.inthecheesefactory.thecheeselibrary.dao.BaseDao;

/**
 * Created by nuuneoi on 10/14/2014.
 */
public interface HTTPEngineListener<T extends BaseDao> {

    public void onResponse(T data, String rawData);

    public void onFailure(T data, String rawData);

}

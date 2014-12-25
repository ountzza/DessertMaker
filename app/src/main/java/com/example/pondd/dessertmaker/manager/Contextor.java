package com.example.pondd.dessertmaker.manager;

import android.content.Context;

/**
 * Created by nuuneoi on 12/6/14 AD.
 */
public class Contextor {

    private static Contextor instance;

    public static Contextor getInstance() {
        if (instance == null)
            instance = new Contextor();
        return instance;
    }

    private Context mContext;

    public void init(Context context) {
        mContext = context;
    }

    public Context getContext() {
        return mContext;
    }

}

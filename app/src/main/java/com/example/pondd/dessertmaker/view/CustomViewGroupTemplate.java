package com.example.pondd.dessertmaker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.inthecheesefactory.thecheeselibrary.R;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class CustomViewGroupTemplate extends RelativeLayout {

    private TextView tvName;

    public CustomViewGroupTemplate(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public CustomViewGroupTemplate(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs);
    }

    public CustomViewGroupTemplate(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs);
    }

    private void initInflate() {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.sample_layout, this);
    }

    private void initInstances() {
        tvName = (TextView) findViewById(R.id.tvName);
    }

    private void initWithAttrs(AttributeSet attrs) {

    }
}

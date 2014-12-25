package com.example.pondd.dessertmaker.manager;

import android.content.Context;
import android.graphics.Point;
import android.widget.ImageView;

import com.inthecheesefactory.thecheeselibrary.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

public class ImageLoaderManager {

    private static ImageLoaderManager instance;

    private Context mContext;

    public static ImageLoaderManager getInstance() {
        if (instance == null)
            instance = new ImageLoaderManager();
        return instance;
    }

    private ImageLoaderManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public void load(String url, ImageView imageView) {
        load(url, imageView, null);
    }

    public void load(int resId, ImageView imageView) {
        load(resId, imageView, null);
    }

    public void load(String url, Point size, ImageView imageView) {
        load(url, size, imageView, null);
    }

    public void load(int resId, Point size, ImageView imageView) {
        load(resId, size, imageView, null);
    }

    public void load(String url, ImageView imageView, Transformation transformation) {
        if (transformation == null) {
            Picasso.with(mContext)
                    .load(url)
                    .into(imageView);
        } else {
            Picasso.with(mContext)
                    .load(url)
                    .transform(transformation)
                    .into(imageView);
        }
    }

    public void load(int resId, ImageView imageView, Transformation transformation) {
        if (transformation == null) {
            Picasso.with(mContext)
                    .load(resId)
                    .into(imageView);
        } else {
            Picasso.with(mContext)
                    .load(resId)
                    .transform(transformation)
                    .into(imageView);
        }
    }

    public void load(String url, Point size, ImageView imageView, Transformation transformation) {
        if (url == null || url.isEmpty()) {
            load(R.drawable.darkgrayblank, size, imageView, transformation);
            return;
        }
        if (transformation == null) {
            Picasso.with(mContext)
                    .load(url)
                    .resize(size.x, size.y)
                    .centerCrop()
                    .into(imageView);
        } else {
            Picasso.with(mContext)
                    .load(url)
                    .resize(size.x, size.y)
                    .centerCrop()
                    .transform(transformation)
                    .into(imageView);
        }
    }

    public void load(int resId, Point size, ImageView imageView, Transformation transformation) {
        if (transformation == null) {
            Picasso.with(mContext)
                    .load(resId)
                    .resize(size.x, size.y)
                    .centerCrop()
                    .into(imageView);
        } else {
            Picasso.with(mContext)
                    .load(resId)
                    .resize(size.x, size.y)
                    .centerCrop()
                    .transform(transformation)
                    .into(imageView);
        }
    }
}

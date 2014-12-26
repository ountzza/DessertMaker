package com.example.pondd.dessertmaker.manager.http;

import android.content.Context;
import android.os.AsyncTask;

import com.example.pondd.dessertmaker.dao.DessertItemCollectionDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.inthecheesefactory.thecheeselibrary.dao.BaseDao;
import com.inthecheesefactory.thecheeselibrary.dao.TestDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;
import com.inthecheesefactory.thecheeselibrary.utils.Utils;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class HTTPEngine {

    private static HTTPEngine instance;

    public static HTTPEngine getInstance() {
        if (instance == null)
            instance = new HTTPEngine();
        return instance;
    }

    private Context mContext;
    private OkHttpClient client = new OkHttpClient();
    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();

    private HTTPEngine() {
        mContext = Contextor.getInstance().getContext();
    }


    private Map<String, String> getBaseData() {
        Map<String, String> postParams = new HashMap<String, String>();
        postParams.put("device_id", Utils.getInstance().getDeviceId());
        postParams.put("version", Utils.getInstance().getVersionName());
        return postParams;
    }

    public <T extends BaseDao> Call loadPostUrl(String url, Map<String, String> postData, final HTTPEngineListener<T> listener, final Class<T> tClass) {
        Map<String, String> postParams = getBaseData();
        if (postData != null) {
            for (Map.Entry<String, String> entry : postData.entrySet()) {
                postParams.put(entry.getKey(), entry.getValue());
            }
        }
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, mapToPostString(postParams));

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        client.setConnectTimeout(30, TimeUnit.SECONDS);
        client.setReadTimeout(30, TimeUnit.SECONDS);
        Call call = client.newCall(request);

        HTTPRequestData data = new HTTPRequestData();
        data.url = url;
        data.postData = postData;
        data.call = call;

        new HTTPRequestTask(new HTTPRequestListener() {
            @Override
            public void onMessageReceived(String message) {
                if (listener != null) {
                    String resp = message;
                    try {
                        T data = gson.fromJson(resp, tClass);
                        listener.onResponse(data, resp);
                    } catch (Exception e) {
                        e.printStackTrace();
                        T data = null;
                        try {
                            data = tClass.newInstance();
                            data.setSuccess(false);
                            data.setReason("Cannot parse JSON");
                        } catch (Exception e2) {
                        }
                        try {
                            listener.onFailure(data, resp);
                        } catch (Exception e2) {
                            listener.onFailure(data, "");
                        }
                    }
                }
            }

            @Override
            public void onMessageError(int statusCode, String message) {
                if (listener != null) {
                    T data = null;
                    try {
                        data = tClass.newInstance();
                        data.setSuccess(false);
                        data.setReason(statusCode + "");
                    } catch (Exception e2) {

                    }
                    listener.onResponse(data, "e.getMessage()");
                }
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, data);

        return call;
    }

    private String mapToPostString(Map<String, String> data) {
        StringBuilder content = new StringBuilder();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            if (content.length() > 0) {
                content.append('&');
            }
            try {
                content.append(URLEncoder.encode(entry.getKey(), "UTF-8"))
                        .append('=')
                        .append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return content.toString();
    }

    public Call loadTest(final HTTPEngineListener<TestDao> listener) {
        Map<String, String> postData = new HashMap<String, String>();
        return loadPostUrl("http://nuuneoi.com/test.php", postData, listener, TestDao.class);
    }

    ///////////////////////////////////////////
    // Warning:
    // Doesn't work for test, just a pattern
    ///////////////////////////////////////////

    public Call loadBlogList(int blogCategoryId, int beforeId, final HTTPEngineListener<BaseDao> listener) {
        Map<String, String> postData = new HashMap<String, String>();
        if (blogCategoryId >= 0)
            postData.put("blog_category_id", blogCategoryId + "");
        if (beforeId > 0)
            postData.put("before_id", beforeId + "");
        return loadPostUrl("http://nuuneoi.com/api/blog/list", postData, listener, BaseDao.class);
    }
    public Call loadDessertList(final HTTPEngineListener<DessertItemCollectionDao> listener){
        Map<String, String> postData = new HashMap<String, String>();
        return loadPostUrl("http://nuuneoi.com/courses/dessert_maker/list",postData,listener,DessertItemCollectionDao.class);
    }
}
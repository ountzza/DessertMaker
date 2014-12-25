package com.example.pondd.dessertmaker.manager.http;

import android.os.AsyncTask;

import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by nuuneoi on 10/20/2014.
 */
public class HTTPRequestTask extends AsyncTask<HTTPRequestData, Void, HTTPRequestTask.ContentMessage> {

    HTTPRequestListener mListener;

    public HTTPRequestTask(HTTPRequestListener aListener) {
        mListener = aListener;
    }

    @Override
    protected ContentMessage doInBackground(HTTPRequestData... params) {
        HTTPRequestData data = params[0];
        ContentMessage message = new ContentMessage();

        try {
            Response response = data.call.execute();
            if (response.isSuccessful()) {
                message.success = true;
                message.statusCode = response.code();
            } else {
                message.success = false;
                message.statusCode = response.code();
            }
            message.body = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            message.success = false;
        }

        return message;
    }

    @Override
    protected void onPostExecute(ContentMessage s) {
        super.onPostExecute(s);
        if (mListener != null) {
            if (s.success) {
                mListener.onMessageReceived(s.body);
            } else {
                mListener.onMessageError(s.statusCode, s.body);
            }
        }
    }

    public class ContentMessage {
        boolean success;
        int statusCode;
        String body;
    }
}

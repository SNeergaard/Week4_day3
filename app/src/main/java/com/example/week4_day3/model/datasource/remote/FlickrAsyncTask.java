package com.example.week4_day3.model.datasource.remote;

import android.os.AsyncTask;
import android.util.Log;

import com.example.week4_day3.model.Events.FlickrEvent;
import com.example.week4_day3.model.Flickr;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

public class FlickrAsyncTask extends AsyncTask<Void, String, Flickr> {
public static final String TAG = "TAG_ASYNC_TASK";

    @Override
    protected Flickr doInBackground(Void... voids) {
        try{
            String result = OkhttpHelper.executeSyncFlickr();
            Gson gson = new Gson();
            Flickr flickr = gson.fromJson(result,Flickr.class);
            return flickr;
        } catch (IOException e){
            publishProgress(e.toString());
            return null;
        }
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        Log.d(TAG, "onProgressUpdate: " + values[0]);
    }

    @Override
    protected void onPostExecute(Flickr flickr) {
        super.onPostExecute(flickr);
        EventBus.getDefault().post(new FlickrEvent(flickr));
    }
}

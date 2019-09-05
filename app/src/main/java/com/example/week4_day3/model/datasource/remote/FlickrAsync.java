package com.example.week4_day3.model.datasource.remote;

import android.os.AsyncTask;
import android.util.Log;

import com.example.week4_day3.model.Events.FlickrEvent;
import com.example.week4_day3.model.datasource.flickr.Flickr;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

public class FlickrAsync extends AsyncTask<void, String, Flickr> {
public static final String TAG = "TAG_ASYNC_TASK";

    @Override
    protected Flickr doInBackground(void... voids) {
        try{
            return OkhttpHelper.executeSyncOkHttpRequest();
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

package com.example.week4_day3.model.datasource.remote;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkhttpHelper {
    public static final String FLICKR_URL = "http://api.flickr.com/services/feeds/photos_public.gne?tag=kitten&format=json&nojsoncallback=1";

    public OkhttpHelper getClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BASIC);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    public String executeSyncOkHttpRequest() throws IOException {
        Request request = new Request.Builder().url(FLICKR_URL).build();
        Response response = getClient().newCall(request).execute();
        return response.body().string();
    }

    public void enqueueAsysncOkHttpRequest(){
        final Request request = new Request.Builder().url(FLICKR_URL).build();
        getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e){
                Log.e("OK_HELP", "error on request -->", e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String json = response.body().string();
                Gson gson = new Gson();
                EventBus.
            }
        });
    }


}

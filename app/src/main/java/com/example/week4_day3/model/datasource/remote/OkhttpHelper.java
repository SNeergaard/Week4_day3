package com.example.week4_day3.model.datasource.remote;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkhttpHelper {
    public static final String FLICKR_URL = "http://api.flickr.com/services/feeds/photos_public.gne?tag=kitten&format=json&nojsoncallback=1";

    public static OkHttpClient getClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }


    public static String executeSyncFlickr() throws IOException {

        Request request = new Request.Builder().url(FLICKR_URL).build();
        Response response = getClient().newCall(request).execute();
        return response.body().string();
    }




}

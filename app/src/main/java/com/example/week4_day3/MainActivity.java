package com.example.week4_day3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.week4_day3.model.Events.FlickrEvent;
import com.example.week4_day3.model.Flickr;
import com.example.week4_day3.model.FlickrRVAdapter;
import com.example.week4_day3.model.ItemsItem;
import com.example.week4_day3.model.datasource.remote.FlickrAsyncTask;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvFlickr;
    Flickr flickr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvFlickr = findViewById(R.id.rvFlickr);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvFlickr.setLayoutManager(layoutManager);

        new Runnable() {
            @Override
            public void run() {
                    new FlickrAsyncTask().execute();
            }
        }.run();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFlickrEvent(FlickrEvent event) {
        Log.d("TAG_MAIN", "onFlickrEvent: flickr:" + event.getFlickr().toString());
        flickr = event.getFlickr();
        List<ItemsItem> items = flickr.getItems();

        rvFlickr.setAdapter(new FlickrRVAdapter(items));
        rvFlickr.setLayoutManager(new LinearLayoutManager(this));
    }

}

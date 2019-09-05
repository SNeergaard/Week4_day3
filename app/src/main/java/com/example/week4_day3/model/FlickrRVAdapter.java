package com.example.week4_day3.model;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week4_day3.R;
import com.example.week4_day3.model.datasource.flickr.Flickr;

public class FlickrRVAdapter extends RecyclerView.Adapter<FlickrRVAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.flickr_item, parent, false);
        return new ViewHolder(inflatedItem);
    }

    @Override
    public void onBindViewHolder(@NonNull FlickrRVAdapter.ViewHolder holder, int position) {
        Flickr
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

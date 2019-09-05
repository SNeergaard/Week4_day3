package com.example.week4_day3.model;


import android.content.ClipData;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week4_day3.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FlickrRVAdapter extends RecyclerView.Adapter<FlickrRVAdapter.ViewHolder> {
    List<ItemsItem> resultList;

    public FlickrRVAdapter(List<ItemsItem> resultList) {
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.flickr_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ItemsItem currentItem = resultList.get(position);

        String title = currentItem.getTitle();
        String author = currentItem.getAuthor();
        String media = currentItem.getMedia().getM();

        holder.tvTitle.setText(title);
        holder.tvAuthor.setText(author);
        Picasso.get().load(media).into(holder.imgFlickr);

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvAuthor;
        ImageView imgFlickr;
        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            imgFlickr = itemView.findViewById(R.id.imgFlickr);
        }
    }
}

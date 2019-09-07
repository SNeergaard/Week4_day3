package com.example.week4_day3.model;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week4_day3.ImageActivity;
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
        holder.populateValues(currentItem);

    }


    @Override
    public int getItemCount() {
        return resultList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        TextView tvTitle;
        TextView tvAuthor;
        ImageView imgFlickr;
        ImageView imgSmall;
        String media;
        ItemsItem item;

    @Override
    public boolean onLongClick (final View view){

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle("Inflate Image");
        builder.setMessage("Select from the options bellow to inflate");


        // add the buttons
        builder.setPositiveButton("Large Inflate", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // todo add refernce
                Intent largeIntent = new Intent(view.getContext(), ImageActivity.class);
                String media = item.getMedia().getM();
                largeIntent.putExtra("media", media);
                view.getContext().startActivity(largeIntent);
            }
        });
        builder.setNegativeButton("Small inflate", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Dialog dialog = new Dialog(view.getContext());
                dialog.setContentView(R.layout.flicker_small_image);
                dialog.setCancelable(true);
                ImageView icon = dialog.findViewById(R.id.ivSmallImage);
                String media = item.getMedia().getM();
                Picasso.get().load(media).into(icon);
                dialog.show();
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
        return true;

    }

    public void setItem(ItemsItem item) {this.item = item; }

    private void populateValues(ItemsItem item){
        String title = item.getTitle();
        String author = item.getAuthor();
        String media = item.getMedia().getM();

        tvTitle.setText(title);
        tvAuthor.setText(author);
        setItem(item);

        Picasso.get().load(media).into(imgFlickr);
    }

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            imgFlickr = itemView.findViewById(R.id.imgFlickr);
            itemView.setOnLongClickListener(this);
        }

    }
}

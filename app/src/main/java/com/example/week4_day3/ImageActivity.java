package com.example.week4_day3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageActivity extends AppCompatActivity {
    ImageView ivLargeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Intent passedintent = getIntent();
        String picture = passedintent.getStringExtra("media");
        Log.d("pictureLOG", picture);
        bindViews();
        Picasso.get().load(picture).into(ivLargeImage);
    }

    private void bindViews(){
        ivLargeImage = findViewById(R.id.ivLargeImage);
    }

}

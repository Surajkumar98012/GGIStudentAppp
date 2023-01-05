package com.rnz.ggistudentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

public class fullimageView extends AppCompatActivity {

    private PhotoView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullimage_view);

        imageView=findViewById(R.id.imageViews);


        String image=getIntent().getStringExtra("Image");

        Picasso.get().load(image).into(imageView);
    }
}
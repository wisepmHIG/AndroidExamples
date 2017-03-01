package com.example.administrator.picassoex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);
        String url = "http://i.imgur.com/DvpvklR.png";
        // Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(imageView);
        Picasso.with(this)
                .load(url)
                .resize(150, 150)
                .centerCrop()
                .into(imageView);
    }
}

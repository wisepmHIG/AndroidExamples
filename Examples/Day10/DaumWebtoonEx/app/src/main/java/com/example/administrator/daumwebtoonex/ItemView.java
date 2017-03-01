package com.example.administrator.daumwebtoonex;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2017-02-12.
 */

public class ItemView extends LinearLayout {
    Context context;
    ImageView imageView;
    public ItemView(Context context,Item item) {
        super(context);
        this.context = context;
        LayoutInflater inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item,this,true);
        imageView = (ImageView)findViewById(R.id.iv);
        Picasso.with(context).load(item.getUrl()).into(imageView);
    }

    public void setImageView(String url) {
        Picasso.with(context).load(url).into(imageView);
    }
}

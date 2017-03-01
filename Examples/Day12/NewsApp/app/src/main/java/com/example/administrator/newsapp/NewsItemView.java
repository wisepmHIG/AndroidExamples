package com.example.administrator.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017-02-19.
 */
public class NewsItemView extends LinearLayout {
    TextView titleTV, descTV;

    public NewsItemView(Context context, NewsItem item) {
        super(context);
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.news_item, this, true);
        titleTV = (TextView) findViewById(R.id.titleTV);
        descTV = (TextView) findViewById(R.id.descTV);
        titleTV.setText(item.getTitle());
        descTV.setText(item.getDescription());
    }

    public void setTitleTV(String title) {
        this.titleTV.setText(title);
    }

    public void setDescTV(String desc) {
        this.descTV.setText(desc);
    }
}

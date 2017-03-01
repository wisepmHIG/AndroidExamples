package com.example.administrator.mycalendar;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-12-02.
 */

public class DaysView extends LinearLayout {
    TextView dayTV;
    public DaysView(final Context context, final Days days) {
        super(context);
        LayoutInflater inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.days,this);
        dayTV = (TextView)findViewById(R.id.dayTV);
        dayTV.setText(Html.fromHtml(days.getDay()));

        dayTV.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,days.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}

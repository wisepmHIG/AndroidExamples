package com.example.administrator.spinnerex02;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017-02-05.
 */

public class FlagView extends LinearLayout {
    ImageView imageView;
    TextView textView;

    public FlagView(Context context,Flag flag) {
        super(context);
        LayoutInflater inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.flag,this,true);
        imageView = (ImageView)findViewById(R.id.iv);
        imageView.setImageResource(flag.getImageID());
        textView = (TextView)findViewById(R.id.tv);
        textView.setText(flag.getFlagName());
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}

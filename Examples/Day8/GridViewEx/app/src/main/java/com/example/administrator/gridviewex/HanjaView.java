package com.example.administrator.gridviewex;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017-02-05.
 */

public class HanjaView extends LinearLayout{
    TextView tv1,tv2;

    public HanjaView(Context context, Hanja hanja) {
        super(context);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.hanja,this,true);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv1.setText(hanja.getHanja());
        tv2.setText(hanja.getHangul());
    }

    public void setTv1(TextView tv1) {
        this.tv1 = tv1;
    }

    public void setTv2(TextView tv2) {
        this.tv2 = tv2;
    }
}

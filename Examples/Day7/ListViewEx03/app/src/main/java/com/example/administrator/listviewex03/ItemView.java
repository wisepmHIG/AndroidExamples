package com.example.administrator.listviewex03;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017-02-04.
 */

public class ItemView extends LinearLayout {
    ImageView imageView;
    TextView textView1, textView2;

    public ItemView(Context context, Item item) {
        super(context);
        Log.i("인수 : ", item.toString());
        // 레이아웃을 읽어서 뷰를 생성한다.
        LayoutInflater inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item, this, true);
        // 뷰에서 위젯 찾고
        imageView = (ImageView)findViewById(R.id.iv);
        textView1 = (TextView)findViewById(R.id.tv1);
        textView2 = (TextView)findViewById(R.id.tv2);
        // 위젯에 데이터 적용시키고
        imageView.setImageResource(item.getImageID());
        textView1.setText(item.getTitle());
        textView2.setText(item.getContent());
    }

    public void setImageView(int imageID) {
        this.imageView.setImageResource(imageID);
    }

    public void setTextView1(String title) {
        this.textView1.setText(title);
    }

    public void setTextView2(String content) {
        this.textView2.setText(content);
    }
}

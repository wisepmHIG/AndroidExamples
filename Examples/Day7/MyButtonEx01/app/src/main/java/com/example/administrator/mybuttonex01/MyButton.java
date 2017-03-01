package com.example.administrator.mybuttonex01;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

public class MyButton extends Button {
    Context context;
    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        setBackgroundResource(R.drawable.title_bitmap_button_normal);
        setTextColor(Color.WHITE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            setBackgroundResource(R.drawable.title_bitmap_button_clicked);
            setTextColor(Color.BLACK);
        }else if(event.getAction()==MotionEvent.ACTION_UP) {
            setBackgroundResource(R.drawable.title_bitmap_button_normal);
            setTextColor(Color.WHITE);
        }
        return super.onTouchEvent(event);
    }
}

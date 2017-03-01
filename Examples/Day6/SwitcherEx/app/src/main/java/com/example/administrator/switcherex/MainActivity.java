package com.example.administrator.switcherex;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    ImageSwitcher is1;
    TextSwitcher ts1;
    int index;
    float downX, upX;
    String texts[] = {"한놈","두식이","석삼"};
    int images[] = {R.drawable.background,R.drawable.sample,R.drawable.sample_2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        is1 = (ImageSwitcher)findViewById(R.id.is1);
        is1.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                return imageView;
            }
        });
        is1.setInAnimation(this,android.R.anim.slide_in_left);
        is1.setOutAnimation(this,android.R.anim.slide_out_right);

        ts1 = (TextSwitcher) findViewById(R.id.ts1);
        ts1.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getApplicationContext());
                textView.setTextSize(40.f);
                textView.setTextColor(Color.YELLOW);
                textView.setGravity(Gravity.CENTER);
                return textView;
            }
        });
        ts1.setInAnimation(this,android.R.anim.fade_in);
        ts1.setOutAnimation(this,android.R.anim.fade_out);

        is1.setImageResource(images[index]);
        ts1.setText(texts[index]);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            downX = event.getX();
        }else  if(event.getAction() == MotionEvent.ACTION_UP){
            upX = event.getX();
            if(downX<upX){
                index--;
                if(index<0) index = images.length-1;
                is1.setImageResource(images[index]);
                ts1.setText(texts[index]);
            }else if(downX>upX){
                index++;
                if(index==images.length) index = 0;
                is1.setImageResource(images[index]);
                ts1.setText(texts[index]);
            }
        }
        return super.onTouchEvent(event);
    }
}

package com.example.administrator.viewflipperex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper viewFlipper;
    float downX,upX;
    Animation leftAnim,rightAnim;
    TextView textView[] = new TextView[4];
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFlipper = (ViewFlipper)findViewById(R.id.flipper);
        leftAnim = AnimationUtils.loadAnimation(this, R.anim.wallpaper_open_enter);
        rightAnim = AnimationUtils.loadAnimation(this, R.anim.wallpaper_open_exit);
        for(int i=0;i<textView.length;i++){
            textView[i] = (TextView)findViewById(R.id.tv1+i);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            downX = event.getX();
        }else if(event.getAction()==MotionEvent.ACTION_UP){
            upX = event.getX();
            if(downX<upX){
                viewFlipper.setInAnimation(rightAnim);
                viewFlipper.setOutAnimation(rightAnim);
                viewFlipper.showPrevious();
                index--;
                if(index<=-1) index = textView.length-1;
            }else{
                viewFlipper.setInAnimation(leftAnim);
                viewFlipper.setOutAnimation(leftAnim);
                viewFlipper.showNext();
                index++;
                if(index>= textView.length) index = 0;
            }
            for(int i=0;i<textView.length;i++) textView[i].setText("○");
            textView[index].setText("●");
        }
        return super.onTouchEvent(event);
    }
}

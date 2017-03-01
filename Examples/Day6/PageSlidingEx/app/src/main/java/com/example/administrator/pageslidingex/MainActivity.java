package com.example.administrator.pageslidingex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView slidingTV;
    Button slidingBtn;
    Animation leftAnim, rightAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slidingBtn = (Button)findViewById(R.id.btn);
        slidingTV = (TextView)findViewById(R.id.slidingTV);

        leftAnim = AnimationUtils.loadAnimation(this,R.anim.left);
        leftAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // 애니메이션 시작시 보이게 한다.
                slidingTV.setVisibility(View.VISIBLE);
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                // 애니메이션에 종료되면 버튼의제목을 변경한다.
                slidingBtn.setText("Close");
            }
            @Override
            public void onAnimationRepeat(Animation animation) { ; }
        });
        rightAnim = AnimationUtils.loadAnimation(this,R.anim.right);
        rightAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) { ; }
            @Override
            public void onAnimationEnd(Animation animation) {
                slidingBtn.setText("Open");
                slidingTV.setVisibility(View.INVISIBLE);
            }
            @Override
            public void onAnimationRepeat(Animation animation) { ; }
        });
    }
    public void slidingView(View view){
        if(slidingBtn.getText().toString().equalsIgnoreCase("Open")){
            slidingTV.startAnimation(leftAnim);
        }else{
            slidingTV.startAnimation(rightAnim);
        }
    }

    float downX, upX;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            downX = event.getX();
        }else if(event.getAction() == MotionEvent.ACTION_UP){
            upX = event.getX();
            if(downX < upX){
                slidingTV.startAnimation(rightAnim);
            }else{
                slidingTV.startAnimation(leftAnim);
            }
        }
        return super.onTouchEvent(event);
    }
}

package com.example.administrator.animationex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView1);
        animation = AnimationUtils.loadAnimation(this,R.anim.flow);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // 시작될때
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                // 끝날때
                Toast.makeText(getBaseContext(),"애니메이션종료!!!",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
                // 반복될때
            }
        });

        // 애니메이션을 시작한다.
        textView.startAnimation(animation);
    }
}

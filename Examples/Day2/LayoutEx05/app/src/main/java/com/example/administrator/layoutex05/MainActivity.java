package com.example.administrator.layoutex05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    // boolean toggle; 두장을 번갈아 보일거면 boolean으로 가능하다.
    // 그림이 여러장이면 int를 사용한다.
    int imageNum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);
    }

    public void changeImage(View view){
        /*
        if(!toggle)
            imageView.setImageResource(R.drawable.image02);
        else
            imageView.setImageResource(R.drawable.image01);
        toggle = !toggle;
        */
        imageNum++;
        imageView.setImageResource(R.drawable.dream01+imageNum%4);
    }
}

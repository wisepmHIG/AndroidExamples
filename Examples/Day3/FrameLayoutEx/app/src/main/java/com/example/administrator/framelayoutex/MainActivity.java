package com.example.administrator.framelayoutex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    // 객수가 많으니 배열로 선언하자
    ImageView[] imageViews = new ImageView[5];
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0;i<imageViews.length;i++)
            imageViews[i] = (ImageView)findViewById(R.id.img1+i);

    }
    // 이미지 바꾸기 메서드
    public void changeImage(View view){
        // 모두 숨기고 내거만 보이게하자
        for(int i=0;i<imageViews.length;i++)
            imageViews[i].setVisibility(View.INVISIBLE);
        index++;
        imageViews[index%5].setVisibility(View.VISIBLE);
    }
}

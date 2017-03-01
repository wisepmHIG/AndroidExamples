package com.example.administrator.senddataex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView dataTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dataTV = (TextView)findViewById(R.id.dataTV);

        // 메인 액티비티에서 넘어온 데이터를 받아보자.....
        Intent intent = getIntent(); // 모든 데이터의 전달은 인텐트를 통한다.
        /*
        // 하나하나씩 받는다
        String name = intent.getStringExtra("name");
        // 첫번째인수는 변수, 두번째 인수는 기본값
        int age = intent.getIntExtra("age", 0);
        */
        // 전체를 Bundle객체로 받은 다음 다시 읽어 들인다.
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        int age = bundle.getInt("age");

        dataTV.setText(name+"씨 " + age + "살이네 행님이라 불러!!!");
    }
    public void goBack(View view){
        finish();
    }
}

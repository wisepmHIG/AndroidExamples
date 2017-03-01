package com.example.administrator.layoutex02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void layoutView(View view){

        int id = view.getId(); // 이벤트가 발생한 뷰의 아이디를 얻는다.
        switch (id) {
            case R.id.exBtn1:
                // 새로운 창이나 다른곳으로 무언가를 전달할때는 무조건 인텐트를 이용한다.
                //  MainActivity2.class를 이용하여 새로운 액티비티를 띄운다.
                Intent intent = new Intent(this, MainActivity2.class);
                // 액티비티를 시작한다.
                startActivity(intent);
                break;
            case R.id.exBtn2:
                Intent intent2 = new Intent(this, MainActivity3.class);
                startActivity(intent2);
                break;

        }
    }
}

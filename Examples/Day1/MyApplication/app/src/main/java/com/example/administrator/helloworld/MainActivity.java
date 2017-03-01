package com.example.administrator.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button; // 1. 제어하고 싶은 위젯들은 필드로 선언한다.....

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn);// 2. 찾고
        // 3. 기능을 부여하고
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"왜눌러!!!",Toast.LENGTH_LONG).show();
            }
        });
    }

    // onClick을 지정하면 메서드를 작성하면 끝이다.
    public void showMessage(View view){
        Button btn = (Button)view;
        btn.setText("왜눌러 아프잖아");
    }

    // 네이버로가기
    public void goNaver(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(intent);
    }
    // 전화걸기
    public void phone(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel://010-1234-5687"));
        startActivity(intent);
    }
}

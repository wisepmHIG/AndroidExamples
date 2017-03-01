package com.example.administrator.inflateex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    LinearLayout mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout = (LinearLayout)findViewById(R.id.mainLayout);
    }
    public void appendView(View view){
        int id = view.getId();
        // 레이아웃을 실시간으로 읽어서 붙이려면
        // 시스템의 레이아웃 인플레터 기능을 사용한다.
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        mainLayout.removeAllViews(); // 이미있는 모든뷰를 지운다.
        switch (id){
            case R.id.btn1:
                // 레이아웃을 읽어서 객체화 시켜보자....
                inflater.inflate(R.layout.layout1, mainLayout);
                break;
            case R.id.btn2:
                inflater.inflate(R.layout.layout2, mainLayout);
                // 부분 레이아웃에 있는 위젯에 이벤트는 읽은(인플레트)후에 지정해야 한다...
                Button button = (Button)findViewById(R.id.btn4);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"나는 부분 레이아웃 버튼",Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case R.id.btn3:
                inflater.inflate(R.layout.layout3, mainLayout);
                break;
        }
    }
}

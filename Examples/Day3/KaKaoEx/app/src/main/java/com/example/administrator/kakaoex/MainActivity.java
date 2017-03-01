package com.example.administrator.kakaoex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 텍스트뷰배열
    TextView[] textViews = new TextView[4];
    // 글자수 세기
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 텍스트 뷰를 찾는다.
        for(int i=0;i<textViews.length;i++)
            textViews[i] = (TextView)findViewById(R.id.tv1+i);
    }
    // 버튼이벤트를 지정한다.
    public void btnClick(View view){
        // 버튼에 아이디를 주지 않았기 떄문에 버튼의 Text를 이용하여 판단하자
        Button button = (Button)view;
        String btnText = button.getText().toString();
        if(btnText.equals("☜")){
            // 지우기 버튼이면
            if(count>0) count--;
        }else{
            // 숫자버튼이라면
            if(count<textViews.length) count++;
        }
        // 텍스트뷰의 문자를 변경하자
        for(int i=0;i<textViews.length;i++) textViews[i].setText("○");
        for(int i=0;i<count;i++) textViews[i].setText("●");
    }
}

package com.example.administrator.layoutex02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    // 1. 코드에서 제어할 위젯들은 필드로 선언한다.
    EditText userIdET, passwordET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // 2. 선언한 필드들을 초기화 한다.
        userIdET = (EditText) findViewById(R.id.userIdET);
        passwordET = (EditText)findViewById(R.id.passwordET);
    }
    // 버튼에 이벤트를 지정한다.
    public void loginCheck(View view){
        String userId = userIdET.getText().toString();
        String password = passwordET.getText().toString();
        // 잠시 나타났다가 사라지는 메세지(컨텍스트,메세지, 시간)
        // 시간은 1/1000초 단위로 숫자를 지정해도 된다.
        Toast.makeText(this,userId+"("+password+")",Toast.LENGTH_LONG).show();
    }
    public void goBack(View view){
        finish(); // 창닫기
    }
}

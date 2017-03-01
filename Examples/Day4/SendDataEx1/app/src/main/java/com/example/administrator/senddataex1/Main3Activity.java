package com.example.administrator.senddataex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {
    EditText messageET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        messageET = (EditText)findViewById(R.id.messageET);
    }
    public void goBack(View view){
        // 데이터를 읽어서 보내주자......
        String message = messageET.getText().toString();
        Intent intent = new Intent();
        int resultCode = 0;
        if(message!=null && message.trim().length()>0){
            intent.putExtra("message", message.trim());
            resultCode = 1;
        }
        // 데이터를 호출한 액티비티로 보낸다......
        // 첫번째 인수는 성공여부를 두번째인수는 데이터가 담긴 인텐트
        setResult(resultCode, intent);

        // 창닫기
        finish();
    }
}

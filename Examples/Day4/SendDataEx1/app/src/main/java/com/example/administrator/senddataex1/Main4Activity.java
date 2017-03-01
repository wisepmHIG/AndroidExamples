package com.example.administrator.senddataex1;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

public class Main4Activity extends AppCompatActivity{
    EditText messageET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        messageET = (EditText)findViewById(R.id.messageET);

        Intent intent = getIntent();
        String hint = intent.getStringExtra("hint");
        messageET.setHint(hint);
        if(hint.startsWith("나이")){
            messageET.setInputType(InputType.TYPE_CLASS_NUMBER);
        }else{
            messageET.setInputType(InputType.TYPE_CLASS_TEXT);
        }
    }
    public void goBack(View view){
        // 데이터를 읽어서 보내주자......
        String message = messageET.getText().toString();
        Intent intent = new Intent();
        int resultCode = -1;
        if(message!=null && message.trim().length()>0){
            intent.putExtra("name", message.trim());
            resultCode = 0;
        }
        // 데이터를 호출한 액티비티로 보낸다......
        // 첫번째 인수는 성공여부를 두번째인수는 데이터가 담긴 인텐트
        setResult(resultCode, intent);
        // 창닫기
        finish();
    }
}

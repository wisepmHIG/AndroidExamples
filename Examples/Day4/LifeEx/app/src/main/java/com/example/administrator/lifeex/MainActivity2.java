package com.example.administrator.lifeex;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText messageET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        messageET = (EditText)findViewById(R.id.messageET);
    }

    public void goBack(View view){
        finish();
    }

    // 데이터를 저장하고
    @Override
    protected void onPause() {
        super.onPause();
        // 공유영역 객체를 얻는다. 이 앱에서만 사용가능하다.
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        // 수정가능한 Editor객체를 얻어낸다.
        SharedPreferences.Editor editor = preferences.edit();
        // 데이터를 저장한다.
        editor.putString("data",messageET.getText().toString());
        // 변경된 에디터객체를 적용시킨다.
        editor.commit();
    }
    // 데이터를 복원
    @Override
    protected void onResume() {
        super.onResume();
        // 공유영역 객체를 얻는다. 이 앱에서만 사용가능하다.
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        if(preferences!=null && preferences.contains("data")){ // data라는 변수가 존재하면 복원한다.
            String data = preferences.getString("data","기본값");
            messageET.setText(data);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity2", "onDestroy 실행됨");
    }

    
}

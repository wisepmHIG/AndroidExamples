package com.example.administrator.compex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText nameET, ageET;
    RadioButton radio1,radio2;
    CheckBox allDayChk;
    TextView resultTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameET = (EditText)findViewById(R.id.nameET);
        ageET = (EditText)findViewById(R.id.ageET);
        radio1 = (RadioButton)findViewById(R.id.radio1);
        radio2 = (RadioButton)findViewById(R.id.radio2);
        allDayChk = (CheckBox)findViewById(R.id.allDayChk);
        resultTV = (TextView) findViewById(R.id.resultTV);
    }
    public void chkToggle(View view){
        if(allDayChk.isChecked())
            allDayChk.setChecked(false);
        else
            allDayChk.setChecked(true);
    }
    public void resultView(View view){
        StringBuilder sb = new StringBuilder();
        String name = nameET.getText().toString();
        if(name!=null && name.trim().length()>0){ // 이름이 입력되었다면
            sb.append("이름 : " + name + "\n");
        }
        String age = ageET.getText().toString();
        if(age!=null && age.trim().length()>0){ // 나이가 입력되었다면
            sb.append("나이 : " + age + "\n");
        }
        sb.append("성별 : " + (radio1.isChecked()?"남자":"여자") + "\n");
        sb.append((allDayChk.isChecked()?"하루종일":"반나절만") + " 일을 합니다.\n");

        // 결과를 텍스트뷰에 뿌린다.
        resultTV.setText(sb.toString());
    }

}

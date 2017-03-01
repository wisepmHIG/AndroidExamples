package com.example.administrator.listviewex04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = (TextView)findViewById(R.id.tv);

        // 넘어온 한자정보 받기
        Intent intent = getIntent();
        Chunja2 chunja2 = intent.getParcelableExtra("data");

        // 텍스트뷰에 뿌리기
        textView.append(chunja2.getIdx()+"\n");
        textView.append(chunja2.getH() + "\n");
        textView.append(chunja2.getK() + "\n");
        textView.append(chunja2.getWord() + "\n");
        textView.append(chunja2.getDesc() + "\n");

    }
    public void goBack(View view){
        finish();
    }
}

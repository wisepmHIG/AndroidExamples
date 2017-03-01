package com.example.administrator.gridviewex;

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
        textView = (TextView)findViewById(R.id.hanjaTV);

        // 데이터 받기
        Hanja hanja = getIntent().getParcelableExtra("hanja");
        textView.setText(hanja.toString());
    }

    public void goBack(View view){
        finish();
    }
}

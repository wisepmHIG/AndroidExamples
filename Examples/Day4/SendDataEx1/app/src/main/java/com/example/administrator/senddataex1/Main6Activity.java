package com.example.administrator.senddataex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        textView = (TextView)findViewById(R.id.dataTV);
        Intent intent = getIntent();
        Person person = intent.getParcelableExtra("data");
        textView.setText(person.toString());
    }
    public void goBack(View view){
        finish();
    }
}

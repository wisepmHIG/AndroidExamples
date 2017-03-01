package com.example.administrator.layoutex03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void layoutView(View view){
        int id = view.getId();
        switch (id){
            case R.id.btn1:
                Intent intent = new Intent(this,MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                Intent intent2 = new Intent(this,MainActivity3.class);
                startActivity(intent2);
                break;
        }
    }
}

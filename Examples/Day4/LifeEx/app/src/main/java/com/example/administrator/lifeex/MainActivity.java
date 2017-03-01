package com.example.administrator.lifeex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate 실행");
    }
    public void myActivityView(View view){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart 실행");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume 실행");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause 실행");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop 실행");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart 실행");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy 실행");
    }
}

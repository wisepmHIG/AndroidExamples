package com.example.administrator.threadex01;

import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements Runnable{
    TextView textView;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.timeTV);
        // 폰트를 변경하자
        Typeface type = Typeface.createFromAsset(this.getAssets(), "ds_digib.ttf");
        textView.setTypeface(type);
        handler = new Handler();
        // new Thread(this).start(); // Runnable 인터페이스를 구현했을 경우의 스레드 시작!!!!

        new TimeThread().start(); // Thread를 상속받았을 경우의 스레드 시작
    }
    public void viewTime(View view){
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        textView.setText(sdf.format(new Date()));
    }

    @Override
    public void run() {
        while (true){
            handler.post(new Runnable() {
                @Override
                public void run() {
                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                    textView.setText(sdf.format(new Date()));
                }
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    // 스레드를 상속받아 스레드를 작성
    class TimeThread extends Thread{
        @Override
        public void run() {
            super.run();
            while(true) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                        textView.setText(sdf.format(new Date()));
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

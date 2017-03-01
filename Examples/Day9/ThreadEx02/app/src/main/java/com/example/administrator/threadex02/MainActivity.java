package com.example.administrator.threadex02;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView progressTV;
    ProgressBar progressBar;
    ProgressHandler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressTV = (TextView)findViewById(R.id.progressTV);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        handler = new ProgressHandler();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 스레드 시작
        new Thread(new Runnable() {
            int value=0;
            @Override
            public void run() {
                while(value<=progressBar.getMax()){
                    value++;
                    // 스레드에서 메인스레드로 데이터를 전달하는 방법
                    // 핸들러를 통하여 메인스레드에서 메세지 객체를 얻어온다,
                    Message message = handler.obtainMessage();
                    // 데이터를 전달하기 위하여 번들객체를 생성
                    Bundle bundle = new Bundle();
                    // 전달할 데이터를 번들객체에 저장을 한다.
                    bundle.putInt("value",value);
                    // 번들객체를 메세지 객체에 대입
                    message.setData(bundle);
                    // 핸들러를 통하여 메세지를 전달
                    handler.sendMessage(message); // 이렇게 호출하면 핸들러의 handleMessage가 호출이된다.
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    // 다른 스레드에서 데이터를 전달받고 싶다면 Hnadler객체를 상속받아
    // handleMessage메서드를 오버라이딩한다.
    class ProgressHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            // 여기서 UI를 갱신한다.
            Bundle bundle = msg.getData();
            int value = bundle.getInt("value");
            progressBar.setProgress(value);
            if(value < progressBar.getMax())
                progressTV.setText("진행중 : " + value + "%");
            else
                progressTV.setText("진행완료!!!!");
        }
    }
}

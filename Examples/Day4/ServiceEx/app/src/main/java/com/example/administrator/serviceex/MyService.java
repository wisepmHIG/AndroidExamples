package com.example.administrator.serviceex;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service implements Runnable{
    int count=0;
    public MyService() {
        Thread thread = new Thread(this); // 스레드 생성
        thread.setDaemon(true); // 데몬스레드(앱종료시 스레드도 종료해라)로 지정
        thread.start(); // 스레드 시작
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void run() {
        // 여기에 백그라운드로 실행시키고 싶은 내용을 적는다.
        do {
            try {
                Log.i("MyService", ++count + "번째 호출");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while(count<10);
    }
}

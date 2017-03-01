package com.example.administrator.progressbarex;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    ProgressDialog progressDialog;
    ProgressDialog progressDialog2;
    Handler handler;
    SeekBar seekBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        textView = (TextView)findViewById(R.id.tv1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText("현재 값 : " + seekBar.getProgress());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int value = seekBar.getProgress();
                if(value<100)
                    value = 100;
                // 화면 밝기 변경하기
                WindowManager.LayoutParams params = getWindow().getAttributes();
                params.screenBrightness = value/1000;
                getWindow().setAttributes(params);
            }
        });

        progressBar = (ProgressBar) findViewById(R.id.pbar);
        progressBar.setProgress(0);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                progressDialog2.incrementProgressBy(1);
            }
        };
    }

    public void progressValue(View view) {
        progressBar.incrementProgressBy(5);
        if (progressBar.getProgress() == progressBar.getMax()) progressBar.setProgress(0);
    }

    public void progressOpen(View view) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("데이터를 확인중입니다.");
        progressDialog.show();
    }

    public void progressClose(View view) {
        progressDialog.dismiss();
    }

    public void progressDlg(View view) {
        progressDialog2 = new ProgressDialog(this);
        progressDialog2.setMax(100);
        progressDialog2.setMessage("로딩중");
        progressDialog2.setTitle("프로그래스바 연습");
        progressDialog2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog2.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressDialog2.getProgress() <= progressDialog2.getMax()) {
                    try {
                        Thread.sleep(50); // 일시 정지
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.sendMessage(handler.obtainMessage()); // 화면을 갱신하시오
                    if (progressDialog2.getProgress() == progressDialog2.getMax()) {
                        progressDialog2.dismiss(); // 닫기
                    }
                }
            }
        }).start();
    }


}

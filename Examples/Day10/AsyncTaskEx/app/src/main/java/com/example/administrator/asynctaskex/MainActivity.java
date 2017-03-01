package com.example.administrator.asynctaskex;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ProgressBar progressBar;
    ProgressTask task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.progressTV);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
    }
    public void startProgress(View view){
        task = new ProgressTask();
        task.execute(progressBar.getMax());
    }
    public void stopProgress(View view){
        task.cancel(true);
    }
    // <background 자료형, update자료형,post자료형>
    class ProgressTask extends AsyncTask<Integer, Integer, Void>{
        int value;
        // 스레드로 처리할 내용을 doInBackground메서드에 기술
        @Override
        protected Void doInBackground(Integer... params) {
            int max = params[0];
            while (value <= max) {
                value++;
                publishProgress(value); // 이 메서드를 호출하면 onProgressUpdate가 실행
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    ;
                }
            }
            return null;
        }
        // 아래의 3개 메서드는 메인스레드에서 작동되므로 UI갱신이 가능하다...
        // 스레드 시작전에 처리할 내용 onPreExecute메서드에 기술
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.i("Task", "onPreExecute 실행");
        }
        // 스레드 중간 중간에 처리할 내용 onProgressUpdate메서드에 기술
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.i("Task", "onProgressUpdate 실행");
            progressBar.setProgress(values[0]);
            textView.setText(String.format("진행상태 : %d%%", values[0]));
        }
        // 스레드 작업이 종료되었을때  처리할 내용 onPostExecute메서드에 기술
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.i("Task", "onPostExecute 실행");
            textView.setText("진행상태 : 완료");
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            value = 0;
            progressBar.setProgress(value);
            textView.setText("진행상태 : 취소");
        }
    }
}

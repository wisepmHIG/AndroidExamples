package com.example.administrator.mycalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    GridView gridView;
    int year,month, week, lastday;
    List<Days> list = new ArrayList<>();
    DaysAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
        // 현재 년월
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        // year=1845;
        month = calendar.get(Calendar.MONTH)+1;
        textView.setText(String.format("%4d년 %02d월",year,month));

        gridView = (GridView)findViewById(R.id.gridView);
        changeDate(); // 년/월이 변경되면 배열의 내용이 변경된다.
        adapter = new DaysAdapter(this,list);
        gridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void changeDate() {
        week = CalUtil.getWeek(year, month, 1);
        lastday = CalUtil.getLastDay(year, month); // 월의 마지막 날짜!!!
        // 1일의 요일을 맞추기 위해서 공백 추가
        list.clear();
        Log.d("달력", list.toString());
        for (int i = 1; i < week; i++) list.add(new Days(""));
        // 1일부터 마지막 날짜까지 날짜 넣기
        for (int i = 1; i <= lastday; i++) {
            week = CalUtil.getWeek(year, month, i);
            if (week == 1) {
                list.add(new Days("<span style='color:red;'>" + i + "</span>"));
            } else if (week == 7) {
                list.add(new Days("<span style='color:blue;'>" + i + "</span>"));
            } else {
                list.add(new Days(i + ""));
            }
        }
        Log.d("달력", list.toString());
    }
    public void prevYear(View view){
        year--;
        if(year<=0) year=1;
        textView.setText(String.format("%4d년 %02d월",year,month));
        changeDate();
        adapter.notifyDataSetChanged();
    }
    public void prevMonth(View view){
        month--;
        if(month==0){
            year--;
            if(year<=0) year=1;
            month=12;
        }
        textView.setText(String.format("%4d년 %02d월",year,month));
        changeDate();
        adapter.notifyDataSetChanged();

    }
    public void nextYear(View view){
        year++;
        textView.setText(String.format("%4d년 %02d월",year,month));
        changeDate();
        adapter.notifyDataSetChanged();
    }
    public void nextMonth(View view){
        month++;
        if(month==13){
            year++;
            month=1;
        }
        textView.setText(String.format("%4d년 %02d월",year,month));
        changeDate();
        adapter.notifyDataSetChanged();
    }
}

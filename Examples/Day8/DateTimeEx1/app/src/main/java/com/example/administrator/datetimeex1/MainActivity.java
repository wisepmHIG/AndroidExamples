package com.example.administrator.datetimeex1;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    TextView dateTV,timeTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTV = (TextView)findViewById(R.id.dateTV);
        timeTV = (TextView)findViewById(R.id.timeTV);
    }
    public void setDate(View view){
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dateTV.setText(String.format("%d년 %d월 %d일",year,month+1,dayOfMonth));
            }
        }, 2017, 0, 1).show();
    }
    public void setTime(View view){
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                timeTV.setText(String.format("%d시 %d분",hourOfDay,minute));
            }
        }, 1, 1, false).show();
    }
}

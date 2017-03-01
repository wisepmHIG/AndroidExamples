package com.example.administrator.spinnerex02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] datas = "abkhazia,afghanistan,aland,albania,algeria,american Samoa,andorra".split("\\,");
    Spinner spinner;
    ImageView imageView;
    ArrayList<Flag> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);
        spinner = (Spinner)findViewById(R.id.sp);

        // 데이터 준비
        list = new ArrayList<>();
        for(int i=0;i<datas.length;i++){
            list.add(new Flag(R.drawable.abkhazia+i,datas[i]));
        }

        // 어뎁터 준비
        FlagAdapter adapter = new FlagAdapter(this,list);
        spinner.setAdapter(adapter);

        // 리스너 등록
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(list.get(position).getImageID());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}

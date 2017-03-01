package com.example.administrator.gridviewex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<Hanja> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 행열로 여러개의 데이터를 출력하는 위젯
        gridView = (GridView)findViewById(R.id.gridView);

        // 데이터 읽기
        list = ReadHanja.read(this);

        // 어뎁터 작성
        HanjaAdapter adapter = new HanjaAdapter(this,list);

        // 어뎁터 적용
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(),Main2Activity.class);
                intent.putExtra("hanja", list.get(position));
                startActivity(intent);
            }
        });

    }
}

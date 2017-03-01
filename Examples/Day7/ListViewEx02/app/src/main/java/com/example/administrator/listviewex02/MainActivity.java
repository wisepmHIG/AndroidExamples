package com.example.administrator.listviewex02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    // 두줄로 나오기위한 자료형
    ArrayList<HashMap<String,String>> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);

        // 데이터준비
        for(int i=1;i<=20;i++){
            HashMap<String,String> map = new HashMap<>();
            map.put("title","제목 " + i);
            map.put("content", "나는 세부 내용 " + i);
            list.add(map);
        }
        // 첫번째 인수 : Context
        // 두번째 인수 : 데이터
        // 첫번째 인수 : 리소스아이디
        // 첫번째 인수 : 맵의키 배열
        // 첫번째 인수 : 값을보일 리소스 아이디 배열
        SimpleAdapter adapter = new SimpleAdapter(this,list,android.R.layout.simple_list_item_2,
                                                 new String[]{"title","content"},
                                                 new int[]{android.R.id.text1,android.R.id.text2}
                                                 );
        listView.setAdapter(adapter);
    }
}

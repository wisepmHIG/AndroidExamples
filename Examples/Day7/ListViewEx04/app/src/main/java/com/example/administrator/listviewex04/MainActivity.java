package com.example.administrator.listviewex04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Chunja2> list = new ArrayList<>();
    ArrayList<String> list2 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        // 데이터를 읽자......
        // assets폴더의 파일 읽는 방법
        try {
            InputStream is = getAssets().open("chunja2.txt");
            Scanner sc = new Scanner(is,"UTF-8");
            while(sc.hasNextLine()){
                // 1개읽기
                StringTokenizer st = new StringTokenizer(sc.nextLine(),"|");
                Chunja2 chunja2 = new Chunja2();
                chunja2.setIdx(Integer.parseInt(st.nextToken()));
                chunja2.setH(st.nextToken());
                chunja2.setK(st.nextToken());
                chunja2.setWord(st.nextToken());
                chunja2.setDesc(st.nextToken());
                // 리스트에 추가
                list.add(chunja2);
                list2.add(chunja2.getH() + "(" + chunja2.getK() + ")");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list2);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                intent.putExtra("data", list.get(position));
                startActivity(intent);
            }
        });

    }


}

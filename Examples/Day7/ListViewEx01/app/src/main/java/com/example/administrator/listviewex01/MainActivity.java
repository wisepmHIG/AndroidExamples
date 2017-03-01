package com.example.administrator.listviewex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String data[] = "하나,둘,셋,넷,다섯,여섯,일곱,여덟,아홉,열,열하나,열둘,열셋,열넷".split("\\,");
    List<String> list = Arrays.asList(data);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);

        // 배열이나 리스트는 별도의 어뎁터를 만들지 않고
        // 안드로이드에서 제공하는 ArrayAdapter를 이용하면 된다.

        // 리소스에 저장된 배열 읽기
        data = getResources().getStringArray(R.array.datas);

        // 배열데이터
//        ArrayAdapter<String> adapter =
//                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, data);

        // 리스트의 모양을 변경해보자!!!!
//        ArrayAdapter<String> adapter =
//                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice, data);
//        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice, data);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        // 리스트 데이터
        // ArrayAdapter<String> adapter =
        //         new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list);

        // 어뎁터를 리스트뷰에 적용시킨다.
        listView.setAdapter(adapter);

        // 리스너를 등록한다.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 setTitle(data[position]);    // 배열일 경우
                // setTitle(list.get(position));   // 리스트일 경우
            }
        });
    }
}

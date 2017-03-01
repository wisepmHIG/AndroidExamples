package com.example.administrator.listviewex05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ExpandableListView listView;

    // 부모
    ArrayList<String> parentList = new ArrayList<>();
    // 자식들의 집합
    ArrayList<ArrayList<String>> childList = new ArrayList<>();
    // 각각의 자식들
    ArrayList<String>[] lists = new ArrayList[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ExpandableListView)findViewById(R.id.elv_list);

        // 데이터를 준비하자!!!!
        parentList.add("첫번째 부모");
        parentList.add("두번째 부모");
        parentList.add("세번째 부모");
        for(int i=0;i<lists.length;i++){
            lists[i] = new ArrayList<>();
            for(int j=0;j<=i;j++){
                lists[i].add( i+1 + "의 자식 " + (j+1));
            }
            childList.add(lists[i]);
        }

        BaseExpandableAdapter adapter = new BaseExpandableAdapter(this,parentList,childList);
        listView.setAdapter(adapter);

    }
}

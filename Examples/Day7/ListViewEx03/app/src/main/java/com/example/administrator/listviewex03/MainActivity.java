package com.example.administrator.listviewex03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Item> list = new ArrayList<>();
    // ItemAdapter adapter;
    ItemAdapter2 adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        // 어뎁터에 데이터 넣기
        for(int i=0;i<8;i++){
            Item item = new Item(R.drawable.apples_001+i,"제목 " + i, "내용이다~~ " + i);
            list.add(item);
        }

        // 베이스어뎁터를 생속받은 어뎁터 생성
        // ItemAdapter adapter = new ItemAdapter(this,list);

        // 어레이 어뎁터를 상속받은 어뎁터를 생성
        adapter = new ItemAdapter2(this,R.layout.item,list);

        // 붙이기
        listView.setAdapter(adapter);


    }

    public void addData(View view){
        list.add(new Item(R.drawable.apples_009,"추가","추가된데이터"));
        // 어뎁터를 붙이고 데이터가 변경되면 변경된 데이터가 적용되지 않는다.
        // 반드시 notifyDataSetChanged()를 호출해야 변경된 데이터가 적용된다.
        adapter.notifyDataSetChanged();
    }
}

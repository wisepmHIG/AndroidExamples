package com.example.administrator.daumissuerank;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        new DaumTask().execute(); // 태스크 실행
    }
    class DaumTask extends AsyncTask<Void,Void,Void>{
        ArrayList<String> list;
        ArrayList<String> linkList;
        @Override
        protected Void doInBackground(Void... params) {
            list = new ArrayList<>();
            linkList = new ArrayList<>();
            String addr = "http://www.daum.net";
            Document doc = null;
            try {
                // 연결
                doc = Jsoup.connect(addr).get();
                // id값이 realTimeSearchWord인 태그를 찾아서 그안에있는 li태그들을 얻는다.
                Elements elements = doc.select("#realTimeSearchWord li");
                // li태그 하나씩 반복한다.
                for(Element element : elements){
                    String rank = element.select("span.ir_wa").get(0).text();
                    String text = element.select("a").get(0).text();
                    String link = element.select("a").get(0).attr("href");

                    Log.i("읽기", rank + ". " + text );
                    list.add(rank + ". " + text);
                    linkList.add(link);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(getApplicationContext(),
                                            android.R.layout.simple_list_item_1,list);
            listView.setAdapter(adapter);
            // 이벤트 지정
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkList.get(position)));
                    startActivity(intent);
                }
            });
        }
    }

}

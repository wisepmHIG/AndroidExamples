package com.example.administrator.ddanjirss;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView titleTV;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleTV = (TextView)findViewById(R.id.titleTV);
        listView = (ListView)findViewById(R.id.listView);
        new NewsRSS().execute();
    }
    class NewsRSS extends AsyncTask<Void,Void,Void>{
        ArrayList<String> titleList;
        ArrayList<String> linkList;
        String title;
        @Override
        protected Void doInBackground(Void... params) {
            titleList = new ArrayList<>();
            linkList = new ArrayList<>();

            Document doc = null;
            try {
                doc = Jsoup.connect("http://rss.hankyung.com/new/news_main.xml").get();
                title = doc.select("rss>channel>description").text();
                Elements elements = doc.select("item");
                for(Element element : elements){
                    titleList.add(element.select("title").text());
                    linkList.add(element.select("link").text());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            titleTV.setText(title);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                                              android.R.layout.simple_list_item_1,titleList);
            listView.setAdapter(adapter);
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

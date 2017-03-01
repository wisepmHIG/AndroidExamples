package com.example.administrator.newsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    ListView listView;
    ArrayList<ETNews> newsList = new ArrayList<>();
    ArrayList<NewsItem> newsItemList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner)findViewById(R.id.spinner);
        listView = (ListView)findViewById(R.id.listView);

        // 일단 스피너를 만들자........
        newsList.add(new ETNews("뉴스속보", "http://rss.etnews.co.kr/Section902.xml"));
        newsList.add(new ETNews("오늘의 인기기사", "http://rss.etnews.co.kr/Section903.xml"));
        newsList.add(new ETNews("오늘의 추천기사", "http://rss.etnews.co.kr/Section904.xml"));
        newsList.add(new ETNews("통신방송", "http://rss.etnews.co.kr/Section031.xml"));
        newsList.add(new ETNews("네트워크", "http://rss.etnews.co.kr/Section034.xml"));
        newsList.add(new ETNews("정보화", "http://rss.etnews.co.kr/Section041.xml"));
        newsList.add(new ETNews("솔루션", "http://rss.etnews.co.kr/Section042.xml"));
        newsList.add(new ETNews("보안", "http://rss.etnews.co.kr/Section045.xml"));

        ArrayList<String> list = new ArrayList<>();
        for(ETNews news : newsList) list.add(news.getCategory());

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String link = newsList.get(position).getLink();
                Toast.makeText(getBaseContext(),link,Toast.LENGTH_SHORT).show();
                new NewsTask().execute(link); // 뉴스를 읽는다.
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {;}
        });
    }
    class NewsTask extends AsyncTask<String,Void,Void>{
        @Override
        protected Void doInBackground(String... params) {
            String link = params[0];
            newsItemList.clear(); // 뉴스가 담겨져있는 리스트를 비운다.
            try {
                URL url = new URL(link);
                XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
                parser.setInput(url.openStream(),"UTF-8");
                boolean isItem=false,isTitle=false,isDesc=false,isLink=false;
                int type = parser.getEventType();
                String tagName="";
                NewsItem item = null;
                while (type!=XmlPullParser.END_DOCUMENT){
                    switch (type){
                        case XmlPullParser.START_TAG:
                            tagName = parser.getName();
                            if(tagName.equals("item")) { isItem = true; item = new NewsItem();}
                            if(tagName.equals("title")) { isTitle = true; }
                            if(tagName.equals("description")) { isDesc = true; }
                            if(tagName.equals("link")) { isLink = true; }
                            break;
                        case XmlPullParser.END_TAG:
                            tagName = parser.getName();
                            if(tagName.equals("item")) { isItem = false;  newsItemList.add(item);}
                            if(tagName.equals("title")) { isTitle = false; }
                            if(tagName.equals("description")) { isDesc = false; }
                            if(tagName.equals("link")) { isLink = false; }
                            break;
                        case XmlPullParser.TEXT:
                            if(isItem && isTitle) item.setTitle(parser.getText());
                            if(isItem && isDesc) item.setDescription(parser.getText());
                            if(isItem && isLink) item.setLink(parser.getText());
                            break;
                    }
                    type = parser.next();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            NewsAdapter adapter = new NewsAdapter(getBaseContext(),newsItemList);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent =
                            new Intent(Intent.ACTION_VIEW, Uri.parse(newsItemList.get(position).getLink()));
                    startActivity(intent);
                }
            });
        }
    }
}

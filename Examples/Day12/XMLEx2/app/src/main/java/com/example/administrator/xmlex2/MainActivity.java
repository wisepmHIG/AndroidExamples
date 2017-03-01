package com.example.administrator.xmlex2;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String clientId = "1jh20MqFv_cJxHsv7xCg";//애플리케이션 클라이언트 아이디값";
    String clientSecret = "4D3gThuZVl";//애플리케이션 클라이언트 시크릿값";
    EditText searchET;
    ListView searchList;
    List<Item> list = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchET = (EditText)findViewById(R.id.searchET);
        searchList = (ListView)findViewById(R.id.searchList);
    }
    public void search(View view){
        String str = searchET.getText().toString(); // 검색어 얻기
        if(str!=null&&str.trim().length()>0){
            new SearchTask().execute(str);
        }
    }
    class SearchTask extends AsyncTask<String,Void,Void>{
        StringBuffer response = new StringBuffer();
        @Override
        protected Void doInBackground(String... params) {
            String searchString = params[0];
            try {
                String text = URLEncoder.encode(searchString, "UTF-8");
                //String apiURL = "https://openapi.naver.com/v1/search/blog?query="+ text; // json 결과
                String apiURL = "https://openapi.naver.com/v1/search/news.xml?query="+ text; // xml 결과
                URL url = new URL(apiURL);
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("X-Naver-Client-Id", clientId);
                con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
                int responseCode = con.getResponseCode();
                /*
                BufferedReader br;
                if(responseCode==200) { // 정상 호출
                    br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                } else {  // 에러 발생
                    br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                }
                String inputLine;
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                */
                String title="", link="";
                boolean isTitle=false, isLink=false, isItem = false;
                String tagName="";
                XmlPullParser pullParser = XmlPullParserFactory.newInstance().newPullParser();
                pullParser.setInput(con.getInputStream(),"UTF-8");
                int type = pullParser.getEventType();
                Item item = null;
                while(type!=XmlPullParser.END_DOCUMENT){
                    switch (type){
                        case XmlPullParser.START_TAG:
                            tagName = pullParser.getName();
                            if(tagName.equals("item")){
                                item = new Item();
                                isItem = true;
                            }
                            if(tagName.equals("title")) isTitle = true;
                            if(tagName.equals("link")) isLink = true;
                            break;
                        case XmlPullParser.END_TAG:
                            tagName = pullParser.getName();
                            if(tagName.equals("item")){
                                list.add(item);
                                isItem = false;
                            }
                            if(tagName.equals("title")) isTitle = false;
                            if(tagName.equals("link")) isLink = false;
                            break;
                        case XmlPullParser.TEXT:
                            String data = pullParser.getText();
                            if(isItem && isTitle) item.setTitle(data);
                            if(isItem && isLink) item.setLink(data);
                            break;
                    }
                    type = pullParser.next();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ArrayList<String> arrayList = new ArrayList<>();
            for(Item item : list){
                arrayList.add(item.getTitle());
            }

            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,arrayList);
            searchList.setAdapter(adapter);
            searchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(list.get(position).getLink()));
                    startActivity(intent);
                }
            });
        }
    }
}

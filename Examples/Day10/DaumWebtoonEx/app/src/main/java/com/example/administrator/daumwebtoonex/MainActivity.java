package com.example.administrator.daumwebtoonex;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView)findViewById(R.id.gridView);
        new ViewTask().execute();
    }
    class ViewTask extends AsyncTask<Void,Void,Void>{
        ArrayList<Item> itemList = new ArrayList<>();
        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document doc = Jsoup.connect("http://land.hankyung.com/").get();
                Elements imgs = doc.select("img");
                for(Element element : imgs){
                    itemList.add(new Item(element.attr("src")));
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ItemAdapter adapter = new ItemAdapter(getApplicationContext(),itemList);
            gridView.setAdapter(adapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(getApplicationContext(),itemList.get(position).getUrl(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

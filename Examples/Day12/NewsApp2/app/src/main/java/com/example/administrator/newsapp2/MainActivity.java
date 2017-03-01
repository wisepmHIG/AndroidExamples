package com.example.administrator.newsapp2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = (TextView)findViewById(R.id.textView1);
        String addr = "http://rss.ohmynews.com/rss/ohmynews.xml";
        NewsTask task = new NewsTask();
        task.execute(addr);
    }
    class NewsTask extends AsyncTask<String,Void,Void> {
        Rss rss;
        @Override
        protected Void doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                InputStream is = url.openStream();
                Serializer serializer = new Persister();
                rss = serializer.read(Rss.class, is);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            textView1.setText(rss.getChannel().getTitle()+"\n");
            for(Item i : rss.getChannel().getItem()){
                textView1.append(i.getTitle() + "\n");
            }
        }
    }
}

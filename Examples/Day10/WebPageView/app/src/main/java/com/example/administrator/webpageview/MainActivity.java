package com.example.administrator.webpageview;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText addrET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.viewTV);
        addrET = (EditText)findViewById(R.id.addr);
    }
    public void viewSource(View view){
        String addr = addrET.getText().toString();
        new SourceTask().execute(addr);
    }

    class SourceTask extends AsyncTask<String,Void,Void>{
        StringBuffer sb = new StringBuffer();
        @Override
        protected Void doInBackground(String... params) {
            String addr = params[0];
            try {
                URL url = new URL(addr);
                Scanner scanner = new Scanner(url.openStream(),"UTF-8");
                while (scanner.hasNextLine())
                    sb.append(scanner.nextLine());
                scanner.close();
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
            textView.setText(sb.toString());
        }
    }
}

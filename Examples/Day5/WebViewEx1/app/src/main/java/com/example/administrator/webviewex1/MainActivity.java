package com.example.administrator.webviewex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText urlAddr;
    WebView  webView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlAddr = (EditText)findViewById(R.id.urlAddr);
        webView1 = (WebView)findViewById(R.id.webView1);
        // 웹뷰를 셑팅
        WebSettings settings = webView1.getSettings();
        settings.setJavaScriptEnabled(true); // 자바스크립트 사용가능
        webView1.setWebViewClient(new WebViewClient()); // 웹뷰 클라이언트 지정
        webView1.loadUrl("file:///android_asset/www/index.html");
    }
    public void gotoURL(View view){
        // 주소 읽기
        String url = urlAddr.getText().toString();
        webView1.loadUrl(url); // 지정 주소를 보여줘~~~~
    }
}

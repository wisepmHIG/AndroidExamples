package com.example.administrator.webviewex2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

/**
 * 웹뷰를 화면안에 넣고 앱과 웹 사이에 상호 호출하는 기능을 알아볼 수 있습니다.
 *
 * @author Mike
 */
public class MainActivity extends AppCompatActivity {
    private WebView webview;    // 웹뷰
    private Button loadButton;  // 버튼
    EditText urlInput;
    private Handler mHandler = new Handler(); // 핸들러 객체

    // 아래의 어노테이션이 안드로이드에서 만든 자바 클래스를 웹페이지에서 사용가능하도록 연결
    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 에디트텍스트 찾기
        urlInput = (EditText) findViewById(R.id.urlInput);
        // 웹뷰 객체 참조
        webview = (WebView) findViewById(R.id.webview);
        // 웹뷰 설정 정보
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient());

        // 자바클래스를 HTML의 window객체의  자식 객체 sample로 등록한다.
        // 이후 HTML에서는 window.sample.메서드() 형태로 자바메서드를 호출가능하다.
        webview.addJavascriptInterface(new JavaScriptMethods(), "sample");

        // assets 폴더에 있는 메인 페이지 로딩
        webview.loadUrl("file:///android_asset/www/sample.html");


        // 버튼 이벤트 처리
        loadButton = (Button) findViewById(R.id.loadButton);
        loadButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 입력한 URL의 페이지 로딩
                webview.loadUrl(urlInput.getText().toString());
            }
        });

    }

    /**
     * 자바스크립트 함수를 호출하기 위한 클래스 정의
     */
    public class JavaScriptMethods {
        JavaScriptMethods() {
        }
        @android.webkit.JavascriptInterface
        public void clickOnFace() {
            mHandler.post(new Runnable() {
                public void run() {
                    // 버튼의 텍스트 변경
                    loadButton.setText("클릭후열기"); // 안드로이드 위젯
                    // 안드로이드에서 자바스크립트 함수 호출
                    webview.loadUrl("javascript:changeFace()");
                }
            });
        }
        @android.webkit.JavascriptInterface
        public void clickOnFace2() {
            mHandler.post(new Runnable() {
                public void run() {
                    urlInput.setHint("힌트를 주자!!");
                }
            });
        }
    }
}

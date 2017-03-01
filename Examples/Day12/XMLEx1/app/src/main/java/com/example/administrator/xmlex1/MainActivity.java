package com.example.administrator.xmlex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        list = new ArrayList<>();
        /*
        // 리소스의 XML파일을 파서로 읽는다.
        XmlPullParser pullParser = getResources().getXml(R.xml.data);

        // XML 파싱을 한다.
        try {
            int eventType = pullParser.getEventType(); // 이벤트 타입을 읽는다.
            // 문서의 끝에도달할 때까지 반복
            String data="";
            boolean isName = false;
            String tagName="";
            while(eventType!= XmlPullParser.END_DOCUMENT){
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        // 여는 태그를 만났을때
                        tagName = pullParser.getName();
                        if(tagName.equals("name")){
                            data = pullParser.getAttributeValue(0) + ". ";
                            isName = true;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        // 닫는 태그를 만났을때
                        tagName = pullParser.getName();
                        if(tagName.equals("name")){
                            isName = false;
                            list.add(data);
                        }
                        break;
                    case XmlPullParser.TEXT:
                        // 텍스트를 만났을때
                        if(isName){
                            data += pullParser.getText();
                        }
                        break;
                }
                eventType = pullParser.next();// 다음 으로 진행
            }
            */

            XmlPullParser parser = getResources().getXml(R.xml.users);
            String name="",age="",gender="",tagName="";
            boolean isName=false,isAge=false,isGender=false;

        try {
            int eventType = parser.getEventType();
            while(eventType!=XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        tagName = parser.getName();
                        if(tagName.equals("name")) isName = true;
                        if(tagName.equals("age")) isAge = true;
                        if(tagName.equals("gender")) isGender = true;
                        break;
                    case XmlPullParser.END_TAG:
                        tagName = parser.getName();
                        if(tagName.equals("name")) isName = false;
                        if(tagName.equals("age")) isAge = false;
                        if(tagName.equals("gender")) isGender = false;
                        if(tagName.equals("user")){
                            list.add(name + "(" + age + "세," + gender + ")");
                        }
                        break;
                    case XmlPullParser.TEXT:
                        if(isName) name = parser.getText();
                        if(isAge) age = parser.getText();
                        if(isGender) gender = parser.getText();
                        break;
                }
                eventType = parser.next();
            }
        } catch (XmlPullParserException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ArrayAdapter<String> adapter =
        new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);


    }
}

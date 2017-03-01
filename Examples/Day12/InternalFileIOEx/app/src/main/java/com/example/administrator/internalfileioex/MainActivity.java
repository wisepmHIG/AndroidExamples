package com.example.administrator.internalfileioex;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView,textView2;
    String fileName = "test.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.contentET);
        textView = (TextView)findViewById(R.id.contentTV);
        textView2 = (TextView)findViewById(R.id.fileList);
    }
    public void save(View view){
        String str = editText.getText().toString();
        if(str!=null && str.trim().length()>0){
            // 내용이 있을때만 저장한다.
            FileOutputStream outputStream = null;
            try {
                // openFileOutput메서드 : 파일객체의 출력스트림을 리턴
                outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                outputStream.write((str+"\n").getBytes()); // 쓰기
                outputStream.write("하하하하\n".getBytes()); // 쓰기
                outputStream.write("호호호호\n".getBytes()); // 쓰기
                outputStream.write("히히히히히히히히히\n".getBytes()); // 쓰기
                outputStream.write("ㅋㅋㅋㅋㅋㅋㅋㅋ\n".getBytes()); // 쓰기
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 저장된 파일목록 알아내기
            File file = getFilesDir();
            File[] files = file.listFiles(); // 파일목록
            for(File f : files){ // 반복
                textView2.append(f.getName() + "\n");
                textView2.append(f.getAbsolutePath() + "\n");
            }
        }
    }
    public void load(View view){
        FileInputStream inputStream = null;
        try {
            // openFileInput메서드 : 파일객체의 입력스트림을 리턴
            inputStream = openFileInput(fileName);
            /*
            byte[] datas = new byte[1024];
            inputStream.read(datas); // 읽기
            // 바이트 배열을 스트링으로 변경해서 출력
            textView.setText(new String(datas));
            */
            Scanner sc = new Scanner(inputStream,"UTF-8");
            while(sc.hasNextLine()){
                textView.append(sc.nextLine() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

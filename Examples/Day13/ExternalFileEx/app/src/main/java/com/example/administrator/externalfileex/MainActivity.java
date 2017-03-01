package com.example.administrator.externalfileex;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button saveBtn, readBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.contentTV);
        saveBtn = (Button)findViewById(R.id.saveBtn);
        readBtn = (Button)findViewById(R.id.readBtn);
        // 두개 버튼을 사용 못하게 한다.
        saveBtn.setEnabled(false);
        readBtn.setEnabled(false);
        // 권한을 요청한다.
        checkPermission();
    }
    public void saveFile(View view){
        String content = editText.getText().toString().trim();
        if(content.length()>0) {
            PrintWriter pw = null;
            // 외부기억 장치의 절대 경로를 얻어온다.
            String path = Environment.getExternalStorageDirectory().getAbsolutePath();
            Log.d("절대경로",path);
            String filename = "sample.txt";
            File file = new File(path, filename);
            try {
                pw = new PrintWriter(file);
                pw.write(content + "\n");
                pw.flush();
                editText.setText("");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                if(pw!=null) pw.close();
            }
        }
    }
    public void readFile(View view){
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        String filename = "sample.txt";
        File file = new File(path, filename);
        try {
            Scanner sc = new Scanner(file,"UTF-8");
            textView.setText("");
            while(sc.hasNextLine()){
                textView.append(sc.nextLine() + "\n");
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /*
    마시멜로버전 이후에 권한 요청하는 메소드
     */
    private void checkPermission() {
        // 버젼이 M이상이라면
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 권한이 있는지 여부를 판단한다.
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED
                    || checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                // 권한이 없다면.....
                // 설치후 권한을 제거했을 경우에 처리하는 내용을 기술한다.
                if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    Toast.makeText(this, "외부기억 장소에 접근하려면 권한을 부여해야 합니다.", Toast.LENGTH_SHORT).show();
                }
                // 권한을 요청한다. 요청을하면 반드시 콜백메소드를 만들어 주어야 한다.
                // onRequestPermissionsResult메소드가 콜백 메소드이다.
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1004);
            } else {
                // 다음 부분은 항상 허용일 경우에 해당이 됩니다.
                // 권한이 있다면 두개버튼 모두 활성화
                saveBtn.setEnabled(true);
                readBtn.setEnabled(true);
            }
        }
    }
    // 콜백함수
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1004:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    // 권한을 허락했을때 코드......
                    saveBtn.setEnabled(true);
                    readBtn.setEnabled(true);
                } else {
                    // 권한을 거부 했을때 코드......
                    saveBtn.setEnabled(false);
                    readBtn.setEnabled(false);
                }
                break;
        }
    }
}

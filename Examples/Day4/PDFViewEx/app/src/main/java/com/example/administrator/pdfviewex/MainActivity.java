package com.example.administrator.pdfviewex;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    EditText filenameET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filenameET = (EditText)findViewById(R.id.filenameET);

        // 마시멜로 이상의 버전에서는 반드시 권한요청을 해주어야 한다.
        checkDangerousPermissions();
    }
    public void viewPDF(View view){
        String filename = filenameET.getText().toString();
        if(filename!=null && filename.trim().length()>0){
            File file = new File(filename.trim());
            if(file.exists()){
                Uri uri = Uri.fromFile(file);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(uri, "application/pdf");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                try {
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(this,"PDF 뷰어가 없습니다.",Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this,"파일이 존재하지 않습니다.",Toast.LENGTH_SHORT).show();
                filenameET.setText("");
                filenameET.requestFocus(); // 커서를 옮겨라
            }
        }else{
            Toast.makeText(this,"파일명을 입력하시오",Toast.LENGTH_SHORT).show();
            filenameET.setText("");
            filenameET.requestFocus(); // 커서를 옮겨라
        }
    }

    // 권한을 요청
    private void checkDangerousPermissions() {
        // checkSelfPermission() : 권한을 검사하는 메서드
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int permissionCheck2 = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        // 권한이 부여되어 있으면
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
        } else {
            // 권한이 없으면
            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();

            // shouldShowRequestPermissionRationale() : 설치시 권한을 주고 나중에 권한을 해제한 경우
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Toast.makeText(this, "권한 설명 필요함.", Toast.LENGTH_LONG).show();
            } else {
                // 최초 설치시
                String[] permissions = {
                        android.Manifest.permission.READ_EXTERNAL_STORAGE,
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                };
                // requestPermissions() : 권한을 요청한다.
                // 이메서드는 onRequestPermissionsResult() 콜백메서드를 작성해야 한다.
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
    }

    // 권한 요청에 응답하면 처리를 담당하는 메서드
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, permissions[i] + " 권한이 승인됨.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, permissions[i] + " 권한이 승인되지 않음.", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

}

package com.example.administrator.dialogex;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void viewSnackbar(View view){
        Snackbar.make(view, "하하하하 내가 스넥바다~~~", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public void viewDialog(View view){
        int id = view.getId();
        // 대화상자를 만들기 위해서는 대화상자를 만들어주는 빌더 객체를 이용해야 한다.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("대화상자제목");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setMessage("표시할 메세지를 입력한다.");
        // 이제 버튼을 만든다.
        switch (id){
            case R.id.btn3:
                builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(),"취소를 눌렀냐(" + which + ")",Toast.LENGTH_SHORT).show();
                    }
                });
            case R.id.btn2:
                builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(),"아니오를 눌렀냐(" + which + ")",Toast.LENGTH_SHORT).show();
                    }
                });
            case R.id.btn1:
                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(),"예를 눌렀냐(" + which + ")",Toast.LENGTH_SHORT).show();
                    }
                });
        }
        // 띄운다.
        builder.create().show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

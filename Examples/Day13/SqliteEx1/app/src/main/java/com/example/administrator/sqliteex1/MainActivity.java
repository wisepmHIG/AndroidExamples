package com.example.administrator.sqliteex1;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // SQLiteDatabase 객체
    SQLiteDatabase db;
    EditText nameET, ageET;
    ListView resultList;
    SimpleCursorAdapter adapter;
    TextView _idTV;
    Button saveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameET = (EditText)findViewById(R.id.nameET);
        ageET = (EditText)findViewById(R.id.ageET);
        resultList = (ListView)findViewById(R.id.resultList);
        _idTV = (TextView)findViewById(R.id._idTV);
        saveBtn = (Button) findViewById(R.id.saveBtn);
        open();
        selectData();
    }
    /*
    public void selectData(View view){
        resultTV.setText("");
        String sql = "select * from addr order by _id desc"; // _id 역순으로 가져와라
        Cursor cursor = db.rawQuery(sql,null); // 커서로 받는다.
        if(cursor!=null) { // 데이터가 있다면
            resultTV.setText(cursor.getCount() + "개의 데이터가 있습니다.\n");
            while(cursor.moveToNext()) { // moveToNext() : 다음 레코드로 이동 없으면 false리턴
                int _id = cursor.getInt(0); // 인덱스가 0부터다~~~~
                String name = cursor.getString(1); // 커서를 통해서 읽기
                int age = cursor.getInt(2);
                resultTV.append(_id + ". " + name + "(" + age + "세)\n");
            }
            cursor.close();
        }else{
            resultTV.setText("데이터 없다");
        }
    }
    */
    public void insertData(View view){
        String btnTitle = ((Button)view).getText().toString();
        Log.d("버튼 타이틀",btnTitle);
        // 에디트 텍스트의 내용을 읽어서 테이블에 저장하자
        String name = nameET.getText().toString();
        String age = ageET.getText().toString();
        if(name!=null && name.trim().length()>0 && age!=null && age.trim().length()>0){

            if(btnTitle.equals("데이터 저장하기")) {
                String sql = "insert into addr (name,age) values (";
                sql += "'" + name + "'," + age + ")";
                db.execSQL(sql); // 저장
            }else{
                // 수정
                String _id = _idTV.getText().toString().split(":")[1]; // 글번호 읽기
                String sql = "update addr set name='" + name + "', age=" + age + " where _id=" + _id;
                db.execSQL(sql);
                saveBtn.setText("데이터 저장하기");
                _idTV.setText("글번호 : 0");
            }
            nameET.setText(""); // 저장한 내용 지우고
            ageET.setText("");
            nameET.requestFocus(); // 포커스를 이동
            selectData();
        }
    }
    /*
    public void createDB(View view){
        // 데이터베이스 작성하기
        db = openOrCreateDatabase("my.db", MODE_PRIVATE,null);
        // 명령 만들고 IF NOT EXISTS 는 존재하면 만들지 않는다.
        String sql = "create table IF NOT EXISTS addr(";
        sql += " _id integer primary key autoincrement,";
        sql += " name varchar(50) not null,";
        sql += " age integer default 0)";
        // 명령 실행 : 테이블 작성하고
        db.execSQL(sql);

    }
    */
    private void open(){
        // 데이터베이스 작성하기
        db = openOrCreateDatabase("my.db", MODE_PRIVATE,null);
        // 명령 만들고 IF NOT EXISTS 는 존재하면 만들지 않는다.
        String sql = "create table IF NOT EXISTS addr(";
        sql += " _id integer primary key autoincrement,";
        sql += " name varchar(50) not null,";
        sql += " age integer default 0)";
        // 명령 실행 : 테이블 작성하고
        db.execSQL(sql);
    }
    private void selectData(){
        String sql = "select * from addr order by _id desc"; // _id 역순으로 가져와라
        final Cursor cursor = db.rawQuery(sql,null); // 커서로 받는다.
        String[] cols = {"_id","name","age"};
        int[] ids = {R.id.idTV,R.id.nameTV,R.id.ageTV};

        adapter = new SimpleCursorAdapter(this,R.layout.person,cursor,cols,ids);
        resultList.setAdapter(adapter);
        resultList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 커서를 클릭한곳으로 이동
                cursor.moveToPosition(position);
                // 데이터 읽기
                int idx = cursor.getInt(0);
                String name = cursor.getString(1);
                int age = cursor.getInt(2);

                //String msg = id + ". " + name + "(" + age +"세)";
                //Toast.makeText(getBaseContext(),msg,Toast.LENGTH_SHORT).show();
                saveBtn.setText("데이터 수정하기"); // 버튼제목을 수정하기로 변경
                // 데이터를 표시
                _idTV.setText("글번호 : " + idx);
                nameET.setText(name);
                ageET.setText(age+"");
            }
        });
        // 길게 누르면 삭제하자
        resultList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // 커서를 클릭한곳으로 이동
                cursor.moveToPosition(position);
                // 데이터 읽기
                int idx = cursor.getInt(0);
                String name = cursor.getString(1);
                int age = cursor.getInt(2);

                String sql = "delete from addr where _id=" + idx;
                db.execSQL(sql);
                selectData();
                return true;
            }
        });
    }
}

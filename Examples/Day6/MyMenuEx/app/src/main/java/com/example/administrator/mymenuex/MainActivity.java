package com.example.administrator.mymenuex;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (LinearLayout)findViewById(R.id.activity_main);

        btn1 = (Button)findViewById(R.id.btn1);
        registerForContextMenu(btn1); // 컨텍스트 메뉴를 등록한다.
    }
    // 옵션메뉴 만들기
    // 리소스에 메뉴파일을 작성하고 두개의 메서드를 오버라이딩 해야 한다.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu); // 메뉴를 만든다.
        menu.add(0,4,100,"메뉴 4");
        return super.onCreateOptionsMenu(menu);
    }
    // 메뉴를 선택하면 처리하는 내용
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menu1:
                Toast.makeText(this,"첫번째 메뉴를 선택함!!!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu2:
                Toast.makeText(this,"두번째 메뉴를 선택함!!!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu3:
                Toast.makeText(this,"세번째 메뉴를 선택함!!!",Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this,"네 번째 메뉴 선택함!!!", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // 이놈은 선택 적으로 만든다 ..... 메뉴가 나타나기 전에 선행처리할 내용을 적는다.
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.getItem(2).setEnabled(false);
        return super.onPrepareOptionsMenu(menu);
    }
    // 컨텍스트 메뉴 : 길게 누를때 나타나는 메뉴!!!! 반드시 등록을 해주어야 한다.
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // getMenuInflater().inflate(R.menu.menu, menu);

        menu.setHeaderTitle("따이뜰");
        menu.add(0,1,100,"빨강");
        menu.add(0,2,100,"녹색");
        menu.add(0,3,100,"파랑");
        // Menu에 SubMenu 추가
        SubMenu subMenu = menu.addSubMenu("하우스과일");
        subMenu.add(1, 4, Menu.NONE, "방울토마토");
        subMenu.add(1, 5, Menu.NONE, "하우스딸기");
        subMenu.add(1, 6, Menu.NONE, "애호박");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case 1:
                layout.setBackgroundColor(Color.RED);
                break;
            case 2:
                layout.setBackgroundColor(Color.GREEN);
                break;
            case 3:
                layout.setBackgroundColor(Color.BLUE);
                break;
            default:
                Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    // 팝업메뉴 : 클릭하면 나타나는 메뉴
    public void popupView(View view){
        PopupMenu popupMenu = new PopupMenu(this,view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.menu, popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.menu1:
                        Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu2:
                        Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu3:
                        Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }


}

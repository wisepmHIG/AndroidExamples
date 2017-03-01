package com.example.administrator.senddataex1;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendData(View view){
        int id = view.getId();
        switch (id){
            case R.id.btn1:
                // 새로운 창으로 데이터를 보내보자......
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                // 인텐트에 데이터를 넣는다.
                intent.putExtra("name","한사람");
                intent.putExtra("age",33);
                startActivity(intent);
                break;
            case R.id.btn2:
                Intent intent1 = new Intent(getApplicationContext(),Main3Activity.class);
                // 결과를 받으려면 startActivityForResult메서드로 액티비티를 띄워야 한다.
                // onActivityResult() 콜백 메서드를 반드시 작성해 주셔야 한다.
                // 콜백 메서드 setResult를 호출하면 작동이 된다.
                int requestCode = 1004; // 어디에서 띄운것인지 판단하기 위한 번호. 사용자 임의로 지정
                startActivityForResult(intent1, requestCode);
                break;
            case R.id.btn3:
                Intent intent2 = new Intent(getApplicationContext(),Main4Activity.class);
                intent2.putExtra("hint","이름을 입력하세요");
                requestCode = 1005;
                startActivityForResult(intent2, requestCode);
                break;
            case R.id.btn4:
                Intent intent3 = new Intent(getApplicationContext(),Main4Activity.class);
                intent3.putExtra("hint","나이를 입력하세요");
                requestCode = 1006;
                startActivityForResult(intent3, requestCode);
                break;
            case R.id.btn5:
                Intent intent4 = new Intent(getApplicationContext(),Main5Activity.class);
                // 객체를 인텐트에 담아 보내려면 반드시 직렬화/역직렬화를 구현해야 한다.
                // 자바에서는 Serializable 인터페이스를 구현하면 된다.
                SimpleData data = new SimpleData("한사람",22);
                intent4.putExtra("data",data);
                startActivity(intent4);
                break;
            case R.id.btn6:
                Intent intent5 = new Intent(getApplicationContext(),Main6Activity.class);
                // 객체를 인텐트에 담아 보내려면 반드시 직렬화/역직렬화를 구현해야 한다.
                // 안드로이드에서는 Parcelable인터페이스를 구현해줘야만 한다.
                Person person = new Person("신사임당",18);
                intent5.putExtra("data",person);
                startActivity(intent5);
                break;
        }
    }
    // 콜백 메서드
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 받아주는 메서드는 1개다 그렇다면 어느 창에서 넘어온 것인지를 판단해야 한다.
        // 첫번째 인수가 어떤 창인지를 나타내는 requestCode다!!!!
        switch (requestCode){
            case 1004:
                // 전달된 결과코드 별로 처리 내용을 기술한다.
                switch (resultCode){
                    case 0:
                        // 실패이다.
                        Toast.makeText(getApplicationContext(),"데이터 없다",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        // 성공이다. 그럼 데이터를 받자!!!!!
                        String msg = data.getStringExtra("message");
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
            case 1005:
                switch (resultCode){
                    case -1:
                        Toast.makeText(getApplicationContext(),"이름이 입력되지 않았습니다.",Toast.LENGTH_SHORT).show();
                        break;
                    case 0:
                        String name = data.getStringExtra("name");
                        Toast.makeText(getApplicationContext(), name + "씨 방가방가~~~", Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
            case 1006:
                switch (resultCode){
                    case -1:
                        Toast.makeText(getApplicationContext(),"나이가 입력되지 않았습니다.",Toast.LENGTH_SHORT).show();
                        break;
                    case 0:
                        try {
                            String name = Integer.parseInt(data.getStringExtra("name"))>=20 ? "성인이네" :"애들은가라";
                            Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                        }catch(Exception e){
                            // 에러가나도 아무짓도 안할거다....
                        }
                        break;
                }
                break;
        }
    }
}

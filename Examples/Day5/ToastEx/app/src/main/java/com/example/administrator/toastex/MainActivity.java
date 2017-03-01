package com.example.administrator.toastex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText offsetX, offsetY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        offsetX = (EditText)findViewById(R.id.offsetX);
        offsetY = (EditText)findViewById(R.id.offsetY);
    }
    public void viewToast1(View view){
        try {
            int x = Integer.parseInt(offsetX.getText().toString());
            int y = Integer.parseInt(offsetY.getText().toString());
            Toast toast = Toast.makeText(this,"난 어디에 나타날까?",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,x,y);
            toast.show();
        }catch (Exception e){
            // 숫자로 변경시 에러가 발생하면 그냥 지우기만 하겠다.
            offsetX.setText("");
            offsetY.setText("");
        }
    }
    public void viewToast2(View view){
        // 내가 만든 뷰로 토스트 띄우기
        LayoutInflater layoutInflater = getLayoutInflater();
        View layout = layoutInflater.inflate(R.layout.toast_layout,
                                            (ViewGroup)findViewById(R.id.layout));
        TextView textView = (TextView) layout.findViewById(R.id.text1);
        Toast toast = new Toast(getApplicationContext());
        textView.setText("난 어떤 모양!!!");
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        // toast.setView(layout);

        // Button button = new Button(this);
        // button.setText("토스트로 보이는 버튼");
        // toast.setView(button);

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.images2);
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.setView(imageView);

        toast.show();
    }
}

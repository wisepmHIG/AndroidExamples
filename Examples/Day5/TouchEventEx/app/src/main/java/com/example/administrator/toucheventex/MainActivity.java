package com.example.administrator.toucheventex;

import android.content.res.Configuration;
import android.gesture.GestureUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView infoTV;
    GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        infoTV = (TextView)findViewById(R.id.infoTV);
        gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener(){
            // 필요한 메서드를 오버라이딩 해서 처리한다.
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                infoTV.append("onScroll 이벤트 발생 : ");
                infoTV.append(distanceX + ", " + distanceY + "\n");
                return super.onScroll(e1, e2, distanceX, distanceY);
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                infoTV.append("onFling 이벤트 발생 : ");
                infoTV.append(velocityX + ", " + velocityY + "\n");
                return super.onFling(e1, e2, velocityX, velocityY);
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                infoTV.append("onDoubleTap 이벤트 발생\n");
                return super.onDoubleTap(e);
            }

            @Override
            public void onLongPress(MotionEvent e) {
                super.onLongPress(e);
                infoTV.setText("");
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(gestureDetector!=null)
            return gestureDetector.onTouchEvent(event); // 이벤트 처리를 GestureDetector에게 위임한다.
        else
            return super.onTouchEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i("키코드", keyCode+"");
        if(keyCode== KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    // 방향전환을 감지 하기위한 메서드
    // 반드시 Manifest파일의 Activity속성으로 android:configChanges="screenSize|orientation"를
    // 지정해야 한다.
    // 처음부터 가로방향으로 실행되게 하려면 Manifest파일의 Activity속성으로
    // android:screenOrientation="landscape"를 준다.
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(getBaseContext(),"가로방향이군!!!",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getBaseContext(),"세로방향이군!!!",Toast.LENGTH_SHORT).show();
        }
    }
}

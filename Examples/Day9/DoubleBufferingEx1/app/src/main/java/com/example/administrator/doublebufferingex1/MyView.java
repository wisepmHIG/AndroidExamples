package com.example.administrator.doublebufferingex1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.view.View;

/**
 * Created by Administrator on 2017-02-11.
 */

public class MyView extends View implements Runnable{
    Bitmap bgBitmap;
    Canvas bgCanvas;
    Paint  paint = new Paint();;
    float x=100,y=100; // 그려질 좌표
    int width, height; // 폭과 높이
    // 반전 변수
    int swx=1,swy=1;
    // 안드로이드에서는 스레드에서 UI를 갱신면 안된다.
    // 핸들러를 이용하여 스레드를 갱신하도록 해야한다.
    Handler handler = new Handler();

    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // 화면 크기와 같은 크기의 화면을 메모리 상에 만든다.
        width = w;
        height = h;
        bgBitmap = Bitmap.createBitmap(w,h, Bitmap.Config.ARGB_8888);
        bgCanvas = new Canvas();
        bgCanvas.setBitmap(bgBitmap);
        // 스레드 시작
        new Thread(this).start();
        // 그리기 작업
        drawing();
    }
    private void drawing(){
        paint.setColor(Color.RED);
        bgCanvas.drawColor(Color.WHITE);
        bgCanvas.drawCircle(x,y,20,paint);
        invalidate();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 여기에서는 메모리에 그려진 그림을 실제 화면에 복사한다.
        if(bgBitmap!=null)
            canvas.drawBitmap(bgBitmap,0,0,paint);
    }

    @Override
    public void run() {
        while(true){
            // x,y 좌표를 변경시키자....
            x += swx*7;
            y += swy*7;
            // 핸들러의 post메서드를 호출하여 UI를 갱신한다.
            handler.post(new Runnable() {
                @Override
                public void run() {
                    drawing();
                }
            });
            // 경계 검사를 한다. 경계에 도달하면 반전시킨다.
            if(x<=20 || x >=width-20) swx *= -1;
            if(y<=20 || y >=height-20) swy *= -1;
            try { Thread.sleep(10); } catch (InterruptedException e) {;}
        }
    }
}

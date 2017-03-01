package com.example.administrator.zetboyex;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Handler;
import android.view.View;

/**
 * Created by Administrator on 2017-02-11.
 */

public class ShipView extends View implements Runnable {
    Bitmap bgBitmap, ship[] = new Bitmap[4], bg;
    Canvas bgCanvas;
    Handler handler;
    Paint paint;
    int index=0; // 그림번호 변경
    float x=0,y=0; // 그림이 출력되는 위치 변경

    public ShipView(Context context) {
        super(context);
        handler = new Handler();
        paint = new Paint();
        // 그림들 읽기
        Resources resources = getResources();
        bg = BitmapFactory.decodeResource(resources,R.drawable.background_a);
        for(int i=0;i<ship.length;i++){
            ship[i] = BitmapFactory.decodeResource(resources,R.drawable.ship2_1+i);
        }
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bgBitmap = Bitmap.createBitmap(w,h, Bitmap.Config.ARGB_8888);
        bgCanvas = new Canvas();
        bgCanvas.setBitmap(bgBitmap);
        new Thread(this).start(); // 스레드 시작
        drawing(); // 그리기 호출
    }
    private void drawing(){
        // 그리기 작업은 모두 여기서 한다.
        bgCanvas.drawColor(Color.WHITE);
        bgCanvas.drawBitmap(bg,0,0,paint);
        // 원본
        bgCanvas.drawBitmap(ship[index],x,y,paint);

        /*
        // 좌우 뒤집기
        Matrix matrix1 = new Matrix();
        matrix1.setScale(-1,1);
        Bitmap bitmap1 =
                Bitmap.createBitmap(ship[0],0,0,ship[0].getWidth(),ship[0].getHeight(),matrix1,false);
        bgCanvas.drawBitmap(bitmap1,10,150,paint);
        // 상하 뒤집기
        Matrix matrix2 = new Matrix();
        matrix2.setScale(1,-1);
        Bitmap bitmap2 =
                Bitmap.createBitmap(ship[0],0,0,ship[0].getWidth(),ship[0].getHeight(),matrix2,false);
        bgCanvas.drawBitmap(bitmap2,10,300,paint);
        // 상하좌우 뒤집기
        Matrix matrix3 = new Matrix();
        matrix3.setScale(-1,-1);
        Bitmap bitmap3 =
                Bitmap.createBitmap(ship[0],0,0,ship[0].getWidth(),ship[0].getHeight(),matrix3,false);
        bgCanvas.drawBitmap(bitmap3,10,450,paint);
        */
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(bgBitmap!=null) canvas.drawBitmap(bgBitmap,0,0,paint);
    }
    @Override
    public void run() {
        while(true) {
            x += 3;
            index++;
            if (index == ship.length) index=0;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    drawing();
                    invalidate();
                }
            });
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

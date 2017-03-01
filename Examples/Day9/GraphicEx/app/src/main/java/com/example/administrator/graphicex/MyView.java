package com.example.administrator.graphicex;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2017-02-11.
 */
public class MyView extends View {
    Context context;
    Paint paint;
    float x,y;

    public MyView(Context context) {
        super(context);
        this.context = context;
        paint = new Paint();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        canvas.drawRect(50,50,100,100,paint);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(x,y,20,paint);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            x = event.getX();
            y = event.getY();
            invalidate(); // 다시그려!!!!
        }
        return super.onTouchEvent(event);
    }
}

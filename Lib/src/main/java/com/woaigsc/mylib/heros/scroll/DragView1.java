package com.woaigsc.mylib.heros.scroll;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by chuiyuan on 16-5-17.
 */
public class DragView1 extends View {
    private int lastX ;
    private int lastY ;

    public DragView1(Context context){
        this(context, null);
    }

    public DragView1(Context context, AttributeSet attrs){
        this(context, attrs, 0);
    }

    public DragView1(Context context, AttributeSet attrs,
                     int defStyleValue){
        super(context, attrs, defStyleValue);
    }

    private void initView(){
        setBackgroundColor(Color.BLUE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int x = (int)event.getX() ;
        int y = (int)event.getY() ;
        return true ;
    }
}

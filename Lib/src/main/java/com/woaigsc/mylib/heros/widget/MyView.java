package com.woaigsc.mylib.heros.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by chuiyuan on 16-5-15.
 */
public class MyView extends View{
    private final String TAG = this.getClass().getSimpleName();

    public MyView (Context context){
        super(context);
    }

    public MyView (Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs,
                  int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        Log.d(TAG, "onTouchEvent: "+event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event){
        Log.d(TAG, "dispatchTouchEvent: "+ event.getAction());
        return super.dispatchTouchEvent(event);
    }
}

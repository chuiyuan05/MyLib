package com.woaigsc.mylib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by chuiyuan on 16-5-15.
 */
public class MyViewGroupB extends LinearLayout {
    private String TAG = this.getClass().getSimpleName();

    public MyViewGroupB(Context context){
        super(context);
    }

    public MyViewGroupB(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public MyViewGroupB(Context context, AttributeSet attrs,
                        int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event){
        Log.d(TAG, "dispatchTouchEvent: "+ event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event){
        Log.d(TAG, "onInterceptTouchEvent: "+ event.getAction());
        return super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        Log.d(TAG, "onTouchEvent: "+event.getAction());
        return super.onTouchEvent(event);
    }
}

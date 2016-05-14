package com.woaigsc.mylib.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 *
 * Created by chuiyuan on 16-5-8.
 */
public class CustomViewPager extends ViewPager {
    private boolean isPagingEnabled = true ;

    public CustomViewPager(Context context){
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return isPagingEnabled && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isPagingEnabled && super.onInterceptTouchEvent(ev);
    }

    /**
     * Set false to disable scrolling.
     * @param isPagingEnabled
     */
    public void setPagingEnabled(boolean isPagingEnabled){
        this.isPagingEnabled = isPagingEnabled ;
    }
}

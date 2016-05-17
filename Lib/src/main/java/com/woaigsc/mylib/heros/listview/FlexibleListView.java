package com.woaigsc.mylib.heros.listview;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ListView;

/**
 * Created by chuiyuan on 16-5-17.
 */
public class FlexibleListView extends ListView {
    private static int mMaxOverDistance = 50 ;
    private Context mContext ;

    public FlexibleListView(Context context, AttributeSet attrs,
                            int defStyleValue){
        super(context, attrs,defStyleValue);
        this.mContext = context ;
        initView();
    }

    public FlexibleListView(Context context, AttributeSet attrs){
       this(context,attrs, 0);
    }

    public FlexibleListView(Context context){
        this(context, null);
    }

    private void initView(){
        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        float density = metrics.density ;
        mMaxOverDistance = (int)(density*mMaxOverDistance) ;
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY,
                                   int scrollX, int scrollY,
                                   int scrollRangeX, int scrollRangY,
                                   int maxOverScrollX, int maxOverScrollY,
                                   boolean isTouchEvent){
        return super.overScrollBy(deltaX, deltaY,
                scrollX, scrollY,
                scrollRangeX, scrollRangY,
                maxOverScrollX, mMaxOverDistance,
                isTouchEvent) ;
    }
}

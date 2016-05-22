package com.woaigsc.mylib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * Created by chuiyuan on 16-5-22.
 * Change measure mode to AT_MOST(wrap_content).
 */
public class MyGridView extends GridView {
    private boolean expandable = false ;

    public MyGridView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public MyGridView(Context context) {
        super(context);
    }

    public MyGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    /**
     * If set true, it will show all the children and
     * disable to scroll.
     * @param expandable
     */
    public void setExpandable(boolean expandable){
        this.expandable = expandable ;
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(expandable){
            int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                    MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, expandSpec);
            //ViewGroup.LayoutParams params = getLayoutParams();
            //params.height = getMeasuredHeight();
        }else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

    }
}

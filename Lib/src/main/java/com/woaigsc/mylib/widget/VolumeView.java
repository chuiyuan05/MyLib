package com.woaigsc.mylib.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by chuiyuan on 16-5-15.
 */
public class VolumeView extends View {
    private String TAG = this.getClass().getSimpleName();

    private int mWidth;
    private int mRectWidth;
    private int mRectHeight;
    private Paint mPaint ;
    private int mRectCount ;
    private int offset = 5;
    private double mRandom ;
    private LinearGradient mLinearGradient ;

    public VolumeView (Context context){
        this(context, null, 0);
    }

    public VolumeView(Context context, AttributeSet attrs){
        this(context, attrs, 0);
        //initView();
    }

    public VolumeView (Context context, AttributeSet attrs,
                       int defStyleAttr){
        super(context, attrs,defStyleAttr);
        initView() ;
    }

    private void initView(){
        mPaint = new Paint() ;
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mRectCount = 12 ;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw");
        for (int i =0; i < mRectCount; i++){
            mRandom = Math.random();
            float currentHeight = (float)(mRectHeight*mRandom);
            canvas.drawRect(
                    (float) (mWidth*0.4/2+mRectWidth*i + offset),
                    currentHeight,
                    (float) (mWidth*0.4/2+ mRectWidth*(i+1)),
                    mRectHeight,
                    mPaint
            );
        }
        postInvalidateDelayed(300);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //only called during layout when the size has changed.
        Log.d(TAG, "onSizeChanged");
        mWidth = getWidth() ;
        mRectHeight = getHeight() ;
        mRectWidth = (int)(mWidth*0.6/mRectCount);
        mLinearGradient = new LinearGradient(
                0,
                0,
                mRectWidth,
                mRectHeight,
                Color.YELLOW,
                Color.BLUE,
                Shader.TileMode.CLAMP);
        mPaint.setShader(mLinearGradient);
    }

}

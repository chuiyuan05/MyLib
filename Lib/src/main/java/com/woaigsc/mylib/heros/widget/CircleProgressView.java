package com.woaigsc.mylib.heros.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by chuiyuan on 16-5-14.
 */
public class CircleProgressView extends View {
    private int mMeasureHeigth;
    private int mMeasureWidth ;

    private Paint mCirclePaint ;
    private float mCircleXY ;
    private float mRadius ;

    private Paint mArcPaint ;
    private RectF mArcRectF ;
    private float mSweepAngle ;
    private float mSweepValue =66;

    private Paint mTextPaint ;
    private String mShowtext ;
    private float mShowTextSize ;

    public CircleProgressView(Context context, AttributeSet attrs,
                              int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    public CircleProgressView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public CircleProgressView(Context context){
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mCircleXY,mCircleXY,mRadius,mCirclePaint);
        canvas.drawArc(mArcRectF,270,mSweepAngle,false, mArcPaint);
        canvas.drawText(mShowtext, 0, mShowtext.length(),
                mCircleXY, mCircleXY+(mShowTextSize/4),mTextPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure();
        mMeasureWidth = MeasureSpec.getSize(widthMeasureSpec);
        mMeasureHeigth = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(mMeasureWidth, mMeasureHeigth);
        initView();
    }

    private void initView(){
        float length = 0;
        if(mMeasureHeigth>= mMeasureWidth){
            length = mMeasureWidth;
        }else {
            length = mMeasureHeigth;
        }

        mCircleXY = length/2;
        mRadius = (float) (length*0.5/2);
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(getResources().getColor(
                android.R.color.holo_blue_bright
        ));

        mArcRectF = new RectF(
                (float)(length*0.1),
                (float)(length*0.1),
                (float)(length*0.9),
                (float)(length*0.9)
        );

        mSweepAngle = (mSweepValue/100f)*360f;
        mArcPaint = new Paint();
        mArcPaint.setAntiAlias(true);
        mArcPaint.setColor(getResources().getColor(
                android.R.color.holo_blue_bright
        ));
        mArcPaint.setStrokeWidth((float)(length*0.1));
        mArcPaint.setStyle(Paint.Style.STROKE);

        mShowtext = setShowText();
        mShowTextSize = setShowTextSize();
        mTextPaint = new Paint();
        mTextPaint.setTextSize(mShowTextSize);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
    }

    private float setShowTextSize(){
        this.invalidate();
        return 50;
    }

    private String setShowText(){
        this.invalidate();
        return "CircleProgress";
    }

    public void forceInvalidate(){
        this.invalidate();
    }

    public void setSweepValue(float sweepValue){
        if(sweepValue != 0){
            mSweepValue = sweepValue;
        }else {
            mSweepValue = 25;
        }
        this.invalidate();
    }

}

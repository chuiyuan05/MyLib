package com.woaigsc.mylib.widget;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.woaigsc.mylib.R;


/**
 * Created by chuiyuan on 16-5-6.
 */
public class ActionBar extends RelativeLayout {
    private LayoutInflater mInflater ;
    private RelativeLayout mBarView ;
    private ImageView mLogoView ;
    private View mBackIndicator ;
    private TextView mTitleView ;
    private LinearLayout mActionsView ;
    private ImageButton mHomeButton ;
    private RelativeLayout mHomeLayout ;
    private ProgressBar mProgress ;

    public ActionBar(Context context, AttributeSet attrs){
        super(context, attrs);
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mBarView = (RelativeLayout)mInflater.inflate(R.layout.actionbar, null);
        this.addView(mBarView);
        mLogoView = (ImageView)mBarView.findViewById(R.id.actionbar_home_logo);
        mHomeLayout = (RelativeLayout)mBarView.findViewById(R.id.actionbar_home_bg);
        mHomeButton = (ImageButton)mBarView.findViewById(R.id.actionbar_home_btn);
        mBackIndicator = mBarView.findViewById(R.id.actionbar_home_is_back);

        mTitleView = (TextView)mBarView.findViewById(R.id.actionbar_title);
        mActionsView = (LinearLayout)mBarView.findViewById(R.id.actionbar_actions);

        mProgress = (ProgressBar)mBarView.findViewById(R.id.actionbar_progress);

        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.ActionBar);
        CharSequence title = a.getString(R.styleable.ActionBar_title);
        if(title== null){

        }
        a.recycle();
    }

    public void setHomeAction(){

    }

    /**
     * Define an action that could be performed, along with a
     * icon to show.
     */
    public interface Action{
        public int getDrawable();
        public void performAction(View view);
    }

    public static abstract class AbstractAction implements Action{
        final private int mDrawable ;

        public AbstractAction(int mDrawable){
            this.mDrawable = mDrawable;
        }

        @Override
        public int getDrawable() {
            return mDrawable;
        }
    }

    public static class IntentAction extends AbstractAction{
        private Context mContext ;
        private Intent mIntent ;

        public IntentAction(Context context, Intent intent, int drawble ){
            super(drawble);
            this.mContext = context;
            mIntent = intent ;
        }
        @Override
        public void performAction(View view) {
            try {
                mContext.startActivity(mIntent);
            }catch (ActivityNotFoundException e){
                Toast.makeText(mContext,
                        mContext.getText(R.string.actionbar_activity_not_found),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}








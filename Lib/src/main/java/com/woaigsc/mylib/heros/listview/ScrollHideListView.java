package com.woaigsc.mylib.heros.listview;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.woaigsc.mylib.R;
import com.woaigsc.mylib.widget.ActionBar;

/**
 * Created by chuiyuan on 16-5-16.
 */
public class ScrollHideListView extends AppCompatActivity {
    private ActionBar mActionBar ;
    private ListView mListView ;
    private String [] mStr = new String [20];
    private int mTouchSlop ;
    private float mCurrentY ;
    private float mFirstY ;
    private int direction ;
    private ObjectAnimator mAnimator ;
    private boolean mShow = true ;

    View.OnTouchListener myTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    mFirstY = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    mCurrentY = event.getY();
                    if(mCurrentY - mFirstY > mTouchSlop){
                        direction = 0;//down
                    }else if(mFirstY - mCurrentY > mTouchSlop){
                        direction = 1;//up
                    }
                    if(direction ==1){//up
                        if(mShow){
                            actionbarAnim(1);//gone
                            mShow = !mShow;
                        }
                    }else if(direction ==0){//down
                        if(!mShow){
                            actionbarAnim(0);//show
                            mShow = !mShow ;
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
            return false;
        }
    } ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState
        );
        setContentView(R.layout.mylib_scroll_hide);
        mTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        mActionBar = (ActionBar) findViewById(R.id.mylib_scroll_actionbar);
        mListView = (ListView)findViewById(R.id.mylib_scroll_listview);

        for (int i=0;i<mStr.length;i++){
            mStr[i]= "Item "+ i;
        }
        View header = new View(this);
        header.setLayoutParams(new AbsListView.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT,
                (int)getResources().getDimension(
                        R.dimen.actionbar_height)));
        mListView.addHeaderView(header);
        mListView.setAdapter(new ArrayAdapter<String>(
                ScrollHideListView.this,
                android.R.layout.simple_expandable_list_item_1,
                mStr));

        mListView.setOnTouchListener(myTouchListener);
    }

    private void actionbarAnim(int direction){
        /*if(mAnimator != null && mAnimator.isRunning()){
            mAnimator.cancel();
        }*/
        if(direction == 0){
            mActionBar.setVisibility(View.VISIBLE);
        }else if(direction == 1){
            mActionBar.setVisibility(View.GONE);
        }
    }
}

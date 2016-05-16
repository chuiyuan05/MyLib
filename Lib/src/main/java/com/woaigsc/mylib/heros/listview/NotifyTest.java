package com.woaigsc.mylib.heros.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.woaigsc.mylib.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chuiyuan on 16-5-16.
 */
public class NotifyTest extends AppCompatActivity {
    private List<String > mData ;
    private ListView mListView ;
    private NotifyAdapter mAdpater ;

    @Override
    protected void onCreate(Bundle savedInstanceSate){
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.mylib_notify);

        mData = new ArrayList<>();
        for(int i=0; i<20;i++){
            mData.add(" "+i);
        }

        mListView = (ListView)findViewById(R.id.mylib_notify_listView);
        mAdpater = new NotifyAdapter(this, mData) ;
        mListView.setAdapter(mAdpater) ;

        for (int i=0;i<mListView.getChildCount() ; i++){
            View view = mListView.getChildAt(i);
        }

    }

    public void btnAdd(View view){
        mData.add("new");
        mAdpater.notifyDataSetChanged();
        //mListView.setSelection(mData.size()-1);//immediately
        mListView.smoothScrollToPosition(mData.size()-1);//smooth
    }
}

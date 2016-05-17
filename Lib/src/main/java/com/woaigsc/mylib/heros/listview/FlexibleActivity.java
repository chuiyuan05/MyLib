package com.woaigsc.mylib.heros.listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import com.woaigsc.mylib.R;

/**
 * Created by chuiyuan on 16-5-17.
 */
public class FlexibleActivity extends AppCompatActivity {
    private FlexibleListView mListView ;
    private String [] data = new String[20];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylib_flexible_activity);

        for (int i=0;i<20 ;i++){
            data[i] = ""+i;
        }

        mListView = (FlexibleListView)findViewById(R.id.flexible_listview) ;
        mListView.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                data
        ));
    }
}

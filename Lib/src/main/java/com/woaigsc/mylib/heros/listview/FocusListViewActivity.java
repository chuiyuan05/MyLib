package com.woaigsc.mylib.heros.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.woaigsc.mylib.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chuiyuan on 16-5-17.
 */
public class FocusListViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.mylib_focus_listview_activity);
        ListView mListView = (ListView) findViewById(R.id.mylib_focus_listView);
        List<String> data = new ArrayList<>();
        data.add("item 1");
        data.add("item 2");
        data.add("item 3");
        data.add("item 4");
        final FocusListViewAdapter mAdapter = new FocusListViewAdapter(this, data);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mAdapter.setCurrentItem(position);
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}

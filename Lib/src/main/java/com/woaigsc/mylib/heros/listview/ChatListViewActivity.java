package com.woaigsc.mylib.heros.listview;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.woaigsc.mylib.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chuiyuan on 16-5-16.
 */
public class ChatListViewActivity extends AppCompatActivity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceSate) {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.mylib_chat_activity);
        mListView = (ListView) findViewById(R.id.mylib_chat_listview);

        ChatItemBean bean1 = new ChatItemBean();
        bean1.setType(0);
        bean1.setIcon(BitmapFactory.decodeResource(
                getResources(), R.drawable.icon));
        bean1.setText("Hello1");

        ChatItemBean bean2 = new ChatItemBean();
        bean2.setType(1);
        bean2.setIcon(BitmapFactory.decodeResource(
                getResources(), R.drawable.icon));
        bean2.setText("Hello2");

        ChatItemBean bean3 = new ChatItemBean();
        bean3.setType(0);
        bean3.setIcon(BitmapFactory.decodeResource(
                getResources(), R.drawable.icon));
        bean3.setText("Hello3");

        ChatItemBean bean4 = new ChatItemBean();
        bean4.setType(1);
        bean4.setIcon(BitmapFactory.decodeResource(
                getResources(), R.drawable.icon));
        bean4.setText("Hello4");

        List<ChatItemBean> data = new ArrayList<>();
        data.add(bean1);
        data.add(bean2);
        data.add(bean3);
        data.add(bean4);
        mListView.setAdapter(new ChatItemAdapter(this, data));

    }
}

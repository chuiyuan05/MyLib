package com.woaigsc.mylib.designpattern.mvp.evenbus;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.woaigsc.mylib.R;
import com.woaigsc.mylib.designpattern.mvp.evenbus.event.GetDatasEvent;
import com.woaigsc.mylib.designpattern.mvp.evenbus.event.ToastEvent;
import com.woaigsc.mylib.designpattern.mvp.evenbus.presenter.EventBusPresenterImpl;
import com.woaigsc.mylib.designpattern.mvp.evenbus.presenter.IEventBusPresenter;
import com.woaigsc.mylib.designpattern.mvp.evenbus.view.IEventBusView;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by chuiyuan on 16-5-20.
 */
public class EventBusActivity extends AppCompatActivity implements IEventBusView {
    private IEventBusPresenter iEventBusPresenter ;
    private List<String> datas = new ArrayList<>();
    private BaseAdapter mAdapter ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylib_outteradapter_a);
        //register
        EventBus.getDefault().register(this);
        //find view
        ListView  mListView = (ListView)findViewById(R.id.mylib_outteradapter_a_listview);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                iEventBusPresenter.onItemClick(position);
            }
        });

        mAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,
                datas);
        mListView.setAdapter(mAdapter);
        iEventBusPresenter = new EventBusPresenterImpl(this);

    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    protected void onResume(){
        super.onResume();
        iEventBusPresenter.loadDatas();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    //eventbus subscribe
    public void onEvent(ToastEvent toastEvent){
        if(toastEvent!= null && toastEvent.getMsg()!= null){
            Toast.makeText(this,toastEvent.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onEvent(GetDatasEvent getDatasEvent){
        if(getDatasEvent!= null && getDatasEvent.getDatas()!= null&&
                getDatasEvent.getDatas().size()>0){
            this.datas.clear();
            this.datas.addAll(getDatasEvent.getDatas());
            mAdapter.notifyDataSetChanged();
        }
    }
}

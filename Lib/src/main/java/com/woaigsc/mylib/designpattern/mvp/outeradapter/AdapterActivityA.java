package com.woaigsc.mylib.designpattern.mvp.outeradapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.woaigsc.mylib.R;
import com.woaigsc.mylib.designpattern.mvp.outeradapter.dapter.CustomAdapter;
import com.woaigsc.mylib.designpattern.mvp.outeradapter.presenter.AdapterPresenterImpl;
import com.woaigsc.mylib.designpattern.mvp.outeradapter.presenter.IAdapterPresenter;
import com.woaigsc.mylib.designpattern.mvp.outeradapter.view.IAdapterView;

import java.util.List;

/**
 * Created by chuiyuan on 16-5-20.
 */
public class AdapterActivityA extends AppCompatActivity implements IAdapterView{
    private ListView mListView ;
    private View mFooterView ;
    private IAdapterPresenter mIAdapterPresenter ;
    private CustomAdapter mAdapter ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylib_outteradapter_a);
        mListView = (ListView)findViewById(R.id.mylib_outteradapter_a_listview);
        mListView.setDivider(null);
        //mListView.setEmptyView();
        mIAdapterPresenter = new AdapterPresenterImpl(this);
        mIAdapterPresenter.showFooterView(false);
        mAdapter = new CustomAdapter(mIAdapterPresenter);
        mListView.setAdapter(mAdapter);
        mIAdapterPresenter.loadData();

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                toast(""+position);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public Activity onGetActivity() {
        return null;
    }

    @Override
    public void onGetDataList(List<String> datas) {
        mAdapter.setDatas(datas);
    }

    @Override
    public void onLoadMoreData(String item) {
        mAdapter.addItem(item);
        mIAdapterPresenter.showFooterView(true);
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(this,"AdapterActivityA", Toast.LENGTH_SHORT).show();;
    }

    @Override
    public void onShowFooterView(boolean isShow) {
        if(isShow){
            //VISIBLE
        }else {
            //GONE
        }
    }
}

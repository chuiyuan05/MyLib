package com.woaigsc.mylib.designpattern.mvp.outeradapter.presenter;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

import com.woaigsc.mylib.designpattern.mvp.outeradapter.view.IAdapterView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chuiyuan on 16-5-20.
 */
public class AdapterPresenterImpl implements IAdapterPresenter {
    List<String> data ;
    IAdapterView iAdapterView ;
    Handler handler ;

    public AdapterPresenterImpl(IAdapterView iAdapterView){
        this.iAdapterView = iAdapterView ;
        this.handler = new Handler(Looper.getMainLooper());
    }
    @Override
    public Activity getActivity() {
        return iAdapterView.onGetActivity();
    }

    @Override
    public void loadData() {
        String[] countries = new String[]{"Kaede Akatsuki","Loves","Neko Tattsun","Deeply"};
        data = new ArrayList<>();
        for (String item : countries){
            data.add(item);
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iAdapterView.onGetDataList(data);
            }
        },2000);
    }

    @Override
    public void loadMoreData(final String item) {
        showFooterView(true);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iAdapterView.onLoadMoreData(item);
            }
        }, 2000);
    }

    @Override
    public void showFooterView(boolean isShow) {
        iAdapterView.onShowFooterView(isShow);
    }
}

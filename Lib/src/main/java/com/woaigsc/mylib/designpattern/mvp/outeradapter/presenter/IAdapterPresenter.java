package com.woaigsc.mylib.designpattern.mvp.outeradapter.presenter;

import android.app.Activity;

/**
 * Created by chuiyuan on 16-5-20.
 */
public interface IAdapterPresenter {
    public void loadData();
    public void loadMoreData(String item);
    public Activity getActivity();
    public void showFooterView(boolean isShow);
}

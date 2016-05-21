package com.woaigsc.mylib.designpattern.mvp.fragment.view;

import android.app.Activity;

/**
 * Created by chuiyuan on 16-5-20.
 */
public interface IFragmentView {
    public Activity getActivity();
    public void onItemClick(int position);
}

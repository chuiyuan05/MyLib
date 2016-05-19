package com.woaigsc.mylib.designpattern.mvp.presenter;

/**
 * Created by chuiyuan on 16-5-19.
 */
public interface ILoginPresenter{
    void clear();
    void doLogin(String name, String passwd);
    void setProgressBarVisible(int visible) ;
}

package com.woaigsc.mylib.designpattern.mvp.login.view;

/**
 * Created by chuiyuan on 16-5-19.
 */
public interface ILoginView {
    public void onClearText();
    public void onLoginResult(boolean result);
    public void onSetProgressBarVisible(int visible);
}

package com.woaigsc.mylib.designpattern.mvp.model;

/**
 * Created by chuiyuan on 16-5-19.
 */
public interface IUser {
    String getName ();
    String getPasswd();
    boolean checkUserValidity(String name, String passed);
}

package com.woaigsc.mylib.designpattern.mvp.evenbus.event;


/**
 * Created by chuiyuan on 16-5-20.
 */
public class ToastEvent {
    private String msg ;

    public ToastEvent(String msg){
        this.msg = msg ;
    }

    public String getMsg(){
        return msg ;
    }
}

package com.woaigsc.mylib.designpattern.mvp.evenbus.event;


/**
 * Created by chuiyuan on 16-5-20.
 */
public class GetDatasEvent {
    String datas ;

    public GetDatasEvent(String datas){
        this.datas = datas ;
    }

    public String getDatas(){
        return datas ;
    }
}

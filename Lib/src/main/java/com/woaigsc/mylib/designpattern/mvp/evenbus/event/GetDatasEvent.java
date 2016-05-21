package com.woaigsc.mylib.designpattern.mvp.evenbus.event;

import java.util.List;

/**
 * Created by chuiyuan on 16-5-20.
 */
public class GetDatasEvent {
    List<String> datas ;

    public GetDatasEvent(List<String> datas){
        this.datas = datas ;
    }

    public List<String> getDatas(){
        return datas ;
    }
}

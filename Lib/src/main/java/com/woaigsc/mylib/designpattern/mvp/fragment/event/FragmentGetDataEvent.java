package com.woaigsc.mylib.designpattern.mvp.fragment.event;

import java.util.List;

/**
 * Created by chuiyuan on 16-5-20.
 */
public class FragmentGetDataEvent {
    String datas ;

    public FragmentGetDataEvent(String  datas){
        this.datas = datas ;
    }

    public String getDatas(){
        return datas;
    }
}

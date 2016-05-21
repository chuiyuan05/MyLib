package com.woaigsc.mylib.designpattern.mvp.fragment.event;

/**
 * Created by chuiyuan on 16-5-20.
 */
public class FragmentToastEvent {
    int position ;

    public FragmentToastEvent (int position){
        this.position = position;
    }

    public int getPosition(){
        return position;
    }
}


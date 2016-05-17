package com.woaigsc.mylib.heros.listview;

import android.graphics.Bitmap;

/**
 * Created by chuiyuan on 16-5-16.
 */
public class ChatItemBean {

    private int type;
    private String text;
    private Bitmap icon;

    public ChatItemBean() {

    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

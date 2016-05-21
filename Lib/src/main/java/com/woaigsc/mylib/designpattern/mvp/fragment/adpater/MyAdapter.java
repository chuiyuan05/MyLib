package com.woaigsc.mylib.designpattern.mvp.fragment.adpater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.woaigsc.mylib.designpattern.mvp.fragment.presenter.IFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chuiyuan on 16-5-20.
 */
public class MyAdapter extends BaseAdapter{
    List<String> datas ;
    IFragmentPresenter iFragmentPresenter ;

    public MyAdapter(IFragmentPresenter iFragmentPresenter){
        this.iFragmentPresenter = iFragmentPresenter ;
        this.datas = new ArrayList<>();
    }

    public void setDatas(List<String> datas){
        if(datas != null && datas.size()>0){
            this.datas.clear();
            this.datas.addAll(datas);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public String getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}

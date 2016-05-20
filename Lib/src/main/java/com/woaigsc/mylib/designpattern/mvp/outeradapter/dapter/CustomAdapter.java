package com.woaigsc.mylib.designpattern.mvp.outeradapter.dapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.woaigsc.mylib.R;
import com.woaigsc.mylib.designpattern.mvp.outeradapter.presenter.IAdapterPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chuiyuan on 16-5-20.
 */
public class CustomAdapter extends BaseAdapter {
    private IAdapterPresenter iAdapterPresenter ;
    private List<String> data = new ArrayList<>();
    private LayoutInflater mInflater;

    public CustomAdapter(IAdapterPresenter iAdapterPresenter){
        this.iAdapterPresenter = iAdapterPresenter;
        this.data = new ArrayList<>();
    }

    public void setDatas(List<String> data){
        if(data != null && data.size()>0){
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void addItem(String item){
        data.add(item);
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        if(position>=0 && position<data.size()){
            data.remove(position);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            mInflater = LayoutInflater.from(parent.getContext());
            convertView = mInflater.inflate(R.layout.mylib_outteradapter_item,parent, false);
        }
        TextView tv = (TextView)convertView.findViewById(R.id.tv_outter_adapter_text);
        final String text = getItem(position);
        tv.setText(text);

        convertView.findViewById(R.id.tv_outter_adapter_add).setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iAdapterPresenter.loadMoreData("new "+text);
            }
        });
        convertView.findViewById(R.id.tv_outter_adapter_delete).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        removeItem(position);
                    }
                }
        );
        return convertView;
    }
}

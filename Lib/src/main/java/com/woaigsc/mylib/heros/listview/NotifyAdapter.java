package com.woaigsc.mylib.heros.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.woaigsc.mylib.R;

import java.util.List;

/**
 * Created by chuiyuan on 16-5-15.
 */
public class NotifyAdapter extends BaseAdapter {
    private List<String> mData;
    private LayoutInflater mInflater;

    public NotifyAdapter(Context context, List<String> data) {
        this.mData = data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.mylib_notify_item, null);
            holder.img = (ImageView) convertView.findViewById(R.id.mylib_notify_item_img);
            holder.title = (TextView) convertView.findViewById(R.id.mylib_notify_item_tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.img.setBackgroundResource(R.drawable.icon);
        holder.title.setText((String) getItem(position));
        return convertView;
    }

    private final class ViewHolder {
        public ImageView img;
        public TextView title;
    }
}

package com.woaigsc.mylib.heros.listview;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.woaigsc.mylib.R;

import java.util.List;

/**
 * Created by chuiyuan on 16-5-17.
 */
public class FocusListViewAdapter extends BaseAdapter {
    private List<String> mData;
    private Context mContext;
    private int mCurrentItem = 0;

    public FocusListViewAdapter(Context context, List<String> data) {
        this.mContext = context;
        this.mData = data;
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
        LinearLayout layout = new LinearLayout(mContext);
        layout.setOrientation(LinearLayout.VERTICAL);
        if (mCurrentItem == position) {
            layout.addView(addFocusView(position));
        } else {
            layout.addView(addNormalView(position));
        }
        return layout;
    }

    public void setCurrentItem(int currentItem) {
        this.mCurrentItem = currentItem;
    }

    private View addFocusView(int i) {
        ImageView img = new ImageView(mContext);
        img.setImageResource(R.drawable.icon);
        return img;
    }

    private View addNormalView(int i) {
        LinearLayout layout = new LinearLayout(mContext);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        ImageView iv = new ImageView(mContext);
        iv.setImageResource(R.drawable.icon);
        layout.addView(iv, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        TextView tv = new TextView(mContext);
        tv.setText(mData.get(i));
        layout.addView(tv, new ViewGroup.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        layout.setGravity(Gravity.CENTER);
        return layout;
    }
}

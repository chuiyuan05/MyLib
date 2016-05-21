package com.woaigsc.mylib.designpattern.mvp.fragment.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.woaigsc.mylib.designpattern.mvp.evenbus.event.GetDatasEvent;
import de.greenrobot.event.EventBus;

/**
 * Created by chuiyuan on 16-5-20.
 */
public class ActivityPresenterImpl implements IActivityPresenter {
    Context context ;

    public ActivityPresenterImpl(Context context){
        this.context = context;
    }
    @Override
    public void loadDatas() {
        final String datas = "change it to a easy string";

        new Handler(Looper.getMainLooper()).postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        //GetDatasEvent getDatasEvent = new GetDatasEvent("fuck");
                        //EventBus.getDefault().post(getDatasEvent);
                    }
                }, 1000);
    }
}

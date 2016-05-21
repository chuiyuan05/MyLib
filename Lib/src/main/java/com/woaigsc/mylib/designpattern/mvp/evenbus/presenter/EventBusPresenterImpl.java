package com.woaigsc.mylib.designpattern.mvp.evenbus.presenter;

import android.os.Handler;
import android.os.Looper;

import com.woaigsc.mylib.designpattern.mvp.evenbus.event.GetDatasEvent;
import com.woaigsc.mylib.designpattern.mvp.evenbus.event.ToastEvent;
import com.woaigsc.mylib.designpattern.mvp.evenbus.view.IEventBusView;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by chuiyuan on 16-5-20.
 */
public class EventBusPresenterImpl implements IEventBusPresenter{
    IEventBusView iEventBusView;
    final List<String> datas = new ArrayList<>();

    public EventBusPresenterImpl(IEventBusView iEventBusView){
        this.iEventBusView = iEventBusView ;
    }

    @Override
    public void loadDatas() {
        //String [] countries = iEventBusView.getActivity().getResources().getStringArray();
        String[] countries = new String[]{"Kaede Akatsuki","Loves","Neko Tattsun","Deeply"};
        for(String item :countries){
            datas.add(item);
        }

        new Handler(Looper.getMainLooper()).postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        GetDatasEvent getDatasEvent = new GetDatasEvent(datas);
                        EventBus.getDefault().post(getDatasEvent);
                    }
                }, 2000);
    }

    @Override
    public void onItemClick(int position) {
        ToastEvent toastEvent = new ToastEvent(datas.get(position));
        EventBus.getDefault().post(toastEvent);
    }
}

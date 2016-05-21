package com.woaigsc.mylib.designpattern.mvp.fragment.presenter;


import com.woaigsc.mylib.designpattern.mvp.fragment.view.IFragmentView;

/**
 * Created by chuiyuan on 16-5-20.
 */
public class FragmentPresenterImpl implements IFragmentPresenter {
    IFragmentView iFragmentView;

    public FragmentPresenterImpl(IFragmentView iFragmentView){
        this.iFragmentView = iFragmentView;
    }

    @Override
    public void onItemClick(int position) {
        iFragmentView.onItemClick(position);
    }
}

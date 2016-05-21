package com.woaigsc.mylib.designpattern.mvp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.woaigsc.mylib.R;
import com.woaigsc.mylib.designpattern.mvp.fragment.adpater.MyAdapter;
import com.woaigsc.mylib.designpattern.mvp.fragment.event.FragmentGetDataEvent;
import com.woaigsc.mylib.designpattern.mvp.fragment.presenter.FragmentPresenterImpl;
import com.woaigsc.mylib.designpattern.mvp.fragment.presenter.IFragmentPresenter;
import com.woaigsc.mylib.designpattern.mvp.fragment.view.IFragmentView;

import de.greenrobot.event.EventBus;

/**
 * Created by chuiyuan on 16-5-20.
 */
public class DemoFragment extends Fragment implements IFragmentView {
    private static final String BUNDLE_INDEX="bundle_index";

    private int index;
    private MyAdapter adapter;
    private IFragmentPresenter iFragmentPresenter ;

    public static DemoFragment newInstance(int index){
        DemoFragment fragment = new DemoFragment();
        Bundle args = new Bundle();
        args.putInt(BUNDLE_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!= null){
            index = getArguments().getInt(BUNDLE_INDEX);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.mylib_demo_fragment,container, false);
        //register
        EventBus.getDefault().register(this);
        //find view
        TextView tv = (TextView)root.findViewById(R.id.mylib_demo_fragment_tv);
        iFragmentPresenter = new FragmentPresenterImpl(this);
        return root;
    }

    @Override
    public void onItemClick(int position) {

    }

    public void onEvent(FragmentGetDataEvent event){
        if(event != null && event.getDatas()!= null){

        }
    }
}

package com.woaigsc.mylib.designpattern.mvp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.woaigsc.mylib.R;
import com.woaigsc.mylib.designpattern.mvp.fragment.presenter.ActivityPresenterImpl;
import com.woaigsc.mylib.designpattern.mvp.fragment.presenter.IActivityPresenter;
import com.woaigsc.mylib.widget.CustomViewPager;

/**
 * Created by chuiyuan on 16-5-20.
 */
public class FragmentsActivity extends AppCompatActivity {
    private TabLayout mTab ;
    private CustomViewPager mViewPager;
    private MyFragmentAdapter mAdapter ;

    private IActivityPresenter iActivityPresenter ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylib_fragmants_activity);

        mTab = (TabLayout)findViewById(R.id.mylib_fragments_tab);
        mViewPager = (CustomViewPager)findViewById(R.id.mylib_fragments_viewpager);
        mViewPager.setOffscreenPageLimit(4);

        mAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setPagingEnabled(true);
        mViewPager.setCurrentItem(0);

        mTab.setupWithViewPager(mViewPager);//Tab

        iActivityPresenter = new ActivityPresenterImpl(this);
        iActivityPresenter.loadDatas();
    }

    private class MyFragmentAdapter extends FragmentStatePagerAdapter{
        public String [] pages = new String[] {"A", "B" ,"C"};

        public MyFragmentAdapter(FragmentManager fm ){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return DemoFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return pages.length;
        }

        @Override
        public CharSequence getPageTitle(int position){
            return pages[position];
        }
    }
}

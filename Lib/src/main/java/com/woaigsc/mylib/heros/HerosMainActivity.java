package com.woaigsc.mylib.heros;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.woaigsc.mylib.R;
import com.woaigsc.mylib.heros.listview.NotifyTest;
import com.woaigsc.mylib.heros.listview.ScrollHideListView;

/**
 * Created by chuiyuan on 16-5-15.
 */
public class HerosMainActivity  extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceSate){
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.mylib_main_activity);
    }

    public void btnNotify(View view){
        startActivity(new Intent(this, NotifyTest.class));
    }

    public void btnScrollHideListView(View view){
        startActivity(new Intent(this, ScrollHideListView.class));

    }

}
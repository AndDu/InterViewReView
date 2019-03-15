package com.example.administrator.intenrviewtest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

import com.example.administrator.intenrviewtest.R;

/**
 * Created by Administrator on 2019/3/15.
 */

public class TabHostFragmentActivity extends AppCompatActivity {

    private FragmentTabHost myTabhost;
    private String[] mFragmentTags = {"1", "3"};
    private Class<?>[] mFragment = {Fragment.class, Fragment.class};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost);
    }
    private void initTabHost() {
        myTabhost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        myTabhost.setup(this, getSupportFragmentManager(), android.R.id.tabhost);
        myTabhost.getTabWidget().setDividerDrawable(null);
        for (int i = 0; i < mFragmentTags.length; i++) {
            TabHost.TabSpec tabSpec = myTabhost.newTabSpec(mFragmentTags[i]).setIndicator("");
            myTabhost.addTab(tabSpec, mFragment[i], null);
            myTabhost.getTabWidget().getChildAt(i).setBackgroundResource(android.R.color.white);
        }
    }

}

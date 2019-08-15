package com.example.administrator.intenrviewtest.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTabHost;

import android.widget.TabHost;

import com.example.administrator.intenrviewtest.R;

/**
 * Created by Administrator on 2019/3/15.
 *
 */

public class TabHostFragmentActivity extends AppCompatActivity {

    private FragmentTabHost myTabhost;
    private String[] mFragmentTags = {"meinv", "2"};
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

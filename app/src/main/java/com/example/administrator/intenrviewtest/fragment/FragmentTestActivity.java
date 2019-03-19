package com.example.administrator.intenrviewtest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2019/3/15.
 * ——————————————————————————————————
 * 正常fragment替换
 FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
 if (!fragment.isAdded()) {
 fragmentTransaction.show(fragment).commit();
 } else {
 fragmentTransaction.add(0, fragment).commit();
 }
 fragmentTransaction.addSharedElement() //动画添加  在animTest中有讲述
 fragmentTransaction.addToBackStack(null)
 fragmentTransaction.hide()
 -------------------------------------------------------------------------------------
 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 使用tabhost替换fragment
 */

public class FragmentTestActivity extends AppCompatActivity {




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
}

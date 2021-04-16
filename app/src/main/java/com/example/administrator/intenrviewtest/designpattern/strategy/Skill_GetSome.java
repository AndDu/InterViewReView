package com.example.administrator.intenrviewtest.designpattern.strategy;

import android.util.Log;

public class Skill_GetSome implements ISkill {


    @Override
    public void skillMethod() {

        Log.e("skillMethod: ","劫掠：你的钱财是我的啦" );

    }
}

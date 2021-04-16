package com.example.administrator.intenrviewtest.designpattern.decorator;

public class HeroHua implements IHero {



    //攻击力10点
    @Override
    public int attackNum() {
        return 6;
    }

    //冷却 20%
    @Override
    public int cooling() {
        return 20;
    }


}

package com.example.administrator.intenrviewtest.designpattern.decorator;

public class RedBlueBuffHero implements IHero {

    private IHero hero;// 获取redbuff的英雄

    public RedBlueBuffHero(IHero hero) {
        this.hero = hero;
    }

    @Override
    public int attackNum() {
        return hero.attackNum()+30;
    }

    @Override
    public int cooling() {
        return hero.cooling()+30;
    }
}

package com.example.administrator.intenrviewtest.designpattern.strategy;

public class Test {


    public static void main(String[] a){

        //策略模式
        HeroHuang heroHuang = new HeroHuang();
        heroHuang.use(new Skill_AttackFor());
        heroHuang.use(new Skill_GetSome());

    }
}

package com.example.administrator.intenrviewtest.designpattern.decorator;

public class Test {


    public static void main(String[] a){

        HeroHua heroHuang = new HeroHua();
        //获取红buff
        RedBuffHero redBuffHero = new RedBuffHero(heroHuang);
        //再打个蓝buff
        RedBlueBuffHero redBlueBuffHero=new RedBlueBuffHero(redBuffHero);
    }
}

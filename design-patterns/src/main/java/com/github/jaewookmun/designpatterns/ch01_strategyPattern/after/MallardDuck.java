package com.github.jaewookmun.designpatterns.ch01_strategyPattern.after;

import com.github.jaewookmun.designpatterns.ch01_strategyPattern.after.behavior.FlyWithWings;
import com.github.jaewookmun.designpatterns.ch01_strategyPattern.after.behavior.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("저는 물오리입니다.");
    }
}

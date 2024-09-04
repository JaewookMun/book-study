package com.github.jaewookmun.designpatterns.ch01_strategyPattern.after;

import com.github.jaewookmun.designpatterns.ch01_strategyPattern.after.behavior.FlyNoWay;
import com.github.jaewookmun.designpatterns.ch01_strategyPattern.after.behavior.Quack;

public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("저는 모형 오리입니다.");
    }
}

package com.github.jaewookmun.designpatterns.ch01_strategyPattern.after.behavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("저는 못 날아요");
    }
}

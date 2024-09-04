package com.github.jaewookmun.designpatterns.ch01_strategyPattern.after.behavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("날고 있어요!");
    }
}

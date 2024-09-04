package com.github.jaewookmun.designpatterns.ch01_strategyPattern.after.behavior;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("꽥");
    }
}

package com.github.jaewookmun.designpatterns.ch01_strategyPattern.after.behavior;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("삑");
    }
}

package com.github.jaewookmun.designpatterns.ch01_strategyPattern.before;

public class DecoyDuck extends Duck {
    @Override
    public void quack() {
        // Override for 아무것도 하지 않음
    }

    @Override
    public void display() {
        // 가짜 오리
    }

    @Override
    public void fly() {
        // Override for 아무것도 하지 않음
    }
}
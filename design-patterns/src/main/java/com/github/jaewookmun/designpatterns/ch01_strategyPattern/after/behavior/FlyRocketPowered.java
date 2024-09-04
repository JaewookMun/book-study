package com.github.jaewookmun.designpatterns.ch01_strategyPattern.after.behavior;

public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("로켓 추진으로 날아갑니다.");
    }
}

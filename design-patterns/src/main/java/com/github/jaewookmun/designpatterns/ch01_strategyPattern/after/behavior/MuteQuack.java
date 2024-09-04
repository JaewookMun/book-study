package com.github.jaewookmun.designpatterns.ch01_strategyPattern.after.behavior;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        // 아무 것도 하지 않음 - 소리를 낼 수 없는 경우
        System.out.println("<< 조용~ >>");
    }
}

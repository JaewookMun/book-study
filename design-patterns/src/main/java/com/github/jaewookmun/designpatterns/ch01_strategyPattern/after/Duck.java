package com.github.jaewookmun.designpatterns.ch01_strategyPattern.after;

import com.github.jaewookmun.designpatterns.ch01_strategyPattern.after.behavior.FlyBehavior;
import com.github.jaewookmun.designpatterns.ch01_strategyPattern.after.behavior.QuackBehavior;

/**
 * 애플리케이션에서 달라지는 부분을 찾아내고, 달라지지 않는 부분으로부터 분리시킨다. <br>
 * -> 바뀌는 부분은 따로 뽑아서 캡슐화시킨다.
 */
public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public abstract void display();

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void swim() {

    }

}

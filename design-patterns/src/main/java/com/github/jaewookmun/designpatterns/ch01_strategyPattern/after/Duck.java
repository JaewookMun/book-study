package com.github.jaewookmun.designpatterns.ch01_strategyPattern.after;

import com.github.jaewookmun.designpatterns.ch01_strategyPattern.after.behavior.FlyBehavior;
import com.github.jaewookmun.designpatterns.ch01_strategyPattern.after.behavior.QuackBehavior;

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

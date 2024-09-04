package com.github.jaewookmun.designpatterns.ch01_strategyPattern.before;

public abstract class Duck {

    public void quack() {
        System.out.println("꽥꽥");
    }

    public void swim() {

    }

    /*
     * RubberDuck은 날 수 없다.
     */
    public void fly() {

    }

    public abstract void display();
}

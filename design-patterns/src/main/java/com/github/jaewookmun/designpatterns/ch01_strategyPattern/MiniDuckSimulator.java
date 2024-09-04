package com.github.jaewookmun.designpatterns.ch01_strategyPattern;

import com.github.jaewookmun.designpatterns.ch01_strategyPattern.after.Duck;
import com.github.jaewookmun.designpatterns.ch01_strategyPattern.after.MallardDuck;
import com.github.jaewookmun.designpatterns.ch01_strategyPattern.after.ModelDuck;
import com.github.jaewookmun.designpatterns.ch01_strategyPattern.after.behavior.FlyRocketPowered;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        System.out.println();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}

package m.example.modern.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModernAppFilter {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        apple1.setColor("red");
        apple1.setWeight(160);

        Apple apple2 = new Apple();
        apple2.setColor("blue");
        apple2.setWeight(130);

        Apple apple3 = new Apple();
        apple3.setColor("green");
        apple3.setWeight(150);

        List<Apple> inventory = new ArrayList<>();
        inventory.add(apple1);
        inventory.add(apple2);
        inventory.add(apple3);

        Apple.filterApples(inventory, Apple::isHeavyApple);
        List<Apple> apples = Apple.filterApples(inventory, (Apple a) -> a.getColor().equals("red"));

        apples.forEach(a -> System.out.println("a = " + a));

        inventory.stream().filter(e -> e.getWeight() == 150);

        inventory.forEach(i -> System.out.println("i = " + i.getWeight()));

        System.out.println("1 = " + 1);
        
        inventory.stream().map(i -> i.getWeight() + 10).collect(Collectors.toList()).forEach(i -> System.out.println("i = " + i));


    }
}

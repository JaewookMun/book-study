package m.example.modern.practice;

import m.example.modern.stream.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestApp {
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.setWeight(100);
        apple.setColor("red");

        Apple apple1 = new Apple();
        apple1.setWeight(150);
        apple1.setColor("col");

        List<Apple> apples = new ArrayList<>();
        apples.add(apple);
        apples.add(apple1);

        Temp.filter(apples, Sample::temp).forEach(e -> System.out.println("e = " + e));
        Arrays.asList(1,2,3).stream().anyMatch(e -> e < 10);

        Apple test = null;
        Apple temp = Optional.ofNullable(test).orElseGet(() -> new Apple("test", 123));
        System.out.println("temp.getWeight() = " + temp.getWeight());

        Optional.ofNullable(test).ifPresent(System.out::println);


    }
}

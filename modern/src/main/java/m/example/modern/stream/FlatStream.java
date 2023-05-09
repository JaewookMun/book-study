package m.example.modern.stream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatStream {
    public static void main(String[] args) {
        String[] ex = {"Hello", "World"};

        Arrays.stream(ex).map(e -> e.split("")).distinct().forEach(System.out::println);

        Arrays.stream(ex).forEach(System.out::println);
        Arrays.stream(ex).map(s -> s.split("")).flatMap(Arrays::stream).forEach(e-> System.out.println("e = " + e));

        List<Integer> intList = new ArrayList<>();

        intList.stream().map(i -> i*i).collect(Collectors.toList());


        System.out.println("==================================");
        List<Integer> num1 = Arrays.asList(1, 2, 3);
        List<Integer> num2 = Arrays.asList(3, 4);

        String collect = num1.stream().map(e -> num2.stream().map(r -> "(" + e + ", " + r + ")").collect(Collectors.joining())).collect(Collectors.joining());
        System.out.println("collect = " + collect);

        num1.stream().flatMap(e
                -> num2.stream().map(r -> "(" + e + ", " + r + ")"))
                .collect(Collectors.toSet()).forEach(e -> System.out.println("e = " + e));

    }
}

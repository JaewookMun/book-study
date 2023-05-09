package m.example.modern.stream;

import java.util.Arrays;
import java.util.List;

public class CompareTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 2, 3, 1, 56, 7, 8, 123, 3);

        list.stream()
                .sorted((o1, o2) -> o2-o1)
                .forEach(System.out::println);
    }
}

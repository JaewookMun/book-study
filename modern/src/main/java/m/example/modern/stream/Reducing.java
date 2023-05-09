package m.example.modern.stream;

import java.util.ArrayList;
import java.util.List;

public class Reducing {
    public static void main(String[] args) {
        List<Dish> dishes = new ArrayList<>();

        Integer count = dishes.stream().map(e -> 1).reduce(0, Integer::sum);

    }
}

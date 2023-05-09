package m.example.modern.practice;

import java.util.ArrayList;
import java.util.List;

public class Temp<T> {

    public static <T> List<T> filter(List<T> list, Predicate<T> t) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if(t.test(e)) {
                result.add(e);
            }
        }

        return result;
    }

}

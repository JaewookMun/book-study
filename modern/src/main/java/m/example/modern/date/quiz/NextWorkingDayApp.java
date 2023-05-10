package m.example.modern.date.quiz;

import java.time.LocalDate;

public class NextWorkingDayApp {
    public static void main(String[] args) {
        LocalDate now = LocalDate.of(2023, 5, 12);
        LocalDate date = now.with(new NextWorkingDay());
        System.out.println("date = " + date);
    }
}

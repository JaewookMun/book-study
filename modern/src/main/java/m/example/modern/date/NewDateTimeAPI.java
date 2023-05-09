package m.example.modern.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class NewDateTimeAPI {
    public void with() {
        LocalDate date = LocalDate.of(2023, 5, 9);
        LocalDate date1 = date.with(ChronoField.MONTH_OF_YEAR, 2);
        System.out.println("date1 = " + date1);

    }

    public void plus() {
        LocalDate date = LocalDate.of(2023, 5, 9);
        LocalDate date2 = date.plus(3, ChronoUnit.DAYS);
        System.out.println("date2 = " + date2);
    }

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2023, 5, 10);

        // TemporalAdjusters ***
        date = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));

        System.out.println("date = " + date);
    }
}

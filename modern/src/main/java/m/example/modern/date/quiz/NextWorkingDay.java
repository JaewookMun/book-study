package m.example.modern.date.quiz;

import java.time.DayOfWeek;
import java.time.temporal.*;

public class NextWorkingDay implements TemporalAdjuster {

    /**
     * TemporalAdjuster를 람다 표현식으로 정의
     */
    public static TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(
        temporal -> {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));

            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
            else if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;

            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        }
    );

    /**
     * book's answer for quiz
     * @param temporal  the temporal object to adjust, not null
     */
    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));

        int dayToAdd = 1;
        if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
        else if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;

        return temporal.plus(dayToAdd, ChronoUnit.DAYS);
    }

    /**
     * my answer for quiz
     * @param temporal  the temporal object to adjust, not null
     */
//    @Override
//    public Temporal adjustInto(Temporal temporal) {
//        temporal = temporal.plus(1, ChronoUnit.DAYS);
//
//        while(temporal.get(ChronoField.DAY_OF_WEEK) == DayOfWeek.SATURDAY.getValue()
//                || temporal.get(ChronoField.DAY_OF_WEEK) == DayOfWeek.SUNDAY.getValue()) {
//
//            temporal = temporal.plus(1, ChronoUnit.DAYS);
//        }
//
//        return temporal;
//    }


}

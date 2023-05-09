package m.example.modern.date;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextWorkingDay implements TemporalAdjuster {
    /**
     * book's answer for quiz
     * @param temporal  the temporal object to adjust, not null
     */
    @Override
    public Temporal adjustInto(Temporal temporal) {


        return null;
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

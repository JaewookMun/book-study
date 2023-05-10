package m.example.modern.date.timezone;

import java.time.*;
import java.util.TimeZone;

public class TimeZoneExample {
    public static void main(String[] args) {
        /**
         * 지역 ID --> {지역}/{도시}
         * https://www.iana.org/time-zones
         */
        ZoneId romeZone = ZoneId.of("Europe/Rome");
        ZoneId zoneId = TimeZone.getDefault().toZoneId();

        LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
        ZonedDateTime zdt1 = date.atStartOfDay(romeZone);
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        ZonedDateTime zdt2 = dateTime.atZone(romeZone);
        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(romeZone);


    }
}

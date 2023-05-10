package m.example.modern.date.format;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class DateFormatExample {
    public static void main(String[] args) {
        // 날짜 객체를 특정한 형으로 변환
        LocalDate date = LocalDate.of(2014, 3, 18);
        String f1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String f2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);

        // 원하는 패턴 형태를 등록하여 해당 패턴으로 날짜 객체를 변환하고
        // 다시 날짜 객체로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        LocalDate date1 = LocalDate.now();
        String formattedDate = date1.format(formatter);
        LocalDate parsedDate = LocalDate.parse(formattedDate, formatter);

        // Locale을 활용하여 지역화된 DateTimeFormatter를 생성할 수 있다.
        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        LocalDate date2 = LocalDate.of(2014, 3, 18);
        String formattedDate2 = date.format(italianFormatter);
        LocalDate parsedDate2 = LocalDate.parse(formattedDate2, italianFormatter);

        // DateTimeFormatterBuilder - 복합적인 포매터
        DateTimeFormatter italianFormatter2 = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);
    }
}

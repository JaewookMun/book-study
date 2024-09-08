package com.github.jaewookmun.tdd.ch10_test_code_n_maintenance.do_not_use_variables_for_expected;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 변수나 필드를 사용해서 기댓값 표현하지 않기
 */
public class VariablesForExpectedTest {

    @Test
    @DisplayName("[10.1] 기대하는 값에 변수를 사용한 예")
    void dateFormat() {
        LocalDate date = LocalDate.of(1945, 8, 15);
        String dateStr = formatDate(date);
        assertEquals(date.getYear() + "년 " +
                date.getMonthValue() + "월 " +
                date.getDayOfMonth() + "일", dateStr);
    }

    @Test
    @DisplayName("[10.2] 기대하는 값에 변수를 사용한 예")
    void dateFormat1() {
        LocalDate date = LocalDate.of(1945, 8, 15);
        String dateStr = formatDate(date);
        assertEquals("1945년 8월 15일", dateStr);
    }

    private String formatDate(LocalDate date) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy년 M월 dd일");
        String dateStr = date.format(format);

        return dateStr;
    }
}

package com.github.jaewookmun.tdd.ch05_junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JUnit5BasicMethodTest {

    @Test
    @DisplayName("JUnit5 - exception")
    void test1() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> {
                    throw new IllegalArgumentException("test");
                });

        assertTrue(thrown.getMessage().contains("test"));
    }

    @Test
    @Disabled
    @DisplayName("JUnit5 - assertAll()")
    void test2() {
        // 첫번째 코드의 검증 실패로 인하여 두번째 코드의 검증은 수행되지 않음
        assertEquals(3, 5 / 2);
        assertEquals(4, 2 * 2);


        assertAll(
                () -> assertEquals(3, 5 / 2),
                () -> assertEquals(4, 2 * 2),
                () -> assertEquals(6, 11 / 2)
        );
    }
}

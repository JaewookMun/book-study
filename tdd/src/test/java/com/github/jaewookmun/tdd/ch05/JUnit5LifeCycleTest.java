package com.github.jaewookmun.tdd.ch05;

import org.junit.jupiter.api.*;

/**
 * <b>TEST 실행 결과</b><br/><br/>
 * beforeAll <br/>
 * new LifeCycle <br/>
 * setUp <br/>
 * a <br/>
 * tearDown <br/>
 * new LifeCycle <br/>
 * setUp <br/>
 * b <br/>
 * tearDown <br/>
 * afterAll <br/><br/>
 */
public class JUnit5LifeCycleTest {

    public JUnit5LifeCycleTest() {
        System.out.println("new LifeCycle");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @Test
    void a() {
        System.out.println("a");
    }

    @Test
    void b() {
        System.out.println("b");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }
}

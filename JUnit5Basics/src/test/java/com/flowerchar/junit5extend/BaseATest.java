package com.flowerchar.junit5extend;

import org.junit.jupiter.api.*;

public class BaseATest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("BaseATest===beforeAll");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("BaseATest===afterAll");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("BaseATest===beforeEach");
    }
    @AfterEach
    void afterEach(){
        System.out.println("BaseATest===afterEach");
    }

    @Test
    void test1(){
        System.out.println("BaseATest===test1");
    }

    @Test
    void test2(){
        System.out.println("BaseATest===test2");
    }
}

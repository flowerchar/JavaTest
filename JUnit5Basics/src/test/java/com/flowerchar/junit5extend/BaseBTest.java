package com.flowerchar.junit5extend;

import org.junit.jupiter.api.*;

public class BaseBTest extends BaseATest{

    @BeforeAll
    static void beforeBAll(){
        System.out.println("BaseBTest===beforeBAll");
    }
    @AfterAll
    static void afterBAll(){
        System.out.println("BaseBTest===afterBAll");
    }

    @BeforeEach
    void beforeBEach(){
        System.out.println("BaseBTest===beforeBEach");
    }
    @AfterEach
    void afterBEach(){
        System.out.println("BaseBTest===afterBEach");
    }

    @Test
    void testB1(){
        System.out.println("BaseBTest===testB1");
    }

    @Test
    void testB2(){
        System.out.println("BaseBTest===testB2");
    }
}

package com.flowerchar.junit5structure;

import org.junit.jupiter.api.*;

public class CaseTest {

    @BeforeAll
    static void setUpAll(){
        System.out.println("全局最先只执行一次+++++");
    }

    @BeforeEach
    void setUp(){
        System.out.println("测试花的前置动作");
    }

    @Test
    @DisplayName("测试第一支花")
    void flower(){
        System.out.println("这是第一支花");
    }

    @Test
    @DisplayName("测试第二支花")
    void flower2(){
        System.out.println("这是第二支花");
    }


    @AfterEach
    void tearDown(){
        System.out.println("测试花的后置动作");
    }


    @AfterAll
    static void tearDownAll(){
        System.out.println("全局最后只执行一次-----");
    }

}

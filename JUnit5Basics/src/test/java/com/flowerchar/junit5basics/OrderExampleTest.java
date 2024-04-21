package com.flowerchar.junit5basics;

import org.junit.jupiter.api.*;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestMethodOrder(MethodOrderer.DisplayName.class)
//@TestMethodOrder(MethodOrderer.Random.class)
@TestMethodOrder(MethodOrderer.MethodName.class)
//如果想对类测试，那么使用@TestClassOrder
public class OrderExampleTest {

//    @Test
//    @Order(1)
//    @DisplayName("test1")
    void test1() {
        System.out.println("test1");
    }

//    @Test
//    @Order(2)
//    @DisplayName("test2")
    void test2() {
        System.out.println("test2");
    }

//    @Test
//    @Order(4)
//    @DisplayName("test4")
    void test3() {
        System.out.println("test3");
    }

//    @Test
//    @Order(3)
//    @DisplayName("test3")
    void test4() {
        System.out.println("test4");
    }
}

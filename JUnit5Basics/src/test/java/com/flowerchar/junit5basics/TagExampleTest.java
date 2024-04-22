package com.flowerchar.junit5basics;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TagExampleTest {

    @Tag("preprod")
    @Test
    void test1() {
        System.out.println("preprod");
    }

    @Tag("dev")
    @Test
    void test2() {
        System.out.println("dev");
    }

    @Tag("test")
    @Test
    void test3() {
        System.out.println("test");
    }

    @Tag("preprod")
    @Tag("test")
    void test4() {
        System.out.println("preprod test");
    }

    @PreprodTest
    void test5() {
        System.out.println("preprod test");
    }
}

package com.flowerchar.junit5basics;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

//@Disabled("Disabled Example Test") 禁用类时，IDEA不起作用，Maven才会生效
public class DisabledExampleTest {

    @Disabled("Disabled test1")
    @Test
    void test1() {
        System.out.println("test1");
    }

    @Test
    void test2() {
        System.out.println("test2");
    }
}

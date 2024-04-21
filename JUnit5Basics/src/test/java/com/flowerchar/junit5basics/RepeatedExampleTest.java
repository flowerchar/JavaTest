package com.flowerchar.junit5basics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RepeatedExampleTest {
    //没有指定Display Name，那么默认为方法名
    @RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("RepeatedTest")
    void repeatedTest111() {
        System.out.println("RepeatedTest111");
    }
}

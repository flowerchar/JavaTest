package com.flowerchar.junit5params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CsvSourceDemoTest {

//    默认分隔符是逗号
    @ParameterizedTest
    @CsvSource(value = {
        "apple|5",
        "banana|6",
        "cherry|6"
    },delimiterString = "|")
    void csvSourceTest(String fruit, int length) {
        System.out.println(fruit + "的价格是每斤" + length+"元");
    }
}

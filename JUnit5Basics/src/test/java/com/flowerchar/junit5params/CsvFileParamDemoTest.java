package com.flowerchar.junit5params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CsvFileParamDemoTest {


    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", delimiterString = "|")
    void csvFileSourceTest(String fruit, int length) {
        System.out.println(fruit + "的价格是每斤" + length+"元");
    }
}

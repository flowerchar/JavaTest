package com.flowerchar.junit5params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValueSourceDemoTest {

    @ParameterizedTest
    @ValueSource(strings = {"apple", "banan", "cherr"})
    void valueSourceTest(String fruit) {
        assertEquals(5, fruit.length());
        System.out.println(fruit);
    }
}

package com.flowerchar.junit5params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MulitiMethodSourceDemoTest {


    @ParameterizedTest
    @MethodSource
    void methodSourceTest1(String fruit, int length) {
        System.out.println(fruit + "的长度是" + length);
    }

    static Stream<Arguments> methodSourceTest1() {
        return Stream.of(
            Arguments.of("apple", 5),
            Arguments.of("banana", 6),
            Arguments.of("cherry", 6)
        );
    }
}

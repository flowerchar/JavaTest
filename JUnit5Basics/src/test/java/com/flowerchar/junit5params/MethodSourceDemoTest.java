package com.flowerchar.junit5params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MethodSourceDemoTest {

    @ParameterizedTest
    @MethodSource("com.flowerchar.junit5params.MethodSourceDemoTest#fruitProvider")
//    不加参数名也可以，但是要求方法名和参数名一致
    void methodSourceTest(String fruit) {
        System.out.println(fruit);
    }

    static Stream<String> fruitProvider() {
        return Stream.of("apple", "banana", "cherry");
    }
}

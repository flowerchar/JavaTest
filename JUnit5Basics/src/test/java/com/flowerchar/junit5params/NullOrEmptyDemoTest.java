package com.flowerchar.junit5params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

public class NullOrEmptyDemoTest {

    @ParameterizedTest
    @NullSource
    void nullTest(String fruit) {
        System.out.println(fruit);
    }

    @ParameterizedTest
    @EmptySource
    void emptyTest(String fruit) {
        System.out.println(fruit);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmptyTest(String fruit) {
        System.out.println(fruit);
    }
}

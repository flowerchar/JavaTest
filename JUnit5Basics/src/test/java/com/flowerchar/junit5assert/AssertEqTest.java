package com.flowerchar.junit5assert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertEqTest {

    @Test
    void assertAllDemo(){

        assertAll("这个参数可加可不加，就是描述信息",
                ()->assertEquals(2, 1+1),
                ()->assertEquals(3, 1+1),
                ()->assertEquals(4, 1+1));
    }
}

package com.flowerchar.junit5params;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class EnumSourceDemoTest {

    public enum FlowerChar{
ROSE("rose", 1), LILY("lily", 2), TULIP("tulip", 3);
        private final String name;
        private final int age;
        private FlowerChar(String name, int age){
            this.name = name;
            this.age = age;
        }
    }

    @ParameterizedTest
    @EnumSource
    void enumSourceTest(FlowerChar flowerChar) {
        System.out.println(flowerChar.name + "的年龄是" + flowerChar.age);
    }

    @ParameterizedTest
    @EnumSource(names = {"ROSE", "LILY"})
    void enumSourceTest1(FlowerChar flowerChar) {
        System.out.println(flowerChar.name + "的年龄是" + flowerChar.age);
    }

    @ParameterizedTest
    @EnumSource(mode = EnumSource.Mode.EXCLUDE, names = {"ROSE", "LILY"})
    void enumSourceTest2(FlowerChar flowerChar) {
        System.out.println(flowerChar.name + "的年龄是" + flowerChar.age);
    }
}

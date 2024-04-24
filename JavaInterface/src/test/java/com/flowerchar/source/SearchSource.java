package com.flowerchar.source;

import java.util.stream.Stream;

public class SearchSource {

    public static Stream<String> searchParams() {
        return Stream.of("avaiable", "pending","sold");
    }
}

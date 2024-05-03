package com.flowerchar.test;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class SearchTest {

    @Test
    void searchTest(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("q", "selenium");
        map.put("limit",5);
        map.put("trem", "java");
        given()
                .header("Accept", "application/json")
                .queryParams(map)
        .when()
                .get("https://ceshiren.com/search")
        .then().log().all();
    }
}

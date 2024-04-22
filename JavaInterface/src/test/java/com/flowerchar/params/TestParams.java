package com.flowerchar.params;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TestParams {

    @Test
    void queryGetParam(){
        given()
                .queryParam("name", "flowerchar")
                .queryParam("age", 18)
        .when()
                .get("https://httpbin.ceshiren.com/get")
        .then()
                .log()
                .all();
    }

    @Test
    void queryGetParams(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "flowerchar");
        map.put("age", 18);
        given()
                .queryParams(map)
        .when()
                .get("https://httpbin.ceshiren.com/get")
        .then().log().all();
    }
}

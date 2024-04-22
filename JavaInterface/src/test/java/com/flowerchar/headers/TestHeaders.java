package com.flowerchar.headers;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TestHeaders {

    @Test
    void sendHeaders(){
        given()
                .header("Content-Type", "application/json")
                .header("charset", "UTF-8")
                .header("name", "flowerchar")
                .log().all()
        .when()
                .get("https://httpbin.ceshiren.com/get")
        .then()
                .log()
                .all();
    }

    @Test
    void sendHeadersByHashMap(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("charset", "UTF-8");
        hashMap.put("name", "flowerchar");
        given()
                .headers(hashMap)
                .log().all()
        .when()
                .get("https://httpbin.ceshiren.com/get")
        .then()
                .log()
                .all();
    }
}

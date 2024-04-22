package com.flowerchar.method;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

public class TestMethod {

    @Test
    void getReq(){
        when()
                .get("https://httpbin.ceshiren.com/get")
                .then()
                .log()
                .all();
    }

    @Test
    void postReq(){
        when()
                .post("https://httpbin.ceshiren.com/post")
                .then()
                .log()
                .all();
    }

    @Test
    void deleteReq(){
        when()
                .delete("https://httpbin.ceshiren.com/delete")
                .then()
                .log()
                .all();
    }

    @Test
    void putReq(){
        when()
                .put("https://httpbin.ceshiren.com/put")
                .then()
                .log()
                .all();
    }
}

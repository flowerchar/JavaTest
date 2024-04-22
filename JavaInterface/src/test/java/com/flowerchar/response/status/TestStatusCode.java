package com.flowerchar.response.status;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestStatusCode {

    @Test
    void testStatusCode(){
        given()
        .when()
                .get("https://httpbin.ceshiren.com/status/200")
        .then().log().all()
                .statusCode(2100);
    }
}

package com.flowerchar.petstore;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;


import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class QueryTest {

    @Test
    void testQuery() {
        String url = "https://petstore.swagger.io/v2/pet/findByStatus";
        HashMap<String, Object> query = new HashMap(){{
            put("status", "available1");
        }};
        Response response = given().log().all()
                .queryParams(query)
        .when()
                .get(url)
        .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        String body = response.getBody().toString();
        assertNotEquals("[]", body);
    }

    @ParameterizedTest
    @MethodSource("com.flowerchar.source.SearchSource#searchParams")
    void testQueryParams(String status) {
        String url = "https://petstore.swagger.io/v2/pet/findByStatus";
        HashMap<String, Object> query = new HashMap(){{
            put("status", status);
        }};
        Response response = given().log().all()
                .queryParams(query)
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        String body = response.getBody().toString();
        assertNotEquals("[]", body);
    }
}

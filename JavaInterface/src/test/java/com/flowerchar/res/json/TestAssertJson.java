package com.flowerchar.res.json;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAssertJson {

    @Test
    void testAssertJson(){
        String jsonData = "{\"name\":\"flowerchar\",\"age\":18}";
        given()
                .body(jsonData)
        .when()
                .post("https://httpbin.hogwarts.ceshiren.com/post")
        .then()
                .body("url", equalTo("https://httpbin.hogwarts.ceshiren.com/post")).log().all();
    }

    @Test
    void testComplexAssertJson(){
        String jsonData = "{\"name\":\"flowerchar\",\"age\":18}";
        given()
                .body(jsonData)
        .when()
                .post("https://httpbin.hogwarts.ceshiren.com/post")
        .then()
                .body("json.name", equalTo("flowerchar")).log().all();
    }

    @Test
    void testArrayAssertJson(){
        String jsonData = "{\"name\":\"flowerchar\",\"age\":18, \"major\":[\"CS\",\"Math\"]}";
        given()
                .body(jsonData)
        .when()
                .post("https://httpbin.hogwarts.ceshiren.com/post")
        .then()
//                .body("json.major", hasItem("CS"))
                .body("json.major[1]", equalTo("Math"))
                .log().all();
    }

    @Test
    void testExtractArrayAssertJson(){
        String jsonData = "{\"name\":\"flowerchar\",\"age\":18, \"major\":[\"CS\",\"Math\"]}";
        String path = given()
                .body(jsonData)
                .when()
                .post("https://httpbin.hogwarts.ceshiren.com/post")
                .then()
//                .body("json.major", hasItem("CS"))
                .extract().path("json.major[1]");

        assertEquals("Math", path);
    }
}

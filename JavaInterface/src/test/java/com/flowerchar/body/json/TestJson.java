package com.flowerchar.body.json;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestJson {


    @Test
    void postJsonByObject(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","flowerchar");
        jsonObject.put("age",18);
        given()
                .body(jsonObject.toString())
                .log().all()
        .when()
                .post("https://httpbin.ceshiren.com/post")
        .then().log().all();
    }
}

package org.example.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


@Component
public class RestAssuredUtil {

    public Response callApi(Map<String, String> queryParams, String url, String contentType, String body ){


        Response res = given()
                .queryParams(queryParams)
                .when()
                .contentType(contentType)
                .body(body)
                .get(url);
        return res;
    }

    public String getResponseBody(Response res){
        return res.body().asString();
    }

    public int getStatusCode(Response res){
        return res.statusCode();
    }

    public Response callApi(String endpoint, String contentType, String body){

        return callApi(new HashMap<>(), endpoint, contentType, body);
    }
}

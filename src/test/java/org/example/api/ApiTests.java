package org.example.api;

import io.restassured.RestAssured;
import org.example.infrastructure.BackendLifeCycle;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiTests extends BackendLifeCycle {

    private final  String HEALTH_PATH = "/health";
    private final String CALCULATOR_PATH = "/calc";
    private final String LOGIN_PATH = "/login";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }


    @DataProvider(name = "calculatorData")
    public Object[][] calculatorData() {
        return new Object[][] {
                {"1", "2", "add", "3"},
                {"5", "3", "subtract", "2"},
                {"2", "4", "multiply", "8"},
                {"10", "2", "divide", "5"},
                {"1", "0", "divide", "Arithmetic Error: Division by zero"},
                {"123", "43", "unknownOp", "Unknown operation"}
        };
    }


    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"Cleveland", "1234", "OK"},
                {"Caimin", "123", "OK"},
                {"Caimin", "1234", "Wrong Password"},
                {"Cleveland", "", "Wrong Password"},
                {"", "", "Wrong Username"},
                {"Clevelan", "1234", "Wrong Username"}
        };
    }


    private String callApi(Map<String, String> queryParams, String endpoint, int expectedStatus, String contentType){
        String body = given()
                .queryParams(queryParams)
                .when()
                .get(endpoint)
                .then()
                .statusCode(expectedStatus)
                .contentType(contentType)
                .extract().body().asString();
        return body;
    }

    private String callApi(String endpoint, int expectedStatus, String contentType){
        return callApi(new HashMap<>(), endpoint, expectedStatus, contentType);
    }


    @Test(groups = {"api"}, dataProvider = "calculatorData")
    public void testCalculatorOperations(String num1, String num2, String op, String expectedResult){
        Map<String, String> queryParams = Map.of("num1", num1, "num2", num2, "op", op);

        String body = callApi(queryParams, CALCULATOR_PATH, 200, "text/plain;charset=UTF-8");
        Assert.assertEquals(body, expectedResult);
    }

    @Test(groups = {"api"}, dataProvider = "loginData")
    public void testLogin(String username, String password, String expectedResult){
        Map<String, String> queryParams = Map.of("username", username, "password", password);

        String body = callApi(queryParams, LOGIN_PATH, 200, "text/plain;charset=UTF-8");
        Assert.assertEquals(body, expectedResult);
    }


    @Test(groups = {"api"})
    public void shouldBeHealthy() {
        String body =  callApi( HEALTH_PATH, 200, "text/plain;charset=UTF-8");

        Assert.assertEquals(body, "OK");
    }
}

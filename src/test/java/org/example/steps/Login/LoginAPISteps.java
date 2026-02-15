package org.example.steps.Login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.example.spring.ScenarioContext;
import org.example.steps.APISteps;
import org.testng.Assert;
import org.example.utils.RestAssuredUtil;

import java.util.Map;

import static io.restassured.RestAssured.given;



public class LoginAPISteps extends APISteps {

   public LoginAPISteps(ScenarioContext scenarioContext, RestAssuredUtil restAssuredUtil) {
       super(scenarioContext, restAssuredUtil, "http://localhost:8080");

   }

    @ParameterType("(.*)")  // regexp
    public Response getCurrentResponse(String... none) {
        return scenarioContext.getData("response");
    }

    @Given("the body")
    public void setBody(Map<String, String> credentials){
        scenarioContext.setData("body", credentials);
    }


    @When("I make the request")
    public void makeTheRequest() throws JsonProcessingException {
        Map<String, String> body = scenarioContext.getData("body");

        Response res = restAssuredUtil.callApi(body, getUrl("/login"),  "text/plain;charset=UTF-8", "");
        scenarioContext.setData("response", res);
    }

    @Then("the response status is {int}{getCurrentResponse}")
    public void validateResStatus(int status, Response currentResponse) {
        int actualResponseCode = currentResponse.statusCode();

        Assert.assertEquals(status, actualResponseCode, "status code mismatch expected " + status + " and got " + actualResponseCode);
    }

    @Then("the response body is {string}{getCurrentResponse}")
    public void validateResBody(String body, Response response) {
        String responseBody =  response.getBody().asString();
        Assert.assertEquals(responseBody, body, "body mismatch");
    }


}

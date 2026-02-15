package org.example.steps;

import org.example.spring.ScenarioContext;
import org.example.utils.RestAssuredUtil;



public abstract class APISteps {
    protected final RestAssuredUtil restAssuredUtil;
    protected final ScenarioContext scenarioContext;
    protected String baseUrl;


    protected String getUrl(String endpoint){
        return baseUrl + endpoint;
    }

    public APISteps(ScenarioContext scenarioContext, RestAssuredUtil restAssuredUtil, String url) {
        this.scenarioContext = scenarioContext;
        this.restAssuredUtil = restAssuredUtil;
        this.baseUrl = url;
    }
}

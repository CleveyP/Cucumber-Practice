package org.example.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.RequiredArgsConstructor;
import org.example.spring.ScenarioContext;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
public class ScenarioHooks {


    private final ScenarioContext scenarioContext;

    @Before(order= -1000000000)
    public void setScenario(Scenario scenario) {
        scenarioContext.setScenario(scenario);
    }

}

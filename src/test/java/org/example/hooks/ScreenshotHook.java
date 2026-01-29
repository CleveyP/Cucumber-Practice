package org.example.hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import lombok.RequiredArgsConstructor;
import org.example.spring.ScenarioContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


@RequiredArgsConstructor
public class ScreenshotHook {

    private final WebDriver driver;
    private final ScenarioContext scenarioContext;


    @AfterStep
    public void screenshotOnFailure() {
        Scenario scenario = scenarioContext.getScenario();
        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(
                    screenshot,
                    "image/png",
                    "FAILED STEP Screenshot"
            );
        }
    }


}


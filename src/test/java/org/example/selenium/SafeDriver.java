package org.example.selenium;

import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Interactive;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.stereotype.Component;

@ScenarioScope
@Component
public class SafeDriver {

    private final WebDriver driver;

    public SafeDriver(WebDriver driver) {
        this.driver = driver;
    }

    /** Returns the underlying WebDriver */
    public WebDriver get() {
        return driver;
    }

    public Actions actions() {
        return new Actions(driver);
    }

    /** Returns a screenshot if the driver supports it */
    public byte[] screenshot() {
        if (driver instanceof TakesScreenshot ts) {
            return ts.getScreenshotAs(OutputType.BYTES);
        } else {
            throw new UnsupportedOperationException(
                    "Current WebDriver does not support screenshots"
            );
        }
    }
}

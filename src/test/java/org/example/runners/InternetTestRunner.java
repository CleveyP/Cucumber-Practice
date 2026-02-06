package org.example.runners;

import io.cucumber.testng.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import java.io.File;
import java.util.List;


@CucumberOptions(
        features = "src/test/resources/features/theInternet",      // path to .feature files
        glue = {"org.example.steps.Internet", "org.example.steps.GenericSteps.java", "org.example.selenium", "org.example.spring", "org.example.hooks"},
        plugin = {
                "pretty",                                  // nice console output
                "json:target/cucumber.json"               // optional JSON report
        }

)


public class InternetTestRunner extends BaseRunner {



}









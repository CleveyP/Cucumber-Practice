package org.example.runners;

import io.cucumber.testng.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.testng.annotations.AfterSuite;
import java.io.File;
import java.util.List;


@CucumberOptions(
        features = "src/test/resources/features/login",      // path to .feature files
        glue = {"org.example.steps", "org.example.selenium", "org.example.spring", "org.example.hooks"},
        plugin = {
                "pretty",                                  // nice console output
                "json:target/cucumber.json"               // optional JSON report
        }

)


public class LoginTestRunner extends BaseRunner {


}









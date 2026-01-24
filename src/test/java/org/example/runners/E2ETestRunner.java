package org.example.runners;

import io.cucumber.testng.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;


@CucumberOptions(
        features = "src/test/resources/features",      // path to .feature files
        glue = {"org.example.steps", "org.example.selenium", "org.example.api", "org.example.spring", "org.example.hooks"},   // package with step definitions
        // run scenarios with these tags
        tags = "@Auth or @Calculator",
        plugin = {
                "pretty",                                  // nice console output
                "json:target/cucumber.json"               // optional JSON report
        }

)

@Test(groups = {"e2e"})
public class E2ETestRunner extends AbstractTestNGCucumberTests {



    @AfterSuite(alwaysRun = true)
    public void generateReport(){
        File file = new File("target/cucumber.json");

        File reports = new File("build/reports/cucumber/");

        Configuration config = new Configuration(reports, "Veeva Project");

        new ReportBuilder(List.of(file.getAbsolutePath()), config).generateReports();
    }

    @Override
    @Test(groups="cucumber", dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        super.runScenario(pickleWrapper, featureWrapper);
    }
}









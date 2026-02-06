package org.example.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.List;

public class BaseRunner extends AbstractTestNGCucumberTests {

    @AfterSuite(alwaysRun = true)
    public void generateReport(){
        File sourceJson = new File("target/cucumber.json");
        File reportOutputDir = new File("build/reports/cucumber/");

        Configuration config = new Configuration(reportOutputDir, "Veeva Project");
        new ReportBuilder(List.of(sourceJson.getAbsolutePath()), config).generateReports();
    }

    @Override @DataProvider(parallel=true)
    public Object[][] scenarios(){
        return super.scenarios();
    }

}

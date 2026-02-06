package org.example.selenium;

import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopedProxyMode;

import java.time.Duration;


@Configuration
public class WebDriverConfig {



    @Bean(destroyMethod = "quit")
    @ScenarioScope(proxyMode = ScopedProxyMode.INTERFACES)
//  @ScenarioScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
    public WebDriver webDriver() {

        boolean headless = Boolean.parseBoolean(
                System.getProperty("headless", "true")
        );

        ChromeOptions options = new ChromeOptions();

        options.addArguments(
                "--no-sandbox",
                "--disable-gpu",
                "--window-size=1920,1080"
        );

        if (headless)
            options.addArguments("--headless=new");

        return new ChromeDriver(options);
    }


    @ScenarioScope
    @Bean
    public WebDriverWait getWebDriverWait(WebDriver wd){
        return new WebDriverWait(wd, Duration.ofSeconds(10));
    }
}

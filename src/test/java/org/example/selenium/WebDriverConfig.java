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
    public ChromeDriver webDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--no-sandbox",
                "--headless=new",
                "--disable-gpu",
                "-ozone-override-screen-size=1920,1080",
                "-window-size=1920,1080");
        return new ChromeDriver(options);
        //return new ChromeDriver();
    }

    @ScenarioScope
    @Bean
    public WebDriverWait getWebDriverWait(WebDriver wd){
        return new WebDriverWait(wd, Duration.ofSeconds(10));
    }
}

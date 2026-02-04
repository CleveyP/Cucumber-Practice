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
    @ScenarioScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
    public ChromeDriver webDriver(){
        //ChromeOptions options = new ChromeOptions().addArguments("--no-sandbox", "--headless=new", "--disable-gpu");
        //return new ChromeDriver(options);
        return new ChromeDriver();
    }

    @ScenarioScope
    @Bean
    public WebDriverWait getWebDriverWait(WebDriver wd){
        return new WebDriverWait(wd, Duration.ofSeconds(2));
    }
}

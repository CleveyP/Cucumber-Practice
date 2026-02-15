package org.example.selenium;

import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopedProxyMode;

import java.time.Duration;

@Configuration
public class WebDriverConfig {

    @Bean(destroyMethod = "quit")
    @ScenarioScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
    public RemoteWebDriver webDriver() {

        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "true"));
        String browser = System.getProperty("browser", "chrome").toLowerCase();

        RemoteWebDriver driver;

        switch (browser) {
            case "firefox": {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--width=1920", "--height=1080");
                if (headless) options.addArguments("--headless");
                driver = new FirefoxDriver(options);
                break;
            }

            case "edge": {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--window-size=1920,1080");
                if (headless) options.addArguments("--headless");
                driver = new EdgeDriver(options);
                break;
            }

            case "chrome":
            default: {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox", "--disable-gpu", "--window-size=1920,1080");
                if (headless) options.addArguments("--headless=new");
                driver = new ChromeDriver(options);
                break;
            }
        }


        return driver;
    }

    @ScenarioScope
    @Bean
    public WebDriverWait getWebDriverWait(WebDriver wd) {
        return new WebDriverWait(wd, Duration.ofSeconds(10));
    }
}

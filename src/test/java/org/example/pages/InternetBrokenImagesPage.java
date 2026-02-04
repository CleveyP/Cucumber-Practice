package org.example.pages;

import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.util.List;


@ScenarioScope
@Component
public class InternetBrokenImagesPage extends Page{

    public InternetBrokenImagesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "http://the-internet.herokuapp.com");
    }

    public void validateBrokenImages(){
        List<WebElement> images = driver.findElements(By.cssSelector("#example > img"));
        validateAllImages(images);
    }

    public boolean validateForkMeImage(){
        return imageUrlWorks("https://the-internet.herokuapp.com/img/forkme_right_green_007200.png");
    }
}

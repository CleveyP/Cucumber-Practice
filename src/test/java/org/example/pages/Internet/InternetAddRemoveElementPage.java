package org.example.pages.Internet;


import io.cucumber.spring.ScenarioScope;
import org.example.pages.Page;
import org.example.selenium.SafeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;


@ScenarioScope
@Component
public class InternetAddRemoveElementPage extends Page {

    public InternetAddRemoveElementPage(SafeDriver driver, WebDriverWait wait) {
        super(driver, wait, "https://the-internet.herokuapp.com");
    }

    public int countDeleteButtons(){
        return driver.get().findElements(By.cssSelector("button.added-manually")).size();
    }



}

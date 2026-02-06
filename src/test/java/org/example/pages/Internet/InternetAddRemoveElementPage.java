package org.example.pages.Internet;


import io.cucumber.spring.ScenarioScope;
import org.example.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;


@ScenarioScope
@Component
public class InternetAddRemoveElementPage extends Page {

    public InternetAddRemoveElementPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "http://the-internet.herokuapp.com");
    }

    public int countDeleteButtons(){
        assertUrl("https://the-internet.herokuapp.com/add_remove_elements/");
        return driver.findElements(By.cssSelector("button.added-manually")).size();
    }



}

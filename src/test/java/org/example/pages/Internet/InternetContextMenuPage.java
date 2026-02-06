package org.example.pages.Internet;


import io.cucumber.spring.ScenarioScope;
import org.example.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.util.List;

@ScenarioScope
@Component
public class InternetContextMenuPage extends Page {


    public InternetContextMenuPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "http://the-internet.herokuapp.com");
    }

    public boolean theMenuExists(){
        List<WebElement> uls = getElementsByTagName("ul");
        if(!uls.isEmpty()){
            WebElement firstUl = uls.getFirst();
            return !firstUl.findElements(By.tagName("li")).isEmpty();
        }

        return false;
    }
}

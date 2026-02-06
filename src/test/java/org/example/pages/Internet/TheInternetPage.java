package org.example.pages.Internet;

import io.cucumber.spring.ScenarioScope;
import org.example.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;


@Component
@ScenarioScope
public class TheInternetPage extends Page {


    public Map<String, WebElement> hrefList = new HashMap<>();

    public TheInternetPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "http://the-internet.herokuapp.com");
    }

    public void loadLinks(){
        if(!hrefList.isEmpty()) return;

        WebElement aTagList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("ul")));
        assert aTagList != null;
        hrefList = aTagList.findElements(By.tagName("li")).
                stream().
                map(li ->
                        li.findElement(By.tagName("a"))
                ).
                collect(
                        Collectors.toMap(
                                WebElement::getText,
                                li -> li
                        )
                );
    }

    public void clickLink(String linkText) {
        WebElement link = hrefList.get(linkText);
        link.click();
    }



    //----------------------------------Authentication form page----------------------------------




    //----------------------------------Create/Delete page----------------------------------



    public int countDeleteButtons(){
        assertUrl("https://the-internet.herokuapp.com/add_remove_elements/");
        return driver.findElements(By.cssSelector("button.added-manually")).size();
    }



    //----------------------------------Broken Images page----------------------------------



    //----------------------------------Challenging DOM page----------------------------------





    //----------------------------------Checkboxes page----------------------------------




   //---disappearing elements






}

package org.example.pages;

import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
@ScenarioScope
public class TheInternetPage extends Page{


    public Map<String, WebElement> hrefList = new HashMap<>();

    public TheInternetPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "http://the-internet.herokuapp.com/");
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

    public void assertUrl(String url) {
        wait.until(ExpectedConditions.urlContains(url));
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    public void fillAuthenticationForm(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void submitAuthenticationForm(){
        clickButton(By.cssSelector("button[type='submit']"));
    }



    public int countDeleteButtons(){
        assertUrl("https://the-internet.herokuapp.com/add_remove_elements/");
        return driver.findElements(By.cssSelector("button.added-manually")).size();
    }

    public String getAuthBannerText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        WebElement banner = driver.findElement(By.id("flash"));
        return banner.getText();
    }

    public void assertAuthBannerText(String expectedError){
        String actual =  getAuthBannerText();
        boolean res = actual.contains(expectedError);
        Assert.assertTrue(res);
    }

    public void validateBrokenImages(){
        List<WebElement> images = driver.findElements(By.cssSelector("#example > img"));
        validateAllImages(images);
    }

    public boolean validateForkMeImage(){
        return imageUrlWorks("https://the-internet.herokuapp.com/img/forkme_right_green_007200.png");
    }


}

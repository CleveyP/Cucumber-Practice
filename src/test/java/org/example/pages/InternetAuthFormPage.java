package org.example.pages;


import io.cucumber.spring.ScenarioScope;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import org.testng.Assert;

@ScenarioScope
@Component
public class InternetAuthFormPage extends Page{


    public InternetAuthFormPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "http://the-internet.herokuapp.com");
    }

    public void fillAuthenticationForm(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void submitAuthenticationForm(){
        clickButton(By.cssSelector("button[type='submit']"));
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

}

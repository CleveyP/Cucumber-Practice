package org.example.pages.Internet;


import io.cucumber.spring.ScenarioScope;
import org.example.pages.Page;
import org.example.selenium.SafeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import org.testng.Assert;

@ScenarioScope
@Component
public class InternetAuthFormPage extends Page {


    public InternetAuthFormPage(SafeDriver driver, WebDriverWait wait) {
        super(driver, wait, "https://the-internet.herokuapp.com");
    }

    public void fillAuthenticationForm(String username, String password) {
        driver.get().findElement(By.id("username")).sendKeys(username);
        driver.get().findElement(By.id("password")).sendKeys(password);
    }

    public void submitAuthenticationForm(){
        clickButton(By.cssSelector("button[type='submit']"));
    }


    public String getAuthBannerText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        WebElement banner = driver.get().findElement(By.id("flash"));
        return banner.getText();
    }

    public void assertAuthBannerText(String expectedError){
        String actual =  getAuthBannerText();
        boolean res = actual.contains(expectedError);
        Assert.assertTrue(res);
    }

}

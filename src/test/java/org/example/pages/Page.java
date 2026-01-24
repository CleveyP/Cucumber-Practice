package org.example.pages;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public abstract class Page {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    private final String url;


    public Page(WebDriver driver, WebDriverWait wait, String url) {
        this.driver = driver;
        this.wait = wait;
        this.url = url;
    }

    public void open(){
        driver.get(url);
    }

    public void fillInputField(String content, By inputReference) {
        WebElement input1 = driver.findElement(inputReference);
        input1.clear();
        input1.sendKeys(String.valueOf(content));
    }

    public void clickButton(By buttonLocator) {
            driver.findElement(buttonLocator).click();
    }

    public void waitForText(By locator, String expected){
        wait.until(ExpectedConditions.textToBe(locator, expected));
    }
}

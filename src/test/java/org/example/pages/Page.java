package org.example.pages;

import org.example.selenium.SafeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Objects;


public abstract class Page {
    protected final SafeDriver driver;
    protected final WebDriverWait wait;
    private final String url;


    public Page(SafeDriver driver, WebDriverWait wait, String url) {
        this.driver = driver;
        this.wait = wait;
        this.url = url;
    }

    public void open(){
        driver.get().get(url);
    }

    public void openPage(String path){
        driver.get().get(url + "/" + path);
    }

    public void fillInputField(String content, By inputReference) {
        WebElement input1 = driver.get().findElement(inputReference);
        input1.clear();
        input1.sendKeys(String.valueOf(content));
    }

    public void clickButton(By buttonLocator) {
            driver.get().findElement(buttonLocator).click();
    }

    public void waitForText(By locator, String expected){
        wait.until(ExpectedConditions.textToBe(locator, expected));
    }


    public boolean imageUrlWorks(String url) {
        System.out.println("YOOOOO" + url);
        try {
            HttpURLConnection connection =
                    (HttpURLConnection) new URL(url).openConnection();

            connection.setRequestMethod("GET");
            connection.connect();

            int status = connection.getResponseCode();

            return status == 200;

        } catch (Exception e) {
            return false;
        }
    }


    public void assertUrl(String url) {
        wait.until(ExpectedConditions.urlContains(url));
        Assert.assertEquals(driver.get().getCurrentUrl(), url);
    }


    public void validateAllImages(List<WebElement> images) {

        for(WebElement img : images){
            String imageSource = img.getAttribute("src");
            if(imageSource == null){
                Assert.fail("Image source not found");
            }
            Assert.assertFalse(imageUrlWorks(imageSource));
        }
    }

    public List<WebElement> getElementsByTagName(String tagName) {
        return driver.get().findElements(By.tagName(tagName));
    }

    public int getElementCountByTagName(String tagName){
        return getElementsByTagName(tagName).size();
    }

    public int getElementAttributeValueById(String id, String attribute){
        return Integer.parseInt(Objects.requireNonNull(driver.get().findElement(By.id(id)).getAttribute(attribute)));
    }

    public void refreshPageHard(){
        driver.get().get(Objects.requireNonNull(driver.get().getCurrentUrl()));
    }

    public void refreshPageSoft(){
        Actions actions = driver.actions();
        actions.keyDown(Keys.CONTROL)
                .sendKeys("r")
                .keyUp(Keys.CONTROL)
                .perform();

    }

    public WebElement getElementById(String id){
        return driver.get().findElement(By.id(id));
    }

    public void rightClickElement(WebElement element) {
        driver.actions()
                .contextClick(element)
                .perform();
    }

    public boolean assertAlertOnPage(){
        try {
            driver.get().switchTo().alert();
        } catch (NoAlertPresentException e) {
            return false;
        }
        return true;
    }

    public WebElement getElementByTagAndText(String tag, String text) {
        By locator = By.xpath(
                String.format("//%s[contains(normalize-space(.), \"%s\")]", tag, text)
        );
        WebElement element = null;

        try{
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            return null;
        }
        return element;
    }







}

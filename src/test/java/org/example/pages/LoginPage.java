package org.example.pages;


import io.cucumber.spring.ScenarioScope;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import org.testng.Assert;


@Component
@ScenarioScope
public class LoginPage extends Page {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "file:///C:/Users/cleve/IdeaProjects/veevaSample/src/test/resources/html/LoginPage.html");
    }

    // Locators
    private final By usernameInputBy = By.id("username");
    private final By passwordInputBy = By.id("password");
    private final By submitButtonBy = By.id("loginBtn");

    private final By errorMessageBy = By.id("errorMessage");


    // Fill input fields
    public void fillUsernameInput(String username) {
        fillInputField(username, usernameInputBy);
    }

    public void fillPasswordInput(String password) {
       fillInputField(password, passwordInputBy);
    }

    // Validate inputs are populated correctly
    public void checkInputs(String expected1, String expected2) {
        WebElement input1 = driver.findElement(usernameInputBy);
        WebElement input2 = driver.findElement(passwordInputBy);
        Assert.assertEquals(input1.getAttribute("value"), String.valueOf(expected1));
        Assert.assertEquals(input2.getAttribute("value"), String.valueOf(expected2));
    }


    // Click the submit button
    public void clickSubmitButton() {
        clickButton(submitButtonBy);
    }

    // Validate the result paragraph has expected value
    public void validateResult(String expected) {
        WebElement resultParagraph = driver.findElement(errorMessageBy);
        // Wait until the paragraph text is non-empty
        waitForText(errorMessageBy, String.valueOf(expected));
        Assert.assertEquals(resultParagraph.getText(), String.valueOf(expected));
    }
}

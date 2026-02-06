package org.example.pages.Calculator;


import org.example.infrastructure.BackendLifeCycle;
import org.example.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import org.testng.Assert;


@Component
public class CalculatorHomePage extends Page {

    public CalculatorHomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "file:///C:/Users/cleve/IdeaProjects/veevaSample/src/test/resources/html/calculatorPage.html");
    }

    // Locators
    private final By input1By = By.id("num1");
    private final By input2By = By.id("num2");
    private final By submitButtonBy = By.id("computeBtn");
    private final By operationSelectBy = By.id("operation");
    private final By resultParagraphBy = By.id("result");



    // Fill input fields
    public void fillInput1(int value) {
        fillInputField(String.valueOf(value), input1By);
    }

    public void fillInput2(int value) {
        fillInputField(String.valueOf(value), input2By);
    }

    // Validate inputs are populated correctly
    public void checkInputs(int expected1, int expected2) {
        WebElement input1 = driver.findElement(input1By);
        WebElement input2 = driver.findElement(input2By);
        Assert.assertEquals(input1.getAttribute("value"), String.valueOf(expected1));
        Assert.assertEquals(input2.getAttribute("value"), String.valueOf(expected2));
    }

    // Select an operation
    public void selectOperation(String option) {
        WebElement operationSelect = driver.findElement(operationSelectBy);
        Select select = new Select(operationSelect);
        select.selectByValue(option);
    }

    // Click the submit button
    public void clickSubmitButton() {
        clickButton(submitButtonBy);
    }

    // Validate the result paragraph has expected value
    public void validateResult(int expected) {
        WebElement resultParagraph = driver.findElement(resultParagraphBy);

        waitForText(resultParagraphBy, String.valueOf(expected));
        Assert.assertEquals(resultParagraph.getText(), String.valueOf(expected));
    }
}

package org.example.selenium;

import org.example.infrastructure.BackendLifeCycle;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CalculatorE2ETests extends BackendLifeCycle {

    WebDriver driver;
    WebDriverWait wait;
    List<String> operators = List.of("add", "subtract", "multiply", "divide");
    List<List<Integer>> expecteds = new ArrayList<>();

    @BeforeMethod(groups = {"e2e"})
    public void setup() {
        driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver,  Duration.ofSeconds(2));
        System.out.println("Starting Selenium Tests");

        // Initialize expected results for each operator
        expecteds.clear();
        for (int op = 0; op < operators.size(); op++) {
            expecteds.add(new ArrayList<>());
        }

        // Populate expected results
        for (int operatorIndex = 0; operatorIndex < operators.size(); operatorIndex++) {
            String operator = operators.get(operatorIndex);

            for (int i = 0, j = 2; i < 10; i++, j += 2) {
                int expected = switch (operator) {
                    case "add" -> i + j;
                    case "subtract" -> i - j;
                    case "multiply" -> i * j;
                    case "divide" -> i / j;
                    default -> 0;
                };
                expecteds.get(operatorIndex).add(expected);
            }
        }
    }

    @Test(groups = {"e2e"})
    public void testOperations() throws InterruptedException {
        driver.get("file://C:/Users/cleve/IdeaProjects/veevaSample/src/test/resources/html/calculatorPage.html");

        WebElement num1Input = driver.findElement(By.id("num1"));
        WebElement num2Input = driver.findElement(By.id("num2"));
        WebElement submitButton = driver.findElement(By.id("computeBtn"));
        WebElement operationSelect = driver.findElement(By.id("operation"));
        Select select = new Select(operationSelect);

        for (int operatorIndex = 0; operatorIndex < operators.size(); operatorIndex++) {
            String operator = operators.get(operatorIndex);
            System.out.println("Testing " + operator + " operation");
            select.selectByValue(operator);

            for (int i = 0, j = 2; i < 10; i++, j += 2) {
                int num1 = i;
                int num2 = j;
                int expected = expecteds.get(operatorIndex).get(i);

                // Input numbers
                num1Input.sendKeys(String.valueOf(num1));
                num2Input.sendKeys(String.valueOf(num2));

                // Click compute
                submitButton.click();

                try {
                    wait.until(ExpectedConditions.textToBe(By.id("result"), String.valueOf(expected)));
                } catch (TimeoutException e) {
                    System.out.println("Timeout waiting for result on " + operator + " with inputs " + num1 + " and " + num2);
                }

                WebElement result = driver.findElement(By.id("result"));
                Assert.assertEquals(result.getText(), String.valueOf(expected),
                        "Failed on " + operator + " with inputs " + num1 + " and " + num2);

                // Clear inputs for next iteration
                num1Input.clear();
                num2Input.clear();
            }
            System.out.println("Tests for " + operator + " passed");
        }
    }

    @AfterMethod(groups = {"e2e"})
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

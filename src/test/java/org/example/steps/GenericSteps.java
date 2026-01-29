package org.example.steps;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RequiredArgsConstructor
public class GenericSteps {

    public final WebDriverWait wait;


    public void clickLinkOrButton(String labelText) {

        By locator = By.xpath(
                ("//a[normalize-space()='%s'] | " +
                        "//button[normalize-space()='%s']")
                        .formatted(labelText, labelText)
        );

        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(locator));

        assert element != null;
        element.click();
    }

    public void  clickLinkOrButtonRepeatedly(String labelText, int times){
        while(times>0){
            clickLinkOrButton(labelText);
            times--;
        }
    }

}

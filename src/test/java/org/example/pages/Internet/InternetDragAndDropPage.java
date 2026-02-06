package org.example.pages.Internet;

import io.cucumber.spring.ScenarioScope;
import lombok.RequiredArgsConstructor;
import org.example.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import java.util.Set;


@Component
@ScenarioScope




public class InternetDragAndDropPage extends Page {

    public final Set<String> cards = Set.of("A", "B");


    public InternetDragAndDropPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "http://the-internet.herokuapp.com");
    }


    public void dragCardToOtherCard(String fromCard, String toCard) {
        if (!cards.contains(fromCard) || !cards.contains(toCard)) {
            System.out.println("Illegal Card");
            Assert.fail("Illegal Card");
            return;
        }

        By fromLocator = By.id("column-%s".formatted(fromCard.toLowerCase()));
        By toLocator = By.id("column-%s".formatted(toCard.toLowerCase()));

        WebElement fromElement = wait.until(ExpectedConditions.elementToBeClickable(fromLocator));
        WebElement toElement = wait.until(ExpectedConditions.visibilityOfElementLocated(toLocator));

        Actions action = new Actions(driver);

        assert fromElement != null;
        assert toElement != null;

        action.clickAndHold(fromElement)
                .moveToElement(toElement)
                .release()
                .build()
                .perform();
    }

    public void dragCardToEmptySpace(String fromCard) {
        if (!cards.contains(fromCard)) {
            System.out.println("Illegal Card");
            Assert.fail("Illegal Card");
            return;
        }

        String destinationId = "page-footer";

        By fromLocator = By.id("column-%s".formatted(fromCard.toLowerCase()));
        By toLocator = By.id(destinationId);

        WebElement fromElement = wait.until(ExpectedConditions.elementToBeClickable(fromLocator));
        WebElement toElement = wait.until(ExpectedConditions.visibilityOfElementLocated(toLocator));

        Actions action = new Actions(driver);

        assert fromElement != null;
        assert toElement != null;

        action.clickAndHold(fromElement)
                .moveToElement(toElement)
                .release()
                .build()
                .perform();
    }



    public String getCardContent(String fromCard){
        if(!cards.contains(fromCard)){

            Assert.fail("Illegal Card " + fromCard);
            return "";
        }

        By cardLocator = By.cssSelector("div#column-%s > header".formatted(fromCard.toLowerCase()));

        wait.until(driver -> driver.findElement(cardLocator).isDisplayed());

        return driver.findElement(cardLocator).getText();

    }
}

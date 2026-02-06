package org.example.pages.Internet;

import io.cucumber.spring.ScenarioScope;
import org.example.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@ScenarioScope
@Component
public class InternetDisappearingElementsPage extends Page {

    public InternetDisappearingElementsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "http://the-internet.herokuapp.com");
    }

    public boolean theElementWithTextExists(String tag, String text){
        WebElement expected = getElementByTagAndText(tag, text);

        return expected != null && expected.isDisplayed();
    }

    public boolean isFlakeyElementExistsWithTagAndText(String tag, String text, int retries){
        while(retries>0){
            retries--;

            if(theElementWithTextExists(tag, text)) {
                return true;
            }
            refreshPageHard();
        }
        return false;
    }

    public boolean isFlakeyElementExistsWithTagAndText(String tag, String text){
        return isFlakeyElementExistsWithTagAndText(tag, text, 10);
    }
}

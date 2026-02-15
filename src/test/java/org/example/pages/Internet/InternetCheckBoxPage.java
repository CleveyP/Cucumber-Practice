package org.example.pages.Internet;


import io.cucumber.spring.ScenarioScope;
import org.example.pages.Page;
import org.example.selenium.SafeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.util.List;

@ScenarioScope
@Component
public class InternetCheckBoxPage extends Page {

    public InternetCheckBoxPage(SafeDriver driver, WebDriverWait wait) {
        super(driver, wait, "https://the-internet.herokuapp.com");
    }

    public List<WebElement> getAllCheckboxes(){
        By checkBoxesLocator = By.cssSelector("form > input[type='checkbox']");

        wait.until(driver ->
                !driver.findElements(checkBoxesLocator).isEmpty()

        );

        return driver.get().findElements(checkBoxesLocator);
    }

    public boolean getCheckboxValueByLocator(int checkboxNumber) throws IndexOutOfBoundsException {

        List<WebElement> checkboxes = getAllCheckboxes();
        if(checkboxNumber < 0 || checkboxNumber >= checkboxes.size())
            throw new IndexOutOfBoundsException("checkbox number " + checkboxNumber + " out of bounds of length " + checkboxes.size());
        return checkboxes.get(checkboxNumber).isSelected();
    }

    public void clickCheckbox(int checkboxNumber){
        List<WebElement> checkboxes = getAllCheckboxes();
        if(checkboxNumber < 0 || checkboxNumber >= checkboxes.size())
            throw new IndexOutOfBoundsException("checkbox number " + checkboxNumber + " out of bounds of length " + checkboxes.size());
        WebElement checkbox = getAllCheckboxes().get(checkboxNumber);
        checkbox.click();
    }
}

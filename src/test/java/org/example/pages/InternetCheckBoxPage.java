package org.example.pages;


import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.util.List;

@ScenarioScope
@Component
public class InternetCheckBoxPage extends Page{

    public InternetCheckBoxPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "http://the-internet.herokuapp.com");
    }

    public List<WebElement> getAllCheckboxes(){
        return driver.findElements(By.cssSelector("form > input[type='checkbox']"));
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

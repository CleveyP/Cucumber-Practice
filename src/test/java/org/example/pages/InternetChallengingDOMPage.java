package org.example.pages;


import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

@ScenarioScope
@Component
public class InternetChallengingDOMPage extends Page{

    public InternetChallengingDOMPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait, "http://the-internet.herokuapp.com");
    }

    public void assertAlertButtonStyleIsAlert(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.button.alert")));
        WebElement alertButton = driver.findElement(By.cssSelector("a.button.alert"));
        Assert.assertEquals(alertButton.getCssValue("background-color"),"rgba(198, 15, 19, 1)");
        Assert.assertEquals(alertButton.getCssValue("color"), "rgba(255, 255, 255, 1)");
    }


    public List<String> getTableHeaderTitles(){
        return getElementsByTagName("th").stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<WebElement> getTableRows(){
        return getElementsByTagName("tr");
    }

    public int getTableRowCount(){
        return getTableRows().size();
    }


    public WebElement getTableRow(int row) throws IndexOutOfBoundsException {

        List<WebElement> tableRows = getTableRows();
        if(row < 0 || row >= tableRows.size())
            throw new IndexOutOfBoundsException("row " + row + " out of bounds");
        return tableRows.get(row);
    }


    public WebElement getTableCell(int row, int col) throws IndexOutOfBoundsException {

        WebElement tableRow = getTableRow(row);
        List<WebElement> tableData = tableRow.findElements(By.tagName("td"));

        if(col < 0 || col >= tableData.size())
            throw new IndexOutOfBoundsException("col: " + col + " out of bounds of length " + tableData.size());
        return tableData.get(col);
    }


    public void tableRowContainsCorrectOptions(int row){
        WebElement editCell = getTableCell(row, 6);
        List<WebElement> editLinks = editCell.findElements(By.tagName("a"));
        Assert.assertEquals(editLinks.get(0).getText(), "edit");
        Assert.assertEquals(editLinks.get(1).getText(), "delete");
    }

    public void tableRowsContainCorrectOptions(){
        for(int row = 1; row < getTableRowCount(); row++){
            tableRowContainsCorrectOptions(row);
        }
    }

    public boolean hasCanvasElement(){
        WebElement canvas = driver.findElement(By.id("canvas"));
        return canvas.isDisplayed();
    }
}

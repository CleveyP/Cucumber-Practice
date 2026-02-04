package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import org.example.pages.InternetChallengingDOMPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class InternetChallengingDOMSteps {
    private final InternetChallengingDOMPage page;
    private final GenericSteps genericSteps;

    @Then("there should be {int} elements of type {string} on the page")
    public void there_should_be_some_elements_of_type_on_the_page(int expectedCount, String typeName) {
        int actual = page.getElementCountByTagName(typeName);
        Assert.assertEquals(actual, expectedCount);
    }

    @Then("there should be 3 button link elements on the page")
    public void there_should_be_button_link_elements_on_the_page() {
        List<WebElement> hrefList =  page.getElementsByTagName("a");
        int count = 0;
        for(WebElement href : hrefList){
            if(Objects.requireNonNull(href.getAttribute("class")).contains("button")) {
                System.out.println(href.getText());
                count++;
            }
        }
        Assert.assertEquals(count, 3);
    }


    @Then("the alert button should have alert styling")
    public void the_alert_button_should_have_alert_styling() {
        page.assertAlertButtonStyleIsAlert();
    }

    @Then("the {string} header should exist in the table")
    public void the_header_should_exist_in_the_table(String header) {
        List<String> tableHeaderTitles = page.getTableHeaderTitles();
        Assert.assertTrue(tableHeaderTitles.contains(header));
    }

    @Then("each table row should contain an edit and a delete link")
    public void each_table_row_should_contain_an_edit_and_a_delete_link() {
        page.tableRowsContainCorrectOptions();
    }

    @Then("the single canvas element is shown on the page")
    public void the_single_canvas_element_is_shown_on_the_page() {
        Assert.assertTrue(page.hasCanvasElement());
    }

    @And("the {string} has height: {int}")
    public void the_canvas_has_height(String id, int expectedHeight) {
        int canvasHeight =  page.getElementAttributeValueById(id, "height");
        Assert.assertEquals(canvasHeight, expectedHeight);
    }

    @And("the {string} has width: {int}")
    public void the_canvas_has_width(String id, int expectedWidth) {
        int canvasWidth =  page.getElementAttributeValueById(id,  "width");
        Assert.assertEquals(canvasWidth, expectedWidth);
    }

    @Then("the cell {int}, {int} has text {string}")
    public void the_cell_has_text(int row, int col, String text) {
        String actual = page.getTableCell(row, col).getText();
        Assert.assertEquals(actual, text);
    }
}

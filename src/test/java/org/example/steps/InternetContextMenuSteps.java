package org.example.steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.example.pages.InternetContextMenuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

@RequiredArgsConstructor
public class InternetContextMenuSteps {
    private final InternetContextMenuPage page;
    private final GenericSteps genericSteps;


    @When("the {string} element is right clicked")
    public void the_element_is_right_clicked(String elementName) {
        page.rightClickElement(page.getElementById(elementName));
    }


    @Then("an alert is displayed on the page")
    public void an_alert_is_displayed_on_the_page() {
        Assert.assertTrue(page.assertAlertOnPage());
    }



    @Then("the menu exists")
    public void the_menu_exists() {
        Assert.assertTrue(page.theMenuExists());
    }

}

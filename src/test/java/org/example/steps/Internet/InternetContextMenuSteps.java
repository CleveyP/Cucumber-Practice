package org.example.steps.Internet;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.example.pages.Internet.InternetContextMenuPage;
import org.example.steps.GenericSteps;
import org.testng.Assert;

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

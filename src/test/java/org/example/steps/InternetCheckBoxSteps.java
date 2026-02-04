package org.example.steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.example.pages.InternetCheckBoxPage;
import org.testng.Assert;

@RequiredArgsConstructor
public class InternetCheckBoxSteps {
    private final GenericSteps genericSteps;
    private final InternetCheckBoxPage page;

    @Then("neither checkbox should be checked")
    public void neither_checkbox_should_be_checked() {
        boolean actualCheckBox1 = page.getCheckboxValueByLocator(0);
        boolean actualCheckBox2 = page.getCheckboxValueByLocator(1);

        Assert.assertFalse(actualCheckBox1);
        Assert.assertFalse(actualCheckBox2);
    }

    @When("the user clicks the number {int} checkbox")
    public void the_user_clicks_the_checkbox(int checkboxNumber) {
        page.clickCheckbox(checkboxNumber);
    }

    @Then("the number {int} checkbox should be {string}")
    public void the_checkbox_should_be_checked_or_unchecked(int checkboxNumber, String checkboxExpectedValue) throws Exception {
        if(!checkboxExpectedValue.equals("checked") && !checkboxExpectedValue.equals("unchecked")) {
            throw new Exception(checkboxExpectedValue + " is not a valid option.");
        }
        boolean expectedCheck = checkboxExpectedValue.equals("checked");
        boolean actualCheckBox = page.getCheckboxValueByLocator(checkboxNumber);
        Assert.assertEquals(actualCheckBox, expectedCheck);
    }

    @And("the user refreshes the page softly")
    public void the_user_refreshes_the_page_softly() {
        page.refreshPageSoft();
    }

    @And("the user refreshes the page hard")
    public void the_user_refreshes_the_page_hard() {
        page.refreshPageHard();
    }

}

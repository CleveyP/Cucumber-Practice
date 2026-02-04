package org.example.steps;

import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import org.example.pages.InternetAddRemoveElementPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

@RequiredArgsConstructor
public class InternetAddRemoveElementSteps {
    private final InternetAddRemoveElementPage page;
    private final GenericSteps genericSteps;
    private final WebDriverWait wait;

    @Then("{int} Delete elements exist on the page")
    public void the_new_delete_element_exists_on_the_page(int expectedCount) {
        int numDeleteButtons = page.countDeleteButtons();
        Assert.assertEquals(numDeleteButtons, expectedCount);
    }


}

package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import org.example.pages.InternetDisappearingElementsPage;
import org.testng.Assert;

@RequiredArgsConstructor
public class InternetDisappearingElementsSteps {
    private final GenericSteps genericSteps;
    private final InternetDisappearingElementsPage page;

    @And("the {string} element with text {string} exists")
    public void the_element_with_text_exists(String tag, String textName) {
        Assert.assertTrue(page.theElementWithTextExists(tag, textName));
    }

    @Then("the gallery sometimes appears on the page")
    public void the_gallery_sometimes_appears_on_the_page() {
        Assert.assertTrue(page.isFlakeyElementExistsWithTagAndText("a", "Gallery"));
    }

}

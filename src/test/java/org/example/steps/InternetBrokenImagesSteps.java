package org.example.steps;

import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import org.example.pages.InternetAuthFormPage;
import org.example.pages.InternetBrokenImagesPage;
import org.example.steps.GenericSteps;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

@RequiredArgsConstructor
public class InternetBrokenImagesSteps {
    private final InternetBrokenImagesPage page;
    private final WebDriverWait wait;
    private final GenericSteps genericSteps;

    @Then("none of the broken images have loaded")
    public void none_of_the_images_has_loaded() {
        page.validateBrokenImages();
    }

    @Then("the Fork me image should appear on the page")
    public void the_fork_me_image_should_appear_on_the_page() {
        Assert.assertTrue(page.validateForkMeImage());
    }

}
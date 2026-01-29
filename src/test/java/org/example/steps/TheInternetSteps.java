package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.example.pages.TheInternetPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class TheInternetSteps extends GenericSteps{

    private final TheInternetPage page;

    public TheInternetSteps(WebDriverWait wait, TheInternetPage page) {
        super(wait);
        this.page = page;
    }


    @Given("the user is on The Internet home page")
    public void the_user_is_on_the_internet_home_page() {
        page.open();
        page.loadLinks();
    }

    @When("the user clicks the {string} link")
    public void the_user_clicks_the_link(String link) {
        page.clickLink(link);
    }


    @Then("the user is navigated to the {string}")
    public void the_user_is_navigated_to_the_new_url(String url) {
        page.assertUrl(url);
    }


    @And("the user enters their username {string} and password {string}")
    public void and_the_user_enters_their_username_and_password(String username, String password) {
        page.fillAuthenticationForm(username, password);
    }

    @And("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        page.submitAuthenticationForm();
    }

    @And("the user clicks the {string} button")
    public void the_user_clicks_the_auth_button(String buttonLabel) {
        clickLinkOrButton(buttonLabel);
    }

    @Then("{int} Delete elements exist on the page")
    public void the_new_delete_element_exists_on_the_page(int expectedCount) {
        int numDeleteButtons = page.countDeleteButtons();
        Assert.assertEquals(numDeleteButtons, expectedCount);
    }

    @And("the user clicks the {string} button {int} times")
    public void the_user_clicks_the_button_times(String buttonLabel, int times) {
        clickLinkOrButtonRepeatedly(buttonLabel, times);
    }

    @And("a banner shows the reject text: {string}")
    public void a_banner_shows_the_reject_text(String rejectText) {
        page.assertAuthBannerText(rejectText);
    }

    @Then("none of the broken images have loaded")
    public void none_of_the_images_has_loaded() {
        page.validateBrokenImages();
    }

    @Then("the Fork me image should appear on the page")
    public void the_fork_me_image_should_appear_on_the_page() {
        Assert.assertTrue(page.validateForkMeImage());
    }


}

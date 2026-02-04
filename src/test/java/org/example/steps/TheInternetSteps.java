package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.example.pages.TheInternetPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class TheInternetSteps{

    private final TheInternetPage page;
    private final WebDriverWait wait;
    private final GenericSteps genericSteps;



//    @Given("the user is on The Internet home page")
//    public void the_user_is_on_the_internet_home_page() {
//        page.open();
//        page.loadLinks();
//    }

    @Given("the user is on the Internet {string} page")
    public void the_user_is_on_the_internet_page(String path) {
        page.openPage(path);
    }


    @When("the user clicks the {string} link")
    public void the_user_clicks_the_link(String link) {
        page.clickLink(link);
    }


    @Then("the user is navigated to the {string}")
    public void the_user_is_navigated_to_the_new_url(String url) {
        page.assertUrl(url);
    }



    @And("the user clicks the {string} button {int} times")
    public void the_user_clicks_the_button_times(String buttonLabel, int times) {
        genericSteps.clickLinkOrButtonRepeatedly(buttonLabel, times);
    }





    //---------------------------------Challenging DOM Page Tests--------------------------------------------


    //checkbox---------------------------------------------------------------------

    //context menu



    //disappearing elements





}

package org.example.steps.Login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.example.pages.Login.LoginPage;
import org.example.spring.ScenarioContext;

import java.util.Random;


@RequiredArgsConstructor
public class LoginE2ESteps {

    private final LoginPage loginPage;

    private final ScenarioContext scenario;



    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page(){
        loginPage.open();
        scenario.setData("randomID",  "" +new Random().nextInt());
        scenario.getScenario().attach("Attached", "text/plain", "test");
    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_username_and_password_into_the_inputs(String username, String password) {
        loginPage.fillUsernameInput(username);
        loginPage.fillPasswordInput(password);
        String randomID = scenario.getData("randomID");
        scenario.getScenario().attach( randomID, "text/plain", "test");
    }


    @And("clicks the login button")
    public void the_user_presses_the_submit_button() {
        loginPage.clickSubmitButton();
    }

    @Then("a success message, {string} is shown on the page")
    public void the_result_is_shown_on_the_screen(String result) throws InterruptedException {
        loginPage.validateResult(result);
    }

    @Then("a rejection message {string} is shown on the page")
    public void a_rejection_message_is_shown_on_the_screen(String message) throws InterruptedException {
        loginPage.validateResult(message);
    }


}

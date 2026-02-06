package org.example.steps.Calculator;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.example.pages.Calculator.CalculatorHomePage;

@RequiredArgsConstructor
public class CalculatorE2ESteps {

    private final CalculatorHomePage homePage;



    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page(){
        homePage.open();
    }

    @When("the user enters {int} and {int} into the inputs")
    public void the_user_enters_two_ints_into_the_inputs(int num1, int num2) {
         homePage.fillInput1(num1);
         homePage.fillInput2(num2);
    }

    @Then("{int} and {int} appear on the page")
    public void the_appears_on_the_page_in_the_first_input(int num1, int num2) {
        homePage.checkInputs(num1, num2);
    }


    @And("the user selects the {string} option")
    public void the_user_selects_the_option(String option) {
        homePage.selectOperation(option);
    }

    @And("the user presses the submit button")
    public void the_user_presses_the_submit_button() {
        homePage.clickSubmitButton();
    }

    @Then("the {int} is shown on the screen")
    public void the_result_is_shown_on_the_screen(int result) throws InterruptedException {
        homePage.validateResult(result);
    }


}

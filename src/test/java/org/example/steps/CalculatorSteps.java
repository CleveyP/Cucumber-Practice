package org.example.steps;

import io.cucumber.java.en.*;
import org.example.Calculator;
import org.testng.Assert;

public class CalculatorSteps {
    Calculator calculator;
    int num1, num2;
    int result;



    @Given("the calculator is on")
    public void the_calculator_is_on(){
        System.out.println("The calculator is on");
        calculator = new Calculator();
    }

    @When("provided with two numbers {int} and {int}")
    public void provided_with_two_numbers(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    @When("we choose any number and zero")
    public void provided_with_the_first_number_and_the_second_number_is_zero(){
        this.num1 = 20;
        this.num2 = 0;
    }

    @And("the numbers are added together")
    public void the_numbers_are_added_together(){
        this.result = calculator.add(this.num1, this.num2);
    }

    @And("the numbers are subtracted from each other")
    public void the_numbers_are_subtracted_from_each_other(){
        this.result = this.calculator.subtract(this.num1, this.num2);
    }

    @And("the numbers are divided together")
    public void the_numbers_are_divided_together() throws ArithmeticException {
        this.result = this.calculator.divide(this.num1, this.num2);
    }


    @Then("the result should be {int}")
    public void the_result_should_be(int expected){
        Assert.assertEquals(this.result,expected);
    }

    @Then("we divide the two numbers and an error is shown")
    public void an_arithmetic_error_occurs() {
        Assert.expectThrows(ArithmeticException.class, () -> {
            calculator.divide(num1, num2);
        });
    }

}

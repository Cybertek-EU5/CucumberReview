package com.vytrack.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorStepDefs {

    @Given("I have calculator app open")
    public void i_have_calculator_app_open() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Running step : I have calculator app open");
    }

    @When("I add {int} to {int}")
    public void i_add_to(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Running step : I add two numbers");
    }

    @Then("I should get {int}")
    public void i_should_get(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Running step : Verifying the result");
    }


}

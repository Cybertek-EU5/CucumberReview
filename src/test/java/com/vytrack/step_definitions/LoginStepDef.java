package com.vytrack.step_definitions;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        String loginUrl = ConfigurationReader.get("url") ;
        Driver.get().get(loginUrl);

    }

    @When("the user enters the driver information")
    public void theUserEntersTheDriverInformation() {

    }

    @Then("the user should be able to login")
    public void theUserShouldBeAbleToLogin() {

    }
}

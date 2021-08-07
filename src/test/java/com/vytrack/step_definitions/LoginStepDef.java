package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {
    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        String loginUrl = ConfigurationReader.get("url") ;
        Driver.get().get(loginUrl);

    }

    @When("the user enters the driver information")
    public void theUserEntersTheDriverInformation() {

        String username = ConfigurationReader.get("driver_username") ;
        String password = ConfigurationReader.get("driver_password") ;

        LoginPage loginPage = new LoginPage() ;
        loginPage.login(username, password);


    }

    @Then("the user should be able to login")
    public void theUserShouldBeAbleToLogin() {

        BrowserUtils.waitFor(2);
        String actualTitle = Driver.get().getTitle() ;
        Assert.assertEquals("Dashboard",actualTitle);


    }

    @When("the user enters the {string} and {string}")
    public void theUserEntersTheAnd(String username, String password) {


        LoginPage loginPage = new LoginPage() ;
        loginPage.login(username, password);


    }

    @When("the user logged in as {string}")
    public void theUserLoggedInAs(String userType) {
        String username ="", password="" ;

        switch (userType){
            case "storeManager" :
                username = ConfigurationReader.get("sales_manager_username");
                password = ConfigurationReader.get("sales_manager_password");
                break ;
            case "driver" :
                username = ConfigurationReader.get("driver_username");
                password = ConfigurationReader.get("driver_password");
                break;
            case "salesManager" :
                username = ConfigurationReader.get("store_manager_username");
                password = ConfigurationReader.get("store_manager_password");
                break;

            default:
                System.out.println("UNKNOWN USER TYPE!!!");
        }

        LoginPage loginPage = new LoginPage() ;
        loginPage.login(username, password);

    }
}

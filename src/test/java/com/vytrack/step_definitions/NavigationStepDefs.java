package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigationStepDefs {

    @When("the user navigates to {string}, {string}")
    public void the_user_navigates_to(String tabName, String moduleName) {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule(tabName, moduleName);
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);

    }

    @Then("the title should be {string}")
    public void the_title_should_be(String expectedTitle) {
        // Write code here that turns the phrase above into concrete actions
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

}

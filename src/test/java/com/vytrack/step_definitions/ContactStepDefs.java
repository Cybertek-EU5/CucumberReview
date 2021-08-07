package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ContactStepDefs {

    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> expectedTabsList) {

        System.out.println("tabsList = " + expectedTabsList);
        BrowserUtils.waitFor(2);

        List<String> actualTabList =
                BrowserUtils.getElementsText(new DashboardPage().menuOptions);

        System.out.println("actualTabList = " + actualTabList);
        Assert.assertEquals(expectedTabsList, actualTabList);

    }

    @When("the user logs in using following credentials")
    public void theUserLogsInUsingFollowingCredentials(Map<String,String> userInfoMap) {

        System.out.println("userInfoMap = " + userInfoMap);
        String username = userInfoMap.get("username") ;
        String password = userInfoMap.get("password") ;

        new LoginPage().login(username, password);

    }
}

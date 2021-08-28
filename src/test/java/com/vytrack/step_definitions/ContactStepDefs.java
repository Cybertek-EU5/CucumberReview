package com.vytrack.step_definitions;

import com.vytrack.pages.ContactInfoPage;
import com.vytrack.pages.ContactPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.DBUtils;
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

    @When("the user clicks the {string} from contacts")
    public void theUserClicksTheFromContacts(String email) {

        ContactPage contactPage = new ContactPage();
        contactPage.ClickEmailToSeeDetail(email);

    }

    @Then("the information should be same with database")
    public void theInformationShouldBeSameWithDatabase() {
        System.out.println("DB VERIFY STEPS PENDING");

        // actual result is the result coming from browser
        ContactInfoPage contactInfoPage = new ContactInfoPage();
        String actualFullName = contactInfoPage.contactFullName.getText();
        String actualEmail = contactInfoPage.email.getText();
        String actualPhone = contactInfoPage.phone.getText();

        // expected result is the result you got from db queries
        String query ="select concat(first_name,' ',last_name) as full_name,e.email,phone " +
                "from orocrm_contact c join orocrm_contact_email e " +
                "on c.id = e.owner_id join orocrm_contact_phone p " +
                "on e.owner_id = p.owner_id " +
                "where e.email='"+actualEmail+"'";

        System.out.println("query = " + query);
        // we ran a query that give us expected result and stored it inside Map object
        Map<String,Object> expectedMap = DBUtils.getRowMap(query) ; // you can also use list method if available
        System.out.println("expectedMap = " + expectedMap);

        Assert.assertEquals( expectedMap.get("full_name"), actualFullName);
        Assert.assertEquals( expectedMap.get("email")    , actualEmail);
        Assert.assertEquals( expectedMap.get("phone")    , actualPhone);


    }
}

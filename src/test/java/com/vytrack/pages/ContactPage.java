package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends BasePage{

    public WebElement getContactEmail(String email){
        String xpath ="//td[contains(text(),'"+email+"')][@data-column-label='Email']";
        return Driver.get().findElement(By.xpath(xpath));
    }

    public void ClickEmailToSeeDetail(String email){

        // can we call above method to get webelement
        BrowserUtils.waitFor(3);
        getContactEmail(email).click();
    }


}

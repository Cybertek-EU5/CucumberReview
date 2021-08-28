package com.vytrack.step_definitions;

import com.vytrack.utilities.DBUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        System.out.println("Running @Before code - before each scenario");
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenario.getName()+ "_screenshot");
        }

        System.out.println("Running @After code - after each scenario");

        Driver.closeDriver();
    }

    @Before("@db")
    public void setUpConnection(){
        System.out.println("CREATING CONNECTION...");
        DBUtils.createConnection();
    }

    @After("@db")
    public void tearDownConnection(){
        System.out.println("Closing Connection");
        DBUtils.destroy();
    }






}




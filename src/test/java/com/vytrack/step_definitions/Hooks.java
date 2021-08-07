package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        System.out.println("Running @Before code - before each scenario");
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        System.out.println("Running @After code - after each scenario");

        Driver.closeDriver();
    }

    @Before("@calculator")
    public void setUpCalculator(){
        System.out.println("Running @Before code only scenario with @calculator tag");
    }

    @After("@calculator")
    public void tearDownCalculator(){
        System.out.println("Running @After code only scenario with @calculator tag");
    }





}




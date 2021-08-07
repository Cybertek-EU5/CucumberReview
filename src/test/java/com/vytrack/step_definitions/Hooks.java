package com.vytrack.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp(){
        System.out.println("Running @Before code");
    }

    @After
    public void tearDown(){
        System.out.println("Running @After code");
    }



}




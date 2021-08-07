package com.vytrack.runner;
// BREAK UNTIL 11:10

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//specifying to run it with cucumber
@RunWith(Cucumber.class)
/*
 providing option for cucumber to provide
 * where is your feature file     |  features = "feature file folder path here"
 * where is the code that match the steps in cucumber  | glue = " step definitions folder path here"
 * whether to run the actual code or just to check if you have missing steps  | dryRun = true/false
 * what kind of report you want to get and other options | plugins = ....
 */

@CucumberOptions(features = "src/test/resources/features" ,
                glue = "com/vytrack/step_definitions")


public class CukesRunner {
}

package com.discount.automation.tests;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "json:target/cucumber.json"},
        features = {"src/main/resources/features"},
        glue = {"com.discount.automation.steps"}
)

public class RunTest {

}

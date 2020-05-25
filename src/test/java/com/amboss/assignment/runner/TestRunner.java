package com.amboss.assignment.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = "src/test/java/com/amboss/assignment/features/",
        glue = {"com.amboss.assignment.steps", "com.amboss.assignment.commons"},
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
        }
)
class TestRunner {

}

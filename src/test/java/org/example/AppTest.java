package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;

/**
 * Unit test for simple App.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@Reg",
        features = {"src/test/resources/features"},
        glue = {"org.example","com.appium.stepDefinition"},
        plugin = {
                "pretty",
                "html:target/report/cucumber-report.html",
                "json:target/report/cucumber-report.json",
                "json:target/jsonReports/reports/cucumber.json"}
)
public class AppTest{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */


    /**
     * @return the suite of tests being tested
     */


    /**
     * Rigourous Test :-)
     */

}

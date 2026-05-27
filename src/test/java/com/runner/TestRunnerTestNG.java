package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/Features",
		glue = "com.stepdefinition",
		plugin = {"pretty", "html:target/reports/CucumberReport.html",
				"junit:target/junit-reports/cucumber.xml"},
		monochrome = true
		//tags = "@PositiveTest1 and @PositiveTest2 and @NegativeTest1 and @EndToEndTest"
		)

public class TestRunnerTestNG extends AbstractTestNGCucumberTests {

}

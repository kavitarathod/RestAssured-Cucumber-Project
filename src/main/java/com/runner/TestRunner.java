package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty",
		"html:target/html-reports/report.html" }, features = "feature", glue = "com.stepDefinitions", tags = "@PostFeature or @GetUser or @CommentFeature", monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}

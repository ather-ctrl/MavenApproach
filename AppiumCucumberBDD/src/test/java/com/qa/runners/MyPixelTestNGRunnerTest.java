package com.qa.runners;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;

/**
 * An example of using TestNG when the test class does not inherit from
 * AbstractTestNGCucumberTests but still executes each scenario as a separate
 * TestNG test.
 */
@CucumberOptions(plugin = {"pretty"
		, "summary", 
		"html:target/Pixel/cucumber", 
"de.monochromata.cucumber.report.PrettyReports:target/Pixel/cucumber-html-reports"}, 
dryRun=false, monochrome=true,
strict=true,features= {"src/test/resources"},
glue = {"com/qa/stepdef"}
,tags = {"@test"})
public class MyPixelTestNGRunnerTest extends RunnerBase {

	
}

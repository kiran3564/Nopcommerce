package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features=".//Features//Dashboard1.feature",
		glue="stepDefinitions",
		dryRun=false,
		monochrome=true,
		plugin = {"html:target/cucumber_html_Report.html", "pretty" }
		)

public class runner {

}

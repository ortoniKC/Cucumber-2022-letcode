package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
			features = {"src/test/java/features/"},
//			dryRun = true,
			snippets = SnippetType.CAMELCASE,
			monochrome = true,
			glue = { "steps", "hooks"},
			plugin =  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			
//			plugin = {"pretty", "html:CucumberReports",
//					"json:reports/result.json",
//					"junit:reports/result.xml"}
			tags = {"@smoke and  @reg"}
		)

public class Runner extends AbstractTestNGCucumberTests {

}

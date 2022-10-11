package hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;

public class MyHooks extends DriverInstance{
	
	@Before
	public void beforeScenario(Scenario scenario) {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://bookcart.azurewebsites.net/"); 
		Options manage =driver.manage(); 
		manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		manage.window().maximize(); 
//		System.out.println(driver.getTitle());
//		System.out.println("Scenario name - Before Scenario: ");
//		System.out.println(scenario.getName());
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		boolean failed = scenario.isFailed();
		System.out.println("is Failed? "+failed);
		if(failed) {
			byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshotAs, "image/png");
		}
		driver.quit();
	}
	
	@BeforeStep
	public void beforeStep(Scenario scenario) {
		byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshotAs, "image/png");
	}
	
	@AfterStep
	public void afterStep(Scenario scenario) {
		byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshotAs, "image/png");
	}
	
	

}

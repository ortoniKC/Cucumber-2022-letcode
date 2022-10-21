package hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.DriverInstance;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class MyHooks extends DriverInstance{
	
	@After("@cleanCart")
	public void cleanUp() {
		driver.findElement(By.xpath("(//button[contains(@class,'mat-focus-indicator mat-icon-button')]/following-sibling::button)[1]")).click();
		driver.findElement(By.xpath("//span[text()='Clear cart']/..")).click();
		String text = driver.findElement(By.tagName("mat-card-title")).getText();
		Assert.assertEquals(text, "Shopping cart is empty");
	}
	/*
	@Before(order = 2)
	public void beforeScenarioOne() {
		System.out.println("Im in beforeScenarioOne");
	}
	*/
	
	@Before(order = 1)
	public void beforeScenario(Scenario scenario) {
		System.out.println("Im in beforeScenario");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://bookcart.azurewebsites.net/"); 
		Options manage =driver.manage(); 
		manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		manage.window().maximize(); 
	
		// scenario methods
		
		System.out.println("name: "+scenario.getName());
		System.out.println("ID: "+scenario.getId());
		System.out.println("URi: "+scenario.getUri());
		System.out.println("Lines: "+scenario.getLines());
		System.out.println("Tags: "+scenario.getSourceTagNames());
		System.out.println("Status: "+scenario.getStatus());
	}
	
	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		boolean failed = scenario.isFailed();
		System.out.println("is Failed? "+failed);
		if(failed) {
			byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshotAs, "image/png");
		}
		driver.quit();
	}
	
	
	/*
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
	*/
	
	

}

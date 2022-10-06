package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {


	WebDriver driver;


	@Given("User navigate to the BookCart application login") public void
	userNavigateToTheBookCartApplication() { 
		driver = new ChromeDriver();
		driver.get("https://bookcart.azurewebsites.net/"); 
		Options manage =driver.manage(); 
		manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		manage.window().maximize(); System.out.println(driver.getTitle());
	}

	@And("User clicks on the login button")
	public void userClicksOnTheLoginButton() {
		driver.findElement(By.xpath("//span[text()='Login']")).click();
	}

	@And("User enter the username as ortoni")
	public void userEnterTheUsernameAsOrtoni() {
		driver.findElement(By.cssSelector("input[formcontrolname='username']"))
		.sendKeys("ortoni");

	}

	/*
	 * @Given("User enter the username as koushik") public void
	 * userEnterTheUsernameAsKoushik() {
	 * driver.findElement(By.cssSelector("input[formcontrolname='username']"))
	 * .sendKeys("koushik"); }
	 * 
	 * @Given("User enter the password as Passkoushik") public void
	 * userEnterThePasswordAsPasskoushik() {
	 * driver.findElement(By.cssSelector("input[formcontrolname='password']"))
	 * .sendKeys("Passkoushik"); }
	 * 
	 * 
	 * @And("User enter the password as Pass1234") public void
	 * userEnterThePasswordAsPass() {
	 * driver.findElement(By.cssSelector("input[formcontrolname='password']"))
	 * .sendKeys("pass1234");
	 * }
	 */

	@When("User click on the login button")
	public void userClickOnTheLoginButton() {
		driver.findElement(By.xpath("(//span[text()='Login'])[last()]/.."))
		.click();

	}

	@Then("Login should be success")
	public void loginShouldBeSuccess() {
		String text = driver.findElement(
				By.xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]"))
				.getText();
		System.out.println(text);
		driver.quit();
	}


	@When("Login should fail")
	public void loginShouldFail() {
		String text = driver.findElement(By.cssSelector("mat-error[role='alert']")).getText();
		Assert.assertEquals(text.trim(), "Username or Password is incorrect.");
		driver.quit();
	}

	@Given("User enter the username as {string}")
	public void userEnterTheUsernameAs(String username) {
		driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys(username);
	}

	@Given("User enter the password as {string}")
	public void userEnterThePasswordAs(String password) {
		driver.findElement(By.cssSelector("input[formcontrolname='password']")).sendKeys(password);
	}


}


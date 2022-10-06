package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToCartSteps {
	
	WebDriver driver;

	@Given("User navigate to the BookCart application")
	public void userNavigateToTheBookCartApplication() {
		driver = new ChromeDriver();
		driver.get("https://bookcart.azurewebsites.net/");
		Options manage = driver.manage();
		manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		manage.window().maximize();
		System.out.println(driver.getTitle());
	}

	@Given("user login into the application with {string} and {string}")
	public void userLoginIntoTheApplicationWithAnd(String uname, String pass) {
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		driver.findElement(By.cssSelector("input[formcontrolname='username']"))
		.sendKeys("ortoni");
		driver.findElement(By.xpath("(//span[text()='Login'])[last()]/.."))
		.click();
	}

	@Given("user search for a {string}")	
	public void userSearchForA(String bookname) {
		driver.findElement(By.cssSelector("input[type='search']")).sendKeys(bookname);
		driver.findElement(By.cssSelector("mat-option[role='option'] span")).click();
	}

	@When("user add the book to the cart")
	public void userAddTheBookToTheCart() {
		driver.findElement(By.cssSelector("button[color='primary']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("the cart badge should get updated")
	public void theCartBadgeShouldGetUpdated() {
		String text = driver.findElement(By.cssSelector("#mat-badge-content-0")).getText();
		Assert.assertEquals(Integer.parseInt(text) > 0, true);
		driver.quit();
	}	

}

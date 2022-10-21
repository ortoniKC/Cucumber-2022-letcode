/*
 * package steps;
 * 
 * import org.openqa.selenium.By;
 * import org.openqa.selenium.WebElement;
 * import org.openqa.selenium.support.ui.ExpectedConditions;
 * import org.testng.Assert;
 * 
 * import base.DriverInstance;
 * import cucumber.api.java.en.And;
 * import cucumber.api.java.en.Given;
 * import cucumber.api.java.en.Then;
 * import cucumber.api.java.en.When;
 * 
 * public class LoginSteps extends DriverInstance{
 * 
 * @And("User click on the login link")
 * public void userClicksOnTheLoginButton() {
 * driver.findElement(By.xpath("(//span[text()='Login'])[1]/..")).click();
 * }
 * 
 * @And("User enter the username as ortoni")
 * public void userEnterTheUsernameAsOrtoni() {
 * driver.findElement(By.cssSelector("input[formcontrolname='username']"))
 * .sendKeys("ortoni");
 * }
 * 
 * @When("User click on the login button")
 * public void userClickOnTheLoginButton() {
 * driver.findElement(By.xpath("(//span[text()='Login'])[last()]/.."))
 * .click();
 * }
 * 
 * @Then("Login should be success")
 * public void loginShouldBeSuccess() {
 * WebElement userEle = driver.findElement(By.
 * xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]"
 * ));
 * wait.until(ExpectedConditions.visibilityOf(userEle));
 * }
 * 
 * 
 * @When("Login should fail")
 * public void loginShouldFail() {
 * String text =
 * driver.findElement(By.cssSelector("mat-error[role='alert']")).getText();
 * Assert.assertEquals(text.trim(), "Username or Password is incorrect.");
 * }
 * 
 * @Given("User enter the username as {string}")
 * public void userEnterTheUsernameAs(String username) {
 * driver.findElement(By.cssSelector("input[formcontrolname='username']")).
 * sendKeys(username);
 * }
 * 
 * @Given("User enter the password as {string}")
 * public void userEnterThePasswordAs(String password) {
 * driver.findElement(By.cssSelector("input[formcontrolname='password']")).
 * sendKeys(password);
 * }
 * 
 * 
 * }
 * 
 */
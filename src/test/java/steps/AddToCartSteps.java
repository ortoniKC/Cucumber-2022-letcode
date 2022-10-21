/*
 * package steps;
 * 
 * import org.openqa.selenium.By;
 * import org.openqa.selenium.WebElement;
 * import org.openqa.selenium.support.ui.ExpectedConditions;
 * import org.testng.Assert;
 * 
 * import base.DriverInstance;
 * import cucumber.api.java.en.Given;
 * import cucumber.api.java.en.Then;
 * import cucumber.api.java.en.When;
 * 
 * public class AddToCartSteps extends DriverInstance{
 * 
 * @Given("user login into the application with {string} and {string}")
 * public void userLoginIntoTheApplicationWithAnd(String uname, String pass) {
 * driver.findElement(By.xpath("(//span[text()='Login'])[1]/..")).click();
 * driver.findElement(By.cssSelector("input[formcontrolname='username']"))
 * .sendKeys(uname);
 * driver.findElement(By.cssSelector("input[formcontrolname='password']"))
 * .sendKeys(pass);
 * driver.findElement(By.cssSelector("button[color='primary']")).click();
 * WebElement userEle = driver.findElement(By.
 * xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]"
 * ));
 * wait.until(ExpectedConditions.visibilityOf(userEle));
 * }
 * 
 * @Given("user search for a {string}")
 * public void userSearchForA(String bookname) {
 * driver.findElement(By.cssSelector("input[type='search']")).sendKeys(bookname)
 * ;
 * WebElement searchOption =
 * driver.findElement(By.cssSelector("span.mat-option-text"));
 * WebElement options =
 * wait.until(ExpectedConditions.visibilityOf(searchOption));
 * options.click();
 * }
 * 
 * @When("user add the book to the cart")
 * public void userAddTheBookToTheCart() {
 * WebElement addToCart =
 * driver.findElement(By.xpath("(//button[@color='primary']//span/..)[1]"));
 * wait.until(ExpectedConditions.visibilityOf(addToCart)).click();
 * }
 * 
 * @Then("the cart badge should get updated")
 * public void theCartBadgeShouldGetUpdated() {
 * WebElement snackBar = driver.findElement(By.tagName("snack-bar-container"));
 * wait.until(ExpectedConditions.visibilityOf(snackBar));
 * wait.until(ExpectedConditions.invisibilityOf(snackBar));
 * String text =
 * driver.findElement(By.cssSelector("#mat-badge-content-0")).getText();
 * System.out.println("No.of books in cart: "+text);
 * Assert.assertEquals(Integer.parseInt(text) > 0, true);
 * }
 * 
 * }
 */
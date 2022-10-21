package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.DriverInstance;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HeaderPage extends DriverInstance {

    @And("User click on the login link")
    public void userClicksOnTheLoginLink() {
        driver.findElement(By.xpath("(//span[text()='Login'])[1]/..")).click();
    }
    
    @Given("user search for a {string}")
    public void userSearchForA(String bookname) {
        WebElement search = driver.findElement(By.cssSelector("input[type='search']"));
        wait.until(ExpectedConditions.visibilityOf(search));
        search.sendKeys(bookname);
        WebElement searchOption =
                driver.findElement(By.cssSelector("span.mat-option-text"));
        WebElement options =
                wait.until(ExpectedConditions.visibilityOf(searchOption));
        options.click();
    }
    
    @Then("the cart badge should get updated")
    public void theCartBadgeShouldGetUpdated() {
        WebElement snackBar = driver.findElement(By.tagName("snack-bar-container"));
        wait.until(ExpectedConditions.visibilityOf(snackBar));
        wait.until(ExpectedConditions.invisibilityOf(snackBar));
        String text =
                driver.findElement(By.cssSelector("#mat-badge-content-0")).getText();
        System.out.println("No.of books in cart: "+text);
        Assert.assertEquals(Integer.parseInt(text) > 0, true);
    }
}

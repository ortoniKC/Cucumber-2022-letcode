package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.PageContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HeaderPage {
    
    PageContext context;
    public HeaderPage( PageContext context) {
      this.context = context;
    }

    @And("User click on the login link")
    public void userClicksOnTheLoginLink() {
        context.getDriver().findElement(By.xpath("(//span[text()='Login'])[1]/..")).click();
    }
    
    @Given("user search for a {string}")
    public void userSearchForA(String bookname) {
        WebElement search =  context.getDriver().findElement(By.cssSelector("input[type='search']"));
        context.getWait().until(ExpectedConditions.visibilityOf(search));
        search.sendKeys(bookname);
        WebElement searchOption =
                context.getDriver().findElement(By.cssSelector("span.mat-option-text"));
        WebElement options =
                context.getWait().until(ExpectedConditions.visibilityOf(searchOption));
        options.click();
    }
    
    @Then("the cart badge should get updated")
    public void theCartBadgeShouldGetUpdated() {
        WebElement snackBar = context.getDriver().findElement(By.tagName("snack-bar-container"));
        context.getWait().until(ExpectedConditions.visibilityOf(snackBar));
        context.getWait().until(ExpectedConditions.invisibilityOf(snackBar));
        String text =
                context.getDriver().findElement(By.cssSelector("#mat-badge-content-0")).getText();
        System.out.println("No.of books in cart: "+text);
        Assert.assertEquals(Integer.parseInt(text) > 0, true);
    }
}

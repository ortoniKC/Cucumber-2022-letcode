package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.DriverInstance;
import cucumber.api.java.en.When;

public class HomePage extends DriverInstance {
    
    
    @When("user add the book to the cart")
    public void userAddTheBookToTheCart() {
        WebElement addToCart =
                driver.findElement(By.xpath("(//button[@color='primary']//span/..)[1]"));
        wait.until(ExpectedConditions.visibilityOf(addToCart)).click();
    }

}

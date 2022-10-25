package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.PageContext;
import cucumber.api.java.en.When;

public class HomePage {
    
    PageContext context;
    public HomePage(PageContext context) {
        this.context = context;        
    }
    
    
    @When("user add the book to the cart")
    public void userAddTheBookToTheCart() {
        WebElement addToCart =
                context.getDriver().findElement(By.xpath("(//button[@color='primary']//span/..)[1]"));
        context.getWait().until(ExpectedConditions.visibilityOf(addToCart)).click();
    }

}

package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.PageContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPage {

    PageContext context;
    public LoginPage(PageContext context) {
        this.context = context;        
    }

    @Given("User enter the username as {string}")
    public LoginPage userEnterTheUsernameAs(String username) {
        context.getDriver().findElement(By.cssSelector("input[formcontrolname='username']")).
        sendKeys(username);
        return this;
    }

    @Given("User enter the password as {string}")
    public LoginPage userEnterThePasswordAs(String password) {
        context.getDriver().findElement(By.cssSelector("input[formcontrolname='password']")).
        sendKeys(password);
        return this;
    }

    @When("User click on the login button")
    public HomePage userClickOnTheLoginButton() {
        context.getDriver().findElement(By.xpath("(//span[text()='Login'])[last()]/.."))
        .click();
        return new HomePage(context);
    }

    @Then("Login should be success")
    public HomePage loginShouldBeSuccess() {
        WebElement userEle = context.getDriver().findElement(By.
                xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]"
                        ));
        context.getWait().until(ExpectedConditions.visibilityOf(userEle));
        assertEquals(userEle.isDisplayed(), true);
        return new HomePage(context);
    }

    @When("Login should fail")
    public LoginPage loginShouldFail() {
        String text =
                context.getDriver().findElement(By.cssSelector("mat-error[role='alert']")).getText();
        Assert.assertEquals(text.trim(), "Username or Password is incorrect.");
        return this;
    }

    @Given("user login into the application with {string} and {string}")
    public void userLoginIntoTheApplicationWithAnd(String uname, String pass) {
        new HeaderPage(context)
        .userClicksOnTheLoginLink();
        this.userEnterTheUsernameAs(uname)
        .userEnterThePasswordAs(pass)
        .userClickOnTheLoginButton();
        this.loginShouldBeSuccess();
        /*
         * this.userEnterTheUsernameAs(uname);
         * this.userEnterThePasswordAs(pass);
         * this.userClickOnTheLoginButton();
         */
    }

}

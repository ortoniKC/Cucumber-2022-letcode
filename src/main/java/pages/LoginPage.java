package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.DriverInstance;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPage extends DriverInstance{

    @Given("User enter the username as {string}")
    public LoginPage userEnterTheUsernameAs(String username) {
        driver.findElement(By.cssSelector("input[formcontrolname='username']")).
        sendKeys(username);
        return this;
    }

    @Given("User enter the password as {string}")
    public LoginPage userEnterThePasswordAs(String password) {
        driver.findElement(By.cssSelector("input[formcontrolname='password']")).
        sendKeys(password);
        return this;
    }

    @When("User click on the login button")
    public HomePage userClickOnTheLoginButton() {
        driver.findElement(By.xpath("(//span[text()='Login'])[last()]/.."))
        .click();
        return new HomePage();
    }

    @Then("Login should be success")
    public HomePage loginShouldBeSuccess() {
        WebElement userEle = driver.findElement(By.
                xpath("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]"
                        ));
        wait.until(ExpectedConditions.visibilityOf(userEle));
        assertEquals(userEle.isDisplayed(), true);
        return new HomePage();
    }

    @When("Login should fail")
    public LoginPage loginShouldFail() {
        String text =
                driver.findElement(By.cssSelector("mat-error[role='alert']")).getText();
        Assert.assertEquals(text.trim(), "Username or Password is incorrect.");
        return this;
    }

    @Given("user login into the application with {string} and {string}")
    public void userLoginIntoTheApplicationWithAnd(String uname, String pass) {
        new HeaderPage().userClicksOnTheLoginLink();
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

package com.stepdefs;

import org.openqa.selenium.WebDriver;
import com.saucePages.Authentication;
import com.utilities.DriverFactory;
import com.utilities.RobotPopupHandler;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.AWTException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import junit.framework.Assert;

public class StepsAuthentication {

    private WebDriver driver;
    private Authentication aa;

    @Before
    public void setUp() {
        // Initialize WebDriver before any step
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();

        // Initialize Page Object after WebDriver is ready
        aa = new Authentication(driver);
    }

    @Given("Launch consumer webapp")
    public void launch_consumer_webapp() {
        driver.get("https://www.saucedemo.com/");
    }

    @Given("consumer webapp Login page")
    public void consumer_webapp_login_page() {
        Assert.assertTrue(aa.loginpageName.getText().equalsIgnoreCase("Swag Labs"));
    }

    @When("Consumer enter {string} and {string}")
    public void consumer_enter_and(String username, String password) {
        aa.userNameBox.clear();
        aa.userNameBox.sendKeys(username);
        aa.passwordox.clear();
        aa.passwordox.sendKeys(password);
    }

    @When("Click on Login button")
    public void click_on_login_button() {
        aa.loginButton.click();
    }

    @Then("verify message as {string}")
    public void verify_message_as(String errorMessage) {
        String actualResult = aa.errorMessage.getText();
        Assert.assertEquals(errorMessage, actualResult);
    }

    @Then("Verify products page is appear")
    public void verify_products_page_is_appear() {

        String actualResult = aa.productPageTitle.getText();
        Assert.assertEquals("Products", actualResult);
    }


    @AfterStep
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
    }
}

package com.stepdefs;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucePages.All_Products;
import com.saucePages.Authentication;
import com.utilities.DriverFactory;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepsAll_Products {
	
	public static WebDriver driver ;
	All_Products aa =new All_Products(DriverFactory.getDriver());
	
	

	
	


	@Then("verify the title of website as {string}")
	public void verify_the_title_of_website_as(String string) {
		driver = DriverFactory.getDriver();
		String expectedResult=string;
	    String actualResult=driver.getTitle();
	    System.out.println(driver.getTitle());
	    Assert.assertEquals(expectedResult, actualResult);
	}

	@Given("consumer webapp")
	public void consumer_webapp() {
	    aa.productPageTitle.getText().equalsIgnoreCase("Products");
	}
	@When("Click on product image")
	public void click_on_product_image() {
	    aa.firstProductImage.click();
	}
	@Then("verify product dicription is display.")
	public void verify_product_dicription_is_display() {
	    boolean actualResult=aa.productDiscription.isDisplayed();
	    boolean expectedResult=true;
	    Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Given("product description")
	public void product_description() {
	    aa.productDiscription.isDisplayed();
	}

	
	
	@When("Click on back to product button")
	public void click_on_back_to_product_button() {
	    aa.backToProductButton.click();
	}
	@Then("All product should be display.")
	public void all_product_should_be_display() {
		boolean actualResult=aa.firstProductImage.isDisplayed();
		boolean expectedResult=true;
	    Assert.assertEquals(expectedResult, actualResult);
	}

	@When("Click on add to cart")
	public void click_on_add_to_cart() {
	    aa.addToCartButton.click();
	}
	@Then("Verify remove button is display")
	public void verify_remove_button_is_display() {
		boolean actualResult=aa.removeBagPackButton.isDisplayed();
		boolean expectedResult=true;
	    Assert.assertEquals(expectedResult, actualResult);
	}
	
	
	@When("Click on remove button")
	public void click_on_remove_button() {
	    aa.removeBagPackButton.click();
	}
	@Then("Verify add to cart button is display")
	public void verify_add_to_cart_button_is_display() {
		boolean actualResult=aa.addToCartButton.isDisplayed();
		boolean expectedResult=true;
	    Assert.assertEquals(expectedResult, actualResult);
	}
	

	@When("click on my cart icon")
	public void click_on_my_cart_icon() {
	    aa.mycart.click();
	}
	@Then("Verify checkout button should show")
	public void verify_checkout_button_should_show() {
	    String actualResult=aa.checkoutButton.getText();
	    String expectedResult="Checkout";
	    Assert.assertEquals(expectedResult, actualResult);
	}
















	







}

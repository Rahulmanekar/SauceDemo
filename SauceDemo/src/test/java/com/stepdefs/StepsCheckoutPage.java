package com.stepdefs;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;


import com.saucePages.Authentication;
import com.saucePages.CheckoutPage;
import com.utilities.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsCheckoutPage {
	
	CheckoutPage checkout=new CheckoutPage(DriverFactory.getDriver());
	
	@Given("Your cart page")
	public void your_cart_page() {
		checkout.productPageTitle.getText().equalsIgnoreCase("Your Cart");
	}
	@When("Click on checkout")
	public void click_on_checkout() {
	    checkout.checkoutButton.click();
	}
	@Then("Verify Your Information section open")
	public void verify_your_information_section_open() {
	    String actualResult=checkout.titleAfterCheckout.getText();
	    String expectedResult="Checkout: Your Information";
	    Assert.assertEquals(expectedResult, actualResult);
	}

	@Given("Your Information textbox")
	public void your_information_textbox() {
		checkout.titleAfterCheckout.getText().equalsIgnoreCase("Checkout: Your Information");
	}
	@When("Enter first name as {string}")
	public void enter_first_name_as(String string) {
	    checkout.firstNameBox.clear();
	    checkout.firstNameBox.sendKeys(string);
	}
	@When("Click on continue button")
	public void click_on_continue_button() {
	    checkout.continueButton.click();
	}

	@When("Enter last name as {string}")
	public void enter_last_name_as(String string) {
	    checkout.lastNameBox.clear();
	    checkout.lastNameBox.sendKeys(string);
	}

	@When("Enter pincode as {string}")
	public void enter_pincode_as(String string) {
	    checkout.pincodeBox.clear();
	    checkout.pincodeBox.sendKeys(string);
	}

	@When("Click on finish button")
	public void click_on_finish_button() {
	    checkout.finishButton.click();
	}
	@Then("Verify successfully place order message as {string}")
	public void verify_successfully_place_order_message_as(String string) {
		String actualResult=checkout.successMessageAfterPlaceOrder.getText();
		 String expectedResult="Thank you for your order!";
		    Assert.assertEquals(expectedResult, actualResult);
	}













	
	






}

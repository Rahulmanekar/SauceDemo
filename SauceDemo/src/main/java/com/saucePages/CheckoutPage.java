package com.saucePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends All_Products{

	public CheckoutPage(WebDriver rdriver) {
		super(rdriver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//*[@data-test=\"title\"]")
	public WebElement titleAfterCheckout;
	
	@FindBy(id="first-name")
	public WebElement firstNameBox;
	
	@FindBy(id="last-name")
	public WebElement lastNameBox;
	
	@FindBy(id="postal-code")
	public WebElement pincodeBox;
	
	@FindBy(id="continue")
	public WebElement continueButton;
	
	@FindBy(id="finish")
	public WebElement finishButton;
	
	@FindBy(xpath="//*[@class=\"complete-header\"]")
	public WebElement successMessageAfterPlaceOrder;

}

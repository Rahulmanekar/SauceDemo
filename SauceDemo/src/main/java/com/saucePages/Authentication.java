package com.saucePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Authentication {
	
	public static WebDriver  ldriver;
	 
	 public Authentication(WebDriver rdriver) {
	        if (rdriver == null) {
	            throw new IllegalArgumentException("WebDriver instance cannot be null!");
	        }
	        PageFactory.initElements(rdriver, this);
	        this.ldriver = rdriver;
	    }
	 
	 @FindBy(xpath="//*[@class=\"login_logo\"]")
	 public WebElement loginpageName;
	 
	 @FindBy(id="user-name")
		public WebElement userNameBox;
	 
	 @FindBy(id="password")
	 public WebElement passwordox;
	 
	 @FindBy(id="login-button")
	 public WebElement loginButton;
	 
	 @FindBy(xpath="//*[@data-test=\"error\"]")
	 public WebElement errorMessage;
	 
	 @FindBy(xpath="//*[@data-test=\"title\"]")
	 public WebElement productPageTitle;

}

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
	public static All_Products aa;
	
	

	
	


	@Then("verify the title of website as {string}")
	public void verify_the_title_of_website_as(String string) {
		driver = DriverFactory.getDriver();
		String expectedResult=string;
	    String actualResult=driver.getTitle();
	    System.out.println(driver.getTitle());
	    Assert.assertEquals(expectedResult, actualResult);
	}

	







}

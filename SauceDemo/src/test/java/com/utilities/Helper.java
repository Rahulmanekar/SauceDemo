package com.utilities;







import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Helper {
	
	public static Helper Helper;    
    private static WebDriver driver ;
    public final static int TIMEOUT = 2;
     
    private Helper() {
    	System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rahul Vijay Manekar\\OneDrive - Bookwater Tech Private Limited\\Chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
     }
    public static void openPage(String url) {
        driver.get(url);
    }
    public static String getTitle() {
        return driver.getTitle();
    }
    public static void NavBack() {
     driver.navigate().back();
    }
    public static WebDriver getDriver() {
        return driver;
    }
    public static void setUpDriver() {
        if (Helper==null) {
            Helper = new Helper();
        }
    }
     public static void tearDown() {
         if(driver!=null) {
             driver.close();
             driver.quit();
         }
         Helper = null;
     }
     
//     public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
//         WebDriverWait wait = new WebDriverWait(driver, 30);
//         return wait.until(ExpectedConditions.elementToBeClickable(element));
//     }
     
     public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    	    return wait.until(ExpectedConditions.elementToBeClickable(element));
    	}


}

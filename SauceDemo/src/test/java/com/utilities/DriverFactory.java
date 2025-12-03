package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static WebDriver driver;

    public static void initDriver() {

        if (driver == null) {

            System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();

            // 🔥 THE REAL FIX FOR CHANGE-PASSWORD POPUP
            options.addArguments("--disable-features=PasswordManagerEnabled");
            options.addArguments("--disable-features=PasswordManagerOnboarding");
            options.addArguments("--disable-features=PasswordLeakDetection");
            options.addArguments("--password-store=basic");  
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

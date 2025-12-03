package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void initDriver() {

        if (driver == null) {

            System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();

            // ============================
            //  SAFE BROWSING DISABLE FIX
            // ============================
            Map<String, Object> prefs = new HashMap<>();

            // Disable safe browsing and phishing protections
            prefs.put("safebrowsing.enabled", false);
            prefs.put("safebrowsing.disable_download_protection", true);
            prefs.put("safebrowsing.disable_client_side_phishing_detection", true);

            // Disable password manager popups
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);

            options.setExperimentalOption("prefs", prefs);

            // Disable Chrome security features that trigger leak warnings
            options.addArguments("--disable-features=SafetyCheck");
            options.addArguments("--disable-features=SecurityKeyAttestationPrompt");
            options.addArguments("--disable-features=EncryptedClientHello");
            options.addArguments("--disable-features=SafeBrowsingEnhancedProtection");
            options.addArguments("--disable-features=PasswordLeakDetection");
            options.addArguments("--disable-blink-features=PasswordLeakDetection");
            options.addArguments("--disable-blink-features=TrustedTypes,TrustTokens");

            // Stability options
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-notifications");

            // Very important → start with an isolated profile
            options.addArguments("--user-data-dir=C:/Temp/Profile_Chrome143");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

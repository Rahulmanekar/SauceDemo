🚀 SauceDemo Automation Framework

A Selenium–Cucumber based automation framework designed to test the SauceDemo web application, built using Java, Selenium, Cucumber BDD, JUnit/TestNG, WebDriverManager and POM.

The framework also includes popup handling, custom Extent reports, hooks, driver factory, and reusable utilities.

📌 Tech Stack

Java 11

Selenium WebDriver

WebDriverManager (No manual driver setup needed)

Cucumber BDD

JUnit / TestNG

Extent Reports

Page Object Model (POM)

Robot API (system popup handling)

📁 Folder Structure
SauceDemo/
│
├── src/main/java/
│   └── com.saucePages/
│       ├── All_Products.java
│       ├── Authentication.java
│       └── CheckoutPage.java
│
├── src/test/java/
│   ├── com.runner/
│   │   └── Testrunner.java
│   │
│   ├── com.stepdefs/
│   │   ├── StepsAll_Products.java
│   │   ├── StepsAuthentication.java
│   │   └── StepsCheckoutPage.java
│   │
│   └── com.utilities/
│       ├── DriverFactory.java
│       ├── Hooks.java
│       ├── Helper.java
│       └── RobotPopupHandler.java
│
├── src/test/resources/
│   └── com.feature/
│       ├── 00Authentication.feature
│       ├── 01All_Product.feature
│       └── 02CheckoutPage.feature
│
└── extent.properties

⚙️ Setup & Installation
1. Install Dependencies

Ensure the following are installed:

Java 11

Maven

Eclipse / IntelliJ

Chrome browser (recommended v135+)

2. Driver Setup – Using WebDriverManager (No Manual Driver Needed)

You do NOT need to download ChromeDriver manually.

Your DriverFactory.java should include:

WebDriverManager.chromedriver().setup();
driver = new ChromeDriver(options);

💡 Removed items

❌ No need for

System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");


❌ No need to manually match ChromeDriver version.

▶️ How to Run Tests
From IDE

Right-click on:
Testrunner.java → Run As → JUnit Test

From Maven
mvn clean test

🧪 Framework Features
✔ Page Object Model (POM)

All locators + actions reside in page classes.
Step definitions are clean & readable.

✔ Hooks for Setup/Teardown

Located under:
com.utilities.Hooks

✔ Driver Management

Handled by:
DriverFactory.java

Includes:

WebDriverManager setup

ChromeOptions with popup suppression

Automatic driver creation & cleanup

✔ Popup Handling

Two-level popup management:

1️⃣ Browser popup suppression (ChromeOptions)

Disable:

Save password popup

Notifications

Automation banners

2️⃣ Robot-based System Popup Handling

Handles OS-level popups like:

Windows security dialogs

Save/Cancel prompts

Keychain / Credential popups

Sample:

Robot robot = new Robot();
robot.keyPress(KeyEvent.VK_TAB);
robot.keyPress(KeyEvent.VK_ENTER);

🧹 Driver Lifecycle (Updated for WebDriverManager)

Driver created using WebDriverManager

ChromeOptions applied

Fresh browser session each run

Auto popup suppression

Closed in @After Hook

📄 Reporting

Extent Reports automatically generated at:

/test-output/ExtentReports/


Includes:

Step-wise logs

Screenshots

Pass/Fail summary

🚧 Future Enhancements
🔧 Core Improvements

Multi-browser support (Firefox, Edge)

Jenkins/GitHub CI integration

Dynamic test data (Excel/JSON/DB)

Retry logic for flaky tests

Headless + parallel execution

Cloud execution (BrowserStack, LambdaTest)

Auto screenshot embedding

🔔 Popup Handling Enhancements

Advanced ChromeOptions tuning

Better OS-level handling

Auto retry on blocked popups

If you want, I can also:

✅ Rewrite your DriverFactory using WebDriverManager
✅ Optimize your Hooks class
✅ Remove NPE causes
✅ Generate proper README.md for GitHub

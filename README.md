🚀 SauceDemo Automation Framework

A Selenium–Cucumber based automation framework designed to test the SauceDemo web application using Java, JUnit/TestNG, and the Page Object Model (POM).
The framework includes popup handling, custom reports, hooks, driver factory, and extensible utilities.

📌 Tech Stack

Java 11

Selenium WebDriver

Cucumber BDD

JUnit / TestNG

Extent Reports

Page Object Model (POM)

Robot API (for system-level popup handling)

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

Make sure the following are installed:

Java 11

Maven

Eclipse/IntelliJ

Chrome browser (recommended v135+)

2. ChromeDriver

You can use:

Manual driver → set path in DriverFactory.java

System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");


or WebDriverManager (optional)

▶️ How to Run Tests
Run from IDE

Right-click on:

Testrunner.java → Run As → JUnit Test

Run from Maven
mvn clean test

🧪 Framework Features
✔ Page Object Model (POM)

Clean separation of page interactions and step definitions.

✔ Hooks for Setup/Teardown

Located in:

com.utilities.Hooks

✔ Popup Handling

Newly added popup handler for system/browser alerts.

✔ Extent Reporting

Reports stored in:

/test-output/ExtentReports/

🔐 Popup Handling (New Enhancement)

The framework includes an advanced popup handler using:

ChromeOptions to suppress browser-level popups

Robot API to handle OS-level dialogs such as:

“Save password?”

“Keychain access”

“Security warnings”

“Windows credential prompts”

Code Snippet (Robot Handler)
Robot robot = new Robot();
robot.keyPress(KeyEvent.VK_TAB);
robot.keyPress(KeyEvent.VK_ENTER);

🧹 Driver Lifecycle

Using DriverFactory:

Initializes driver with ChromeOptions

Loads fresh profile each run

Handles popups automatically

Closes sessions in Hooks

📄 Reporting

📌 Extent Report gets generated after execution.

Path:

/test-output/ExtentReports/

🚧 Future Enhancements
🔧 Core Improvements

Multi-browser support (Firefox, Edge)

CI/CD integration (Jenkins & GitHub Actions)

Dynamic test data (Excel/JSON/DB)

Retry mechanism for flaky tests

Headless execution with parallel runs

Cloud execution (BrowserStack / LambdaTest)

Auto screenshot embedding in reports

🔔 Popup Handling Enhancements

Added browser password popup suppression

Integrated Robot-based popup handling mechanism

Improved stability for system/security dialogs

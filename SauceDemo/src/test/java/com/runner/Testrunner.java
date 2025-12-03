package com.runner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.java.BeforeAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true, 
		dryRun = false, 
		features = {"src/test/resources/com/feature/00Authentication.feature"
//				,"src/test/resources/com/feature/01All_Product.feature"
				},
		
		glue = "com.stepdefs", 
		plugin = { "pretty", "html:target/cucumber.html",
				//"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",}, 
		publish = true
)

public class Testrunner {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			createInstance();
		}
		return extent;
	}

	public static ExtentReports createInstance() {
		Properties properties = new Properties();
		try (FileInputStream fis = new FileInputStream("src/test/resources/extent.properties")) {
			properties.load(fis);

		} catch (IOException e) {
			e.printStackTrace();
		}

		String baseFolder = properties.getProperty("basefolder.name");
		String sparkReportPath = properties.getProperty("extent.reporter.spark.out");

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(sparkReportPath);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Extent Reports");
		sparkReporter.config().setReportName("Automation Test Results");

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		// Initialize PDF Reporter
		// String pdfReportPath =
		// properties.getProperty("extent.reporter.pdf.out");
		// if (pdfReportPath != null) {
		// ExtentPdfReporter pdfReporter = new ExtentPdfReporter(pdfReportPath);
		// extent.attachReporter(pdfReporter);
		// }

		// Initialize HTML Reporter
		String htmlReportPath = properties.getProperty("extent.reporter.html.out");
		if (htmlReportPath != null) {
			ExtentSparkReporter htmlReporter = new ExtentSparkReporter(htmlReportPath);
			htmlReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);
			extent.attachReporter(htmlReporter);
		}

		extent.setSystemInfo("OS", properties.getProperty("systeminfo.os"));
		extent.setSystemInfo("Version", properties.getProperty("systeminfo.version"));

		return extent;
	}

	// @AfterClass
	// public static void tearDown() {
	// System.out.println("Generating Allure report and sending email...");
	//
	// // Generate Allure table from results
	// String projectRoot = System.getProperty("user.dir");
	// String allureReportPath = projectRoot + "/allure-results";
	// String reportTable =
	// AllureReportEmail.generateAllureTable(allureReportPath);
	//
	// // Send email with the report table
	// AllureReportEmail.sendEmailWithTable(reportTable);
	// }
	//

}

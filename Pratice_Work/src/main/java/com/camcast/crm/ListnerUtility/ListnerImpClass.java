package com.camcast.crm.ListnerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webDriverUtility.UtilityClassObjext;

public class ListnerImpClass implements ITestListener, ISuiteListener {
	public ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		// System.out.println("Report configuration");
		Reporter.log("Report configuration", true);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvancedReport/report_" + time + ".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows_11");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println(" report backup ");
		Reporter.log("report backup", true);
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		Reporter.log("===" + testName + "=== Started", true);
	
		test = report.createTest(testName);
		UtilityClassObjext.setTest(test);
		test.log(Status.INFO, testName + "===>started<===");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		// System.out.println("======"+testName+" ==ended");
		Reporter.log("===" + testName + "=== Ended", true);
		test.log(Status.INFO, "===" + testName + "=== Ended");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		String date = new Date().toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot te = (TakesScreenshot) UtilityClassObjext.getDriver();
		String temp = te.getScreenshotAs(OutputType.BASE64);
		// File src = new File("./screenshot/" + testName + date + ".jpg");
		test.addScreenCaptureFromBase64String(temp + testName + "-" + date);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		Reporter.log("===" + testName + "=== Skipped", true);
		test.log(Status.INFO, "===" + testName + "=== Skipped ");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		

	}

	

}

package com.nobroker.utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.nobroker.ui.HomePage;
import com.nobroker.ui.SecurityOptionsPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class NoBrokerStart extends CreateSession{
	
	public static AndroidDriver<AndroidElement> driver;
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static SecurityOptionsPage so;
	public static HomePage home;
	
	

	@BeforeSuite
	public void setUpSuite() throws MalformedURLException {

		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		driver = CreateSession.Capabilities();
		
		so = new SecurityOptionsPage(driver);
		home = new HomePage(driver);
		
		
	}

	@BeforeMethod
	public void preCondition(Method method) throws IOException, InterruptedException {
		test = extent.createTest(method.getName(), "Description");
		test.log(Status.INFO, "Starting test case");
		
		so.waitforGPSPopupToLoad();
		so.getGpsPopup().click();
		so.waitforContactPopupToLoad();
		so.getContactPopup().click();
		so.waitforPhonePopupToLoad();
		so.getPhonePopup().click();
		so.waitforDeviceLocationPopupToLoad();
		so.getDeviceLocationPopup().click();
	
		test.pass("Homepage is getting displayed",MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotCapture.takeScreenshot(driver, "image")).build());
        
	}

	@AfterMethod
	public void postCondition(ITestResult result) throws Exception {

		if (ITestResult.FAILURE == result.getStatus()) {
			test.fail(MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			String temp = ScreenShotCapture.takeScreenshotFail(driver, result.getName());
			test.fail(result.getName(), MediaEntityBuilder.createScreenCaptureFromBase64String(temp).build());
			test.fail(result.getThrowable());
		} else if (ITestResult.SKIP == result.getStatus()) {
			test.skip(MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.GREY));
			String temp = ScreenShotCapture.takeScreenshotFail(driver, result.getName());
			test.skip(result.getName(), MediaEntityBuilder.createScreenCaptureFromBase64String(temp).build());
			test.skip(result.getThrowable());
		} else {
			test.pass(MarkupHelper.createLabel(result.getName() + " Passed ", ExtentColor.GREEN));
			String temp = ScreenShotCapture.takeScreenshotPass(driver, result.getName());
			test.pass(result.getName(), MediaEntityBuilder.createScreenCaptureFromBase64String(temp).build());
		}
		test.log(Status.INFO, "test case is executed");
	//	driver.closeApp();
	}

	@AfterSuite
	public void tearDownSuite() {
		extent.flush();
	}

}




package com.nobroker.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class CreateSession {

	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appPackage", "com.nobroker.app");
		cap.setCapability("appActivity", "com.nobroker.app.activities.NBSplashScreen");
		
	//	cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 700000);
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;

	}
}

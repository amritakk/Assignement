package com.nobroker.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecurityOptionsPage {
	
	WebDriver driver;

	public SecurityOptionsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getGpsPopup() {
		return driver.findElement(By.id("com.nobroker.app:id/yesPhoneState"));
	}

	public WebElement getContactPopup() {
		return driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
	}
	
	public WebElement getPhonePopup() {
		return driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
	}
	
	public WebElement getDeviceLocationPopup() {
		return driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
	}
	
	
	public void waitforGPSPopupToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(getGpsPopup()));
	}
	
	public void waitforContactPopupToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(getContactPopup()));
	}
	
	public void waitforPhonePopupToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(getPhonePopup()));
	}
	
	public void waitforDeviceLocationPopupToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(getDeviceLocationPopup()));
	}
}

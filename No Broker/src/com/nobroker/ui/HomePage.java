package com.nobroker.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

public class HomePage {
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getBuyButton() {
		return driver.findElement(By.id("com.nobroker.app:id/buyLayoutText"));
	}
	
	public WebElement getBuySearchBox() {
		return driver.findElement(By.id("com.nobroker.app:id/searchEditHome"));
	}
	
	public WebElement getCityDropdown() {
		return driver.findElement(By.id("android:id/text1"));
	}
	
	public WebElement selectCity()  {
		return (AndroidElement) ((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangalore\"))");
	}
	
	public WebElement getLocalitySearchBox() {
		return driver.findElement(By.id("com.nobroker.app:id/localityAutoCompleteTxt"));
	}
	
	public WebElement getLocalityOption() {
		return driver.findElement(By.id("com.nobroker.app:id/nearByRadio"));
	}
	
	public WebElement getNearbyCheckbox() {
		return driver.findElement(By.id("com.nobroker.app:id/nearByRadio"));
	}
	
	public WebElement getTwoBhkCheckbox() {
		return driver.findElement(By.id("com.nobroker.app:id/bhktwo"));
	}
	
	public WebElement getThreeBhkCheckbox() {
		return driver.findElement(By.id("com.nobroker.app:id/bhkthree"));
	}
	
	public WebElement getSearchButton() {
		return driver.findElement(By.id("com.nobroker.app:id/searchProperty"));
	}
	
	public WebElement getProperty()  {
		return driver.findElement(By.id("com.nobroker.app:id/cv"));
	}
	
	public WebElement getWrongInfoTab()  {
		return (AndroidElement) ((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Wrong Info\"))");
	}
	
	public WebElement getPhoneTextbox()  {
		return driver.findElement(By.id("signUp-phoneNumber"));
	}
	
	public WebElement PasswordButton(){
		return driver.findElement(By.xpath("//android.widget.RadioButton[@text='I've Password']"));
		
	}
	public WebElement GetPasswordTextBox() {
		return driver.findElement(By.xpath("//android.wiandroid.widget.EditText[@text=Enter Password]"));
		
	}
	public List<WebElement> WhatsWrong(){
		return driver.findElements(By.xpath("//android.widget.CheckBox"));
		
	}
	
	public void waitforHomePageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(getBuyButton()));
	}

	
}

package com.nobroker.test;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.nobroker.ui.SecurityOptionsPage;
import com.nobroker.utils.CreateSession;
import com.nobroker.utils.NoBrokerStart;

public class Test_NoBroker extends NoBrokerStart{
	
	@Test
	public void DemoTest() throws Exception  {
      
		home.waitforHomePageToLoad();
		home.getBuyButton().click();
		
		home.getBuySearchBox().click();
		home.getCityDropdown().click();
		home.selectCity().click();
		
		home.getLocalitySearchBox().sendKeys("Mara");
		home.getLocalityOption().click();
		home.getLocalitySearchBox().sendKeys("hsr");
		home.getLocalityOption().click();
		
		if (home.getNearbyCheckbox().isSelected() == false) {
			home.getNearbyCheckbox().click();
		}
		
		home.getTwoBhkCheckbox().click();
		home.getThreeBhkCheckbox().click();
		
		home.getSearchButton().click();
		
		Thread.sleep(3000);
		home.getProperty().click();
		
		home.getWrongInfoTab().click();
		
		Thread.sleep(3000);
		home.getPhoneTextbox().sendKeys("1237567899");
		home.PasswordButton().click();
		home.GetPasswordTextBox().sendKeys("nobroker123");
		home.getBuySearchBox().click();
		home.getCityDropdown().click();
		home.selectCity().click();
		
		home.getLocalitySearchBox().sendKeys("Mara");
		home.getLocalityOption().click();
		home.getLocalitySearchBox().sendKeys("hsr");
		home.getLocalityOption().click();
		
		if (home.getNearbyCheckbox().isSelected() == false) {
			home.getNearbyCheckbox().click();
		}
		
		home.getTwoBhkCheckbox().click();
		home.getThreeBhkCheckbox().click();
		
		home.getSearchButton().click();
		
		Thread.sleep(3000);
		home.getProperty().click();
		
		home.getWrongInfoTab().click();
		

		
	}

}

package com.udemy.smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPresentTestNG {
	
	WebDriver driver;
	
	@Test
	public void loginElementsPresentTest() {
		System.out.println("running test");

		
		boolean loginEmailBox = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
		boolean passwordBox = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();
		
		Assert.assertTrue(loginEmailBox, "Email Textbox present");
		Assert.assertTrue(passwordBox, "password Textbox present");
	}
	
	@BeforeMethod
	public void setup() {
		System.out.println("starting test");
		String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";

		driver = com.udemy.utilities.DriverFactory.open("chrome");
		driver.get(webURL);
	}
	
	@AfterMethod
	public void teardown() {
		System.out.println("closing test");
		driver.quit();
	}

}

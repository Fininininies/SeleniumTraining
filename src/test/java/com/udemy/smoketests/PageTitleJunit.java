package com.udemy.smoketests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJunit {
	// Declare variables and objects at CLASS level in order to access in multiple methods through program
	WebDriver driver;
	String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
	
	@Test
	public void pageTitleTest() {
		System.out.println("Running the Test");
		driver.get(webURL);
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "SDET Training | Account Management";
		
		assertEquals(expectedTitle, actualTitle);
	}
	
	@Before
	public void setup() {
		System.out.println("Setting up test");
		driver = com.udemy.utilities.DriverFactory.open("chrome");
	}
	
	@After
	public void teardown() {
		System.out.println("Closing the test");
		driver.quit();
	}
}
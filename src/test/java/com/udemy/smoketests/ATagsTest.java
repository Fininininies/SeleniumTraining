package com.udemy.smoketests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATagsTest {
	WebDriver driver;
	
	@Test
	public void loginElementsPresentTest() {
		System.out.println("running test");
		boolean createAccountPresent = false;
		
		//We want to test the presen e of A tags >> hyperlinks
		List <WebElement> aElements = driver.findElements(By.tagName("a"));
		
		for (WebElement aElement : aElements) {
			System.out.println(aElement.getText());
			if (aElement.getText().equals("CREATE ACCOUNT")) {
				createAccountPresent = true;
			}
		}
		
		//Assertion
		Assert.assertTrue(createAccountPresent);
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

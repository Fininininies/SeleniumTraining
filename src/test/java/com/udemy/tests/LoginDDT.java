package com.udemy.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.udemy.utilities.DriverFactory;

public class LoginDDT {
	
	WebDriver driver;
	
	@Test(dataProvider = "getData")
	public void loginTest(String name, String email, String password) {
		
		// Find elements: locate, determine action, pass params
		
		// 3. enter e-mail address
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(email);
		
		// 4. enter password
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
		
		// 5. click login
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
		
		// 6. get confirmation.
		String message = driver.findElement(By.id("conf_message")).getText();
		System.out.println("Confirmation: " + message);
		
		String pageTitle = driver.getTitle();
		System.out.println("Page title: " + pageTitle);
		

	}
	
	@BeforeMethod
	public void setup() {
		new DriverFactory();
		// 1. define the webdriver
		driver = DriverFactory.open("firefox");
		// 2. open browser and navigate to http://sdettraining.com/trguitransactions/AccountManagement.aspx
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	@AfterMethod
	public void teardown() {
		// 7. close browser
		driver.quit();
	}
	
	@DataProvider
	public String[][] getData() {
		return com.udemy.utilities.Excel.get("/Users/dfinies/hello/UserLogin.xls");
	}

}

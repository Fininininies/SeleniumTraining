package com.udemy.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.udemy.pages.DashboardPageFactory;
import com.udemy.pages.LoginPageFactory;

public class LoginFactory {
	WebDriver driver = com.udemy.utilities.DriverFactory.open("firefox");
	LoginPageFactory loginPage = new LoginPageFactory(driver);
	DashboardPageFactory dashboardPage = new DashboardPageFactory(driver);
	
	String username = "tim@testemail.com";
	String password = "trpass";
	
	@Test
	public void loginTestPageFactory() {
		
//		//1. Initialize driver
//		WebDriver driver = com.udemy.utilities.DriverFactory.open("firefox");
//		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		//2. Enter login
		//LoginPageFactory loginPage = new LoginPageFactory(driver);
		loginPage.login(username, password);
		
		//3. Get confirmation
		//DashboardPageFactory dashboardPage = new DashboardPageFactory(driver);
		dashboardPage.assertDashboardPage();
	}
	
	@Test
	public void loginTestGlobalFactory() {
		LoginPageFactory loginPage = new LoginPageFactory(driver);
		loginPage.setUserName(username);
		loginPage.setPassword(password);
		loginPage.clickSubmit();
		
		dashboardPage.assertDashboardPage();
	}
	
	@Before
	public void setup() {
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	@After
	public void teardown() {
		driver.quit();
		}
}
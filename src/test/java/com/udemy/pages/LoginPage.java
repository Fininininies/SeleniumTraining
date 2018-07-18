package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public void setUserName(String username) {
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
	}
	
	public void setPassword(String password) {
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
	}
	
	public void clickSubmit() {
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	
	
	//constructor initialized the state of the driver
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

}

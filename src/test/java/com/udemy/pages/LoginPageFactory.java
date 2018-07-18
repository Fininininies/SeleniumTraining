package com.udemy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	WebDriver driver;
	
	//Define web elements at class level
	@FindBy(id="MainContent_txtUserName")
	WebElement userNameBox;
	
	@FindBy(id="MainContent_txtPassword")
	WebElement passwordBox;
	
	@FindBy(id="MainContent_btnLogin")
	WebElement loginButton;

	//Steps
	public void setUserName(String username) {
		userNameBox.sendKeys(username);
	}
	
	public void setPassword(String password) {
		passwordBox.sendKeys(password);
	}
	
	public void clickSubmit() {
		loginButton.click();
	}
	
	//Actions
	public void login(String username, String password) {
		setUserName(username);
		setPassword(password);
		clickSubmit();
	}
	
	//constructor initialized the state of the driver
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		
		//I need to figure out what this means, the Udemy dude is very unclear. 
		//He says: initialize web elements.
		PageFactory.initElements(driver, this);
	}

}

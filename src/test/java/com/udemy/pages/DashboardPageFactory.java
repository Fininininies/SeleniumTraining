package com.udemy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPageFactory {
	
	String conf;
	String titleconf;
	WebDriver driver;
	
	//Define web elements at class level
	@FindBy(linkText="Change password")
	WebElement linkTextLink;
	
	@FindBy(id="conf_message")
	WebElement confirmationMessageBox;
	
	//Steps
	public void changePassword() {
		linkTextLink.click();
	}
	
	public void getConfirmationMessage() {
		conf = confirmationMessageBox.getText();
	}
	
	public String title() {
		return titleconf = driver.getTitle();
	}
	
	//Actions
	public void assertDashboardPage() {
		changePassword();
		getConfirmationMessage();
		title();
		
		Assert.assertTrue(conf.contains("Logged in successfully"));
		Assert.assertTrue(titleconf.contains("Account"));
	}
	
	public DashboardPageFactory(WebDriver driver) {
		this.driver = driver;
		
		//Initialize web elements
		PageFactory.initElements(driver, this);
	}


}

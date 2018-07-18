package com.udemy.demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		
		// 1. define the webdriver
		System.setProperty("webdriver.gecko.driver", "/Users/dfinies/Udemy WebDriver course/software/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		
		// 2. navigate to account management page >> click on create account
		
			// How to locate elements
			driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
			driver.findElement(By.linkText("Create Account")).click();
			
			// 3. fill out form
			driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Puffy D");
			
			driver.findElement(By.id("MainContent_txtEmail")).sendKeys("test@test.test");
			
			driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]")).sendKeys("0612347836");
			
			driver.findElement(By.cssSelector("#MainContent_txtPassword")).sendKeys("safeSAFEsafe!");
			driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys("safeSAFEsafe!");
			
			// How to interact with elements
			// radio button
			driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']")).click();
			
			//drop down menu
			new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByValue("Denmark");
			
			//checkbox
			
			driver.findElement(By.name("ctl00$MainContent$checkUpdates")).click();
			driver.findElement(By.name("ctl00$MainContent$btnSubmit")).click();
		
		// 4. get confirmation
			String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
			System.out.println("Confirmation: " + conf);
			
		
		// 5. close browser
			driver.quit();

	}
}

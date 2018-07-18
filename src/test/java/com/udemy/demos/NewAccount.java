package com.udemy.demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) {
		
		String name = "Puffy D";
		String email = "test@test.test";
		String password = "safeSAFEsafe!";
		String phoneNumber = "0612347836";
		String country = "Denmark";
		String browserType = "choo";
		String gender = "Female";
		
		Boolean weeklyMail = true;
		Boolean monthlyMail = false;
		Boolean occasionalMail = false;

		
		// Define WebDriver
		WebDriver driver;
		driver = com.udemy.utilities.DriverFactory.open(browserType);
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/a")).click();
			
		// Define web elements
		WebElement nameText= driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		WebElement emailText = driver.findElement(By.id("MainContent_txtEmail"));
		WebElement phoneText = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
		WebElement passwordText = driver.findElement(By.cssSelector("#MainContent_txtPassword"));
		WebElement confirmPasswordText = driver.findElement(By.id("MainContent_txtVerifyPassword"));
		WebElement countryText = driver.findElement(By.id("MainContent_menuCountry"));
		WebElement maleRadio = driver.findElement(By.id("MainContent_Male"));
		WebElement femaleRadio = driver.findElement(By.id("MainContent_Female"));
		WebElement weeklyCheckbox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		WebElement montlyCheckbox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
		WebElement occasionalCheckbox = driver.findElement(By.id("MainContent_checkUpdates"));
		WebElement submitButton = driver.findElement(By.name("ctl00$MainContent$btnSubmit"));
		
		// 3. fill out form
		nameText.sendKeys(name);
		emailText.sendKeys(email);			
		phoneText.sendKeys(phoneNumber);			
		passwordText.sendKeys(password);			
		confirmPasswordText.sendKeys(password);
		new Select(countryText).selectByValue(country);
		
		
		// How to interact with other HTMLelements
		// radio button
		if (gender.equalsIgnoreCase("Male")) {
			maleRadio.click();
		} else {
			femaleRadio.click();
		}
		
		//Check Box
		if (weeklyMail) {
			if(!weeklyCheckbox.isSelected()) {
				weeklyCheckbox.click();
			}
		} else {
			if (weeklyCheckbox.isSelected()) {
				weeklyCheckbox.click();
			}
		}
		
		if (monthlyMail) {
			if(!montlyCheckbox.isSelected()) {
				montlyCheckbox.click();
			}
		} else {
			if (montlyCheckbox.isSelected()) {
				montlyCheckbox.click();
			}
		}
		
		if (occasionalMail) {
			if(!occasionalCheckbox.isSelected()) {
				occasionalCheckbox.click();
			}
		} else {
			if (occasionalCheckbox.isSelected()) {
				occasionalCheckbox.click();
			}
		}
		
		submitButton.click();
	
		// 4. get confirmation & quit browser
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		String expected = "Customer information added successfully";
		if (conf.contains(expected)) {		
		System.out.println("Confirmation: " + conf);
		} else {
			System.out.println("TEST FAILED");
		}
		driver.quit();
	}

}

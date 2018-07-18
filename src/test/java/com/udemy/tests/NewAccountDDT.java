package com.udemy.tests;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


@RunWith(value = Parameterized.class)
public class NewAccountDDT {
	String name, email, phoneNumber, gender, password, country;
	WebDriver driver;
	boolean weeklyEmail, monthlyEmail, occasionalEmail;
	WebElement nameText, emailText, phoneText, passwordText, confirmPasswordText, countryText, 
	maleRadio, femaleRadio, weeklyCheckbox, montlyCheckbox, occasionalCheckbox, submitButton;
	
	//This is the test method
	@Test
	public void newAccountTest() {
		System.out.println("New Record: " + name + " " + email + " " + phoneNumber + " " + gender + " " + password + " " + country + " " + weeklyEmail + " " + monthlyEmail + " " + occasionalEmail);
		
		// Define web elements
		defineWebElements();
		
		// fill out form
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
		if (weeklyEmail) {
			if(!weeklyCheckbox.isSelected()) {
				weeklyCheckbox.click();
			}
		} else {
			if (weeklyCheckbox.isSelected()) {
				weeklyCheckbox.click();
			}
		}
		
		if (monthlyEmail) {
			if(!montlyCheckbox.isSelected()) {
				montlyCheckbox.click();
			}
		} else {
			if (montlyCheckbox.isSelected()) {
				montlyCheckbox.click();
			}
		}
		
		if (occasionalEmail) {
			if(!occasionalCheckbox.isSelected()) {
				occasionalCheckbox.click();
			}
		} else {
			if (occasionalCheckbox.isSelected()) {
				occasionalCheckbox.click();
			}
		}
		
		submitButton.click();
		
		}
	
	@Before
	public void setup() {
		System.out.println("starting test");
		String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";

		driver = com.udemy.utilities.DriverFactory.open("chrome");
		driver.get(webURL);
		driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/a")).click();
	}
	
	@After
	public void teardown() {
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		String expected = "Customer information added successfully";
		if (conf.contains(expected)) {		
		System.out.println("Confirmation: " + conf);
		} else {
			System.out.println("TEST FAILED");
		}
		System.out.println("closing test");
		driver.quit();
	}
	
	//webelements are taken out of test method to keep the focus on Selenium steps and keep distractions away
	public void defineWebElements() {
		// Define web elements
		nameText= driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		emailText = driver.findElement(By.id("MainContent_txtEmail"));
		phoneText = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
		passwordText = driver.findElement(By.cssSelector("#MainContent_txtPassword"));
		confirmPasswordText = driver.findElement(By.id("MainContent_txtVerifyPassword"));
		countryText = driver.findElement(By.id("MainContent_menuCountry"));
		maleRadio = driver.findElement(By.id("MainContent_Male"));
		femaleRadio = driver.findElement(By.id("MainContent_Female"));
		weeklyCheckbox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		montlyCheckbox = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
		occasionalCheckbox = driver.findElement(By.id("MainContent_checkUpdates"));
		submitButton = driver.findElement(By.name("ctl00$MainContent$btnSubmit"));
	}
	
	//this annotated method is designed to pass parameters in to the class via constructor
	@Parameters
	public static List<String[]> getData() {
		return com.udemy.utilities.CSV.get("/Users/dfinies/hello/UserAccounts.csv");
	}
	
	//Contstructor that passes parameters to the test method
	public NewAccountDDT(String name, String email, String phoneNumber, String gender, String password, 
			String country, String weeklyEmail, String monthlyEmail, String occasionalEmail) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.password = password;
		this.country = country;
		if (weeklyEmail.equals("TRUE")) {this.weeklyEmail = true;} else {this.weeklyEmail = false; }
		if (monthlyEmail.equals("TRUE")) {this.monthlyEmail = true;} else {this.monthlyEmail = false; }
		if (occasionalEmail.equals("TRUE")) {this.occasionalEmail = true;} else {this.occasionalEmail = false; }
	}

}

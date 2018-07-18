package com.udemy.tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {
	
	WebDriver driver;
	String browserType = "chrome";
	String city = "New York, NY, USA";
	String checkIn = "07/18/2018";
	String checkOut = "07/25/2018";
	String starRating = "star4";
	String searchResult = "1";

	
	@Test
	public void hotelReservation() {
		// 1. Search
		driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
		driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);
		driver.findElement(By.xpath("/html/body/section/div/div/div/section/div[1]/div[2]/div[2]/section[2]/form/div[4]/div[3]/div/ul/li/button")).click();
		driver.findElement(By.xpath("/html/body/section/div/div/div/section/div[1]/div[2]/div[2]/section[2]/form/div[4]/div[3]/div/ul/li/div/div/div/div[2]/div[4]/button")).click();
		driver.findElement(By.xpath("/html/body/section/div/div/div/section/div[1]/div[2]/div[2]/section[2]/form/div[4]/div[3]/div/ul/li/div/footer/div")).click();
		driver.findElement(By.xpath("/html/body/section/div/div/div/section/div[1]/div[2]/div[2]/section[2]/form/div[9]/label/button")).click();
		
		//Print the name of the city
		String actualCity = driver.findElement(By.xpath("//*[@id=\"hotelResultTitle\"]/h1")).getText();
		System.out.println("City: " + actualCity);
		
		//2. Modify search result page, give criteria
		driver.findElement(By.cssSelector("input[name='star'][id='" + starRating + "']")).click();
		
		//3. Analyze the results and make selection
		//Search results in general you want to use xpath, because that will lead you to a location (e.a. third result)
		//driver.findElement(By.xpath("//*[@id=\"25154416\"]/div[2]/div/a")).click(); - WE NEED TO GO UP A FEW TO CIRCUMVENT THE ID
		try {
			driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article[" + searchResult + "]/div[2]/div/a")).click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article[" + searchResult + "]/div[2]/div/a")).click();
		}
		
		
		//Switch the window to the popup
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		//Print hotel name and star rating
		String hotelName = driver.findElement(By.id("hotel-name")).getText();
		//String hotelRating = driver.findElement(By.cssSelector("span[class='rating-scale']")).getText();
		
		System.out.println("Hotel: " + hotelName);
		
		//4. Book the reservation
		driver.findElement(By.xpath("//*[@data-automation=\"launchETPModal\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"pay-later-button\"]")).click();
		String hotelPrice = driver.findElement(By.cssSelector("span[class='amount-value'][data-price-update='total']")).getText();
		System.out.println("Price : " + hotelPrice);
		
		//5. Fill out contact /billing
		
		
		//6. Get confirmation
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("Payment"));
	}
	
	@BeforeMethod
	public void setup() {
		driver = com.udemy.utilities.DriverFactory.open(browserType);
		driver.get("https://www.expedia.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}

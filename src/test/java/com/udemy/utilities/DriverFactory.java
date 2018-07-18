package com.udemy.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	//this method will return a webdriver object
	public static WebDriver open(String browserType) {
		if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/dfinies/Udemy WebDriver course/software/geckodriver");
			return new FirefoxDriver();
		}
		else if(browserType.equalsIgnoreCase("safari")) {
			System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
			return new SafariDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver", "/Users/dfinies/Udemy WebDriver course/software/chromedriver");
			return new ChromeDriver();
		}
	}
}

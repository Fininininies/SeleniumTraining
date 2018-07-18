package stepImplementations;

import org.openqa.selenium.WebDriver;

import com.udemy.pages.DashboardPageFactory;
import com.udemy.pages.LoginPageFactory;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BDDLoginTest {
	
	WebDriver driver;

	@Given("^user is on the login page$")
	public void user_is_on_the_login_page() {
		driver = com.udemy.utilities.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	@When("^user enters correct username and correct password$")
	public void user_enters_correct_username_and_correct_password() {
		LoginPageFactory loginPage = new LoginPageFactory(driver);
		System.out.println("User enters username and password");
		loginPage.login("tim@testemail.com", "trpass");
	}
	
	@When("^user enters email (.*)$")
	public void user_enters_email(String username) {
		LoginPageFactory loginPage = new LoginPageFactory(driver);
		System.out.println("Testing un: " + username);
		loginPage.setUserName(username);
	}
	
	@And("^user enters password (.*)$")
	public void user_enters_password(String password) {
		LoginPageFactory loginPage = new LoginPageFactory(driver);
		System.out.println("Testing pw: " + password);	
		loginPage.setPassword(password);
		click_login();
	}
	
//	@And("^user clicks login button$")
	public void click_login() {
		LoginPageFactory loginPage = new LoginPageFactory(driver);
		loginPage.clickSubmit();
	}
	
	@Then("^user gets logged in$")
	public void user_gets_logged_in() {
		System.out.println("User gets confirmation");
		//3. Get confirmation
		DashboardPageFactory dashboardPage = new DashboardPageFactory(driver);
		dashboardPage.assertDashboardPage();
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}

package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LikedInHomePage;
import pages.LinkedInLoginPage;
import pages.LinkedInSearchPage;

public class TestLikedIn {
	String driverPath = "driver\\chromedriver.exe";
	WebDriver driver;
	LinkedInLoginPage objLogin;
	LikedInHomePage objHomePage;
	LinkedInSearchPage objSearchPage;
	
	//Test data
	String baseUrl = "https://www.linkedin.com/";
	String loginUser = " ";
	String loginPass = " ";
	String searchText = "Vi Le";
	String sendMessage = "Hello, Kamaljeet. This is the auto message from Tri Nguyen";

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	/**
	 * 
	 * This test case will login in https://www.linkedin.com/
	 * Search out “Profectus Kamaljeet“.
	 * Send a message to Kamaljeet
	 * Logout
	 * @throws InterruptedException 
	 * 
	 */
	@Test(priority = 0)
	public void test_Home_Page_Appear_Correct() throws InterruptedException {
		// Create Login Page object
		objLogin = new LinkedInLoginPage(driver);

		// login to LinkedIn
		objLogin.loginToLinkedIn(loginUser, loginPass);
		
		// On Homepage, Search out “Profectus Kamaljeet“.
		// Create Home Page object
		objHomePage = new LikedInHomePage(driver);
		objHomePage.searchUser(searchText);
		
		// Create Search Page object
		objSearchPage = new LinkedInSearchPage(driver);
		//Send a message
		objSearchPage.clickMessageButton();
		objSearchPage.inputMessage(sendMessage);
		objSearchPage.clickSendButton();
		//Sign out
		objSearchPage.clickAvatarImage();
		objSearchPage.clickSignOutButton();
	}
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInSearchPage {
	WebDriver driver;
	@FindBy(xpath = "(//button[@class=\"artdeco-button artdeco-button--2 artdeco-button--secondary ember-view\"])[1]")
	WebElement messageBtn;
	@FindBy(xpath = "//*[@data-placeholder=\"Write a message…\"]/preceding-sibling::div/p")
	WebElement messageTxt;
	@FindBy(xpath = "//*[@class=\"msg-form__send-button artdeco-button artdeco-button--1\"]")
	WebElement sendBtn;
	@FindBy(xpath = "//button[@class=\"global-nav__primary-link artdeco-dropdown__trigger artdeco-dropdown__trigger--placement-bottom ember-view\"]")
	WebElement avatarImg;
	@FindBy(xpath = "//*[contains(text(),'Sign Out')]")
	WebElement signOutBtn;
	
	//contractor
	public LinkedInSearchPage(WebDriver driver) {
		this.driver = driver;
		//This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
	}

	// Click message Button
	public void clickMessageButton() throws InterruptedException {
		messageBtn.click();
		Thread.sleep(2000);
	}
	
	//Send message to the user
	public void inputMessage(String message) {
		messageTxt.sendKeys(message);
	}
	
	//Click on Send button
	public void clickSendButton() {
		sendBtn.click();
	}
	
	//Click on user avatar
	public void clickAvatarImage() throws InterruptedException {
		avatarImg.click();
		Thread.sleep(2000);
	}
	
	//Click on SignOut button
	public void clickSignOutButton() throws InterruptedException {
		signOutBtn.click();
		Thread.sleep(3000);
		driver.close();
	}
}

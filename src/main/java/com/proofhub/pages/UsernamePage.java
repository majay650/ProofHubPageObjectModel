package com.proofhub.pages;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.proofhub.base.Base;

public class UsernamePage extends Base {
	// declare explicit wait at top of page class
	WebDriverWait wait = new WebDriverWait(driver, 20);
	Actions action = new Actions(driver);
	// WebDriverWait wait;
	// this class contains web elements of login page and methods to be performed on
	// login page

	@FindBy(xpath = "//label[@id='label-1015']")
	WebElement companyNameLoginPage;

	@FindBy(xpath = "//input[@name='userNameEmail']")
	WebElement emailField;

	@FindBy(xpath = "//span[contains(text(),'NEXT')][@id='button-1019-btnInnerEl']")
	WebElement nextButton;

	@FindBy(linkText = "Need help?")
	WebElement helpLink;
	
	@FindBy(xpath = "//ul/li[contains(.,\"Field can't be left blank\")]" )
	WebElement usernameValidationMsg;

	@FindBy(xpath = "//div[contains(text(),'Log in to continue')]")
	WebElement loginText;
	
	// Initialize the web elements created for login page
	public UsernamePage() {
		PageFactory.initElements(driver, this);
	}

	// Methods to be performed on login page

	public String verifyUsernamePageTitle() {
		wait.until(ExpectedConditions.visibilityOf(emailField));
		return driver.getTitle();
	}

	public boolean verifyCompanyName() {
		return companyNameLoginPage.isDisplayed();

	}

	public String clickHelpLink() {
		String handle = driver.getWindowHandle();
		System.out.println(handle);
		helpLink.click();
		Set handles = driver.getWindowHandles();
		System.out.println(handles);
		for(String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
		return driver.getTitle();	
		//driver.close();
		//System.out.println( driver.getTitle());
	}
	
	public PasswordPage enterEmail(String un) {
		emailField.sendKeys(un);
		nextButton.click();
		return new PasswordPage();
	}
	
	public boolean verifyBlankUsernameValidationMsgPresence() {
		nextButton.click();
		action.moveToElement(emailField).build().perform();
		return usernameValidationMsg.isDisplayed();
	}

	
	public boolean verifyLoginTextOnUsernamePage() {
		return loginText.isDisplayed();	
		
	}	
	
	public boolean verifyNextButtonPresence() {
		return nextButton.isDisplayed();
	}
	
}

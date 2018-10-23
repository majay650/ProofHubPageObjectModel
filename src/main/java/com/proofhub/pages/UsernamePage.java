package com.proofhub.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.proofhub.base.Base;

public class UsernamePage extends Base {
	//declare explicit wait at top of page class
	WebDriverWait wait = new WebDriverWait(driver, 20);
	//WebDriverWait wait;
	// this class contains webelements of login page and methods to be performed on
	// login page

	@FindBy(xpath = "//label[@id='label-1015']")
	WebElement companyNameLoginPage;

	@FindBy(xpath = "//input[@name='userNameEmail']")
	WebElement emailField;

	@FindBy(xpath = "//span[contains(text(),'NEXT')][@id='button-1019-btnInnerEl']")
	WebElement nextButton;

	// Initialize the webelements created for login page
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

	public LoginPage enterEmail(String un) {
		emailField.sendKeys(un);
		nextButton.click();
		return new LoginPage();
	}

}

package com.proofhub.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.proofhub.base.Base;

public class PasswordPage extends Base {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	UsernamePage usernamePage = new  UsernamePage();

	// create page factory for all elements of password page here

	@FindBy(xpath = "//input[@name='userPassword']")
	WebElement passwordField;

	@FindBy(xpath = "//span[contains(text(),'LOG IN')][@id='button-1036-btnInnerEl']")
	WebElement loginButton;

	@FindBy(xpath = "//label[contains(text(),'aj*********ur@sdplabs.com')][@id='label-1034']")
	WebElement usernameOnPasswordPage;

	@FindBy(xpath = "//label[@id='label-1032']")
	WebElement comanyNamePasswordPage;
	
	@FindBy (linkText = "Back to login")
	WebElement  backToLoginLink;
	
	@FindBy(linkText = "Forgot password?")
	WebElement forgotPasswordLink;
	
	// initialize the page factory elements

	public PasswordPage() {
		PageFactory.initElements(driver, this);
	}

	// define methods to be performed on password page

	public boolean verifyUsernameOnPasswordPage() {
		wait.until(ExpectedConditions.visibilityOf(usernameOnPasswordPage));
		return usernameOnPasswordPage.isDisplayed();
	}

	public HomePage enterPassword(String pwd) {
		passwordField.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
	}

	public boolean verifyCompanyNameOnPasswordPage() {
		wait.until(ExpectedConditions.visibilityOf(usernameOnPasswordPage));
		
		return comanyNamePasswordPage.isDisplayed();
		
	}
	
	public boolean loginButtonPresence() {
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		return loginButton.isDisplayed();
		
	}
	
	public boolean backToLoginFunctionality() {
		backToLoginLink.click();
		return usernamePage.loginText.isDisplayed();
	}
	
	public ForgotPasswordPage clickForgotPassword() {
		forgotPasswordLink.click();
		return new ForgotPasswordPage();
	}
	
}

package com.proofhub.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.proofhub.base.Base;

public class ForgotPasswordPage extends Base {
	
	//define page factory for all elements of forgot password page here
	
	@FindBy(xpath = "//div[contains(text(),'Forgot password?')]")
	WebElement forgotPasswordText;
	
	@FindBy(xpath= "//div[starts-with(text(),'Enter your email and')]")
	WebElement forgotPasswordMessage; 
	
	//Initialize the elements of page factory
	public ForgotPasswordPage() {
	PageFactory.initElements(driver, this);
	}
	
	//Write methods for forgot password page here
	
	public boolean verifyForgotPasswordWindowTitle() {
		return forgotPasswordText.isDisplayed();		
	}
	
	public boolean forgotPasswordMessage() {
		return forgotPasswordMessage.isDisplayed();
	}
	
	
}

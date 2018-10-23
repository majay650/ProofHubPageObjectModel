package com.proofhub.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.proofhub.base.Base;

public class PasswordPage extends Base{
	
	//create page factory for all elements of password page here
	
	@FindBy(xpath="//input[@name='userPassword']")
	WebElement passwordField;

	@FindBy(xpath="//span[contains(text(),'LOG IN')][@id='button-1036-btnInnerEl']")
    WebElement loginButton;

	@FindBy(xpath="//label[contains(text(),'aj*********ur@sdplabs.com')]")
	WebElement usernameOnPasswordPage;
	
	
//initialize the page factory elements
	
public PasswordPage() {
	PageFactory.initElements(driver,  this);
}

//define methods to be performed on password page

public boolean verifyUsernameOnPasswordPage() {
	return usernameOnPasswordPage.isDisplayed();

}


public HomePage enterPassword(String pwd) {
	passwordField.sendKeys(pwd);
	loginButton.click();
		return new HomePage();
}


















}

package com.proofhub.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.proofhub.base.Base;

public class HomePage extends Base {
	
	@FindBy(xpath = "//b[contains(text(),'Ajay')]")
	WebElement usernameHomePage;

	
	public HomePage() {
		
		PageFactory.initElements(driver,  this);
	}
	
	public boolean verifyHomePageAfterLogin() {
		return usernameHomePage.isDisplayed();
		
	}
	
	
	
	
	
	
	
	
	
	
}

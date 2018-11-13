package com.proofhub.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.proofhub.base.Base;
import com.proofhub.pages.ForgotPasswordPage;
import com.proofhub.pages.PasswordPage;
import com.proofhub.pages.UsernamePage;
import com.proofhub.util.TestUtil;

public class ForgotPasswordPageTest extends Base {

	UsernamePage usernamePage;
	PasswordPage passwordPage;
	TestUtil testUtil;
	ForgotPasswordPage forgotPasswordPage;
	
	//Write test cases for forgot password page
	
	public  ForgotPasswordPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		super.initialization();
		forgotPasswordPage = new ForgotPasswordPage();
		usernamePage = new UsernamePage();
		passwordPage = new PasswordPage();
		passwordPage = usernamePage.enterEmail(prop.getProperty("username"));
		forgotPasswordPage = passwordPage.clickForgotPassword();
	}
	
	@Test(priority = 1)
	public void verifyForgotPasswordWindowTitleTest() {
	boolean flag =	forgotPasswordPage.verifyForgotPasswordWindowTitle();
		Assert.assertTrue(flag, "Forgot password? title text is not displayed on forgot password window");
	}
	
	
	@Test(priority=2)
	public void verifyForgotPasswordMessage() {
	boolean flag = 	forgotPasswordPage.forgotPasswordMessage();
		Assert.assertTrue(flag, "Forgot password message displayed not correct");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

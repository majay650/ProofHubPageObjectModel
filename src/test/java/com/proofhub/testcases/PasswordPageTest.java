package com.proofhub.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.proofhub.base.Base;
import com.proofhub.pages.HomePage;
import com.proofhub.pages.PasswordPage;
import com.proofhub.pages.UsernamePage;
import com.proofhub.util.TestUtil;

public class PasswordPageTest extends Base{
	
	PasswordPage passwordPage;
	HomePage homePage;
	UsernamePage usernamePage;
	TestUtil testUtil;
//write testcases of password page using testNG
	
	public PasswordPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();

		usernamePage = new UsernamePage();
	testUtil = new TestUtil();
	passwordPage = usernamePage.enterEmail(prop.getProperty("username"));
	}
	
	@Test(priority = 1)
	public void verifyUsernameOnPasswordPageTest() {
		boolean flag = passwordPage.verifyUsernameOnPasswordPage();
		Assert.assertTrue(flag);
		
		
	}
	
	@Test(priority = 2)
	public void enterPasswordTest() {
		homePage = passwordPage.enterPassword(prop.getProperty("password"));

	}
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}

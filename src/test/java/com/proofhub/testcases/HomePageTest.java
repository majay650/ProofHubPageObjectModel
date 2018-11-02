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

public class HomePageTest extends Base {
	HomePage homePage;
	TestUtil testUtil;
	UsernamePage usernamePage;
	PasswordPage passwordPage;
	
	public HomePageTest() {
		
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		 homePage = new HomePage();
		testUtil = new TestUtil();
		usernamePage = new UsernamePage();
		passwordPage = new PasswordPage();
		passwordPage = usernamePage.enterEmail(prop.getProperty("username"));
		homePage = passwordPage.enterPassword(prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageAfterLoginTest() {
		boolean flag = homePage.verifyHomePageAfterLogin();
		Assert.assertTrue(true, "Useraname is not displayed on home page after login");
		
	}
	
	
	
	@AfterMethod
		public void tearDown() {
	driver.quit();		
		} 
	
	
}

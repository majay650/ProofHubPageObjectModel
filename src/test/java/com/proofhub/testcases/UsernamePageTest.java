package com.proofhub.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.proofhub.base.Base;
import com.proofhub.pages.LoginPage;
import com.proofhub.pages.UsernamePage;

public class UsernamePageTest extends Base {
	UsernamePage usernamePage;
	LoginPage loginPage;
	// UsernamePage usernamePage;
	// We will create test cases for username page using testNg annotations

	public UsernamePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		usernamePage = new UsernamePage();

	}

	@Test(priority = 1)
	public void verifyUsernamePageTitleTest() {
		String title = usernamePage.verifyUsernamePageTitle();
		Assert.assertEquals(title, "selenium", "Page title on username page not correct");
	}

	@Test(priority = 2)
	public void verifyCompanyName() {
		boolean flag = usernamePage.verifyCompanyName();
		Assert.assertTrue(flag, "Company name is not displayed on username page");
	}

	@Test(priority = 3)
	public void enterEmail() {
		loginPage = usernamePage.enterEmail(prop.getProperty("username"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
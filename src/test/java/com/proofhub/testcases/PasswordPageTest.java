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

public class PasswordPageTest extends Base {

	PasswordPage passwordPage;
	HomePage homePage;
	UsernamePage usernamePage;
	TestUtil testUtil;
	// write test cases of password page using testNG

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
		Assert.assertTrue(flag, "Issue in displaying username on password page");

	}

	@Test(priority = 2)
	public void enterPasswordTest() {
		homePage = passwordPage.enterPassword(prop.getProperty("password"));

	}

	@Test(priority = 3)
	public void companyNameOnPasswordPageTest() {

		boolean flag = passwordPage.verifyCompanyNameOnPasswordPage();
		Assert.assertTrue(flag, "Issue in displaying company name on password page");
	}

	@Test(priority = 4)
	public void loginButtonPresenceTest() {

		boolean flag = passwordPage.loginButtonPresence();
		Assert.assertTrue(flag, "Issue in displaying login button on password page");
	}

	@Test(priority = 5)
	public void backToLoginFunctionalityTest() {
		boolean flag = passwordPage.backToLoginFunctionality();
		Assert.assertTrue(flag, "Back to login link not working properly/username not displayed");
	}

	@Test(priority = 6)
	public void clickForgotPassword() {

	}

	@Test(priority = 7)
	public void forgotPasswordFunctionalityTest() {

	}

	// @AfterMethod
	// public void tearDown() {
	// driver.quit();
	// }

}

package com.proofhub.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.proofhub.base.Base;
import com.proofhub.pages.PasswordPage;
import com.proofhub.pages.UsernamePage;

public class UsernamePageTest extends Base {
	UsernamePage usernamePage;
	PasswordPage passwordPage;
	// UsernamePage usernamePage;
	// We will create test cases for user name page using testNg annotations

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
	//System.out.println("title is:" +title);
	}

	@Test(priority = 2)
	public void verifyCompanyName() {
		boolean flag = usernamePage.verifyCompanyName();
		Assert.assertTrue(flag, "Company name is not displayed on username page");
	}

	@Test(priority = 3)
	public void clickHelpLinkTest() {
		String title = usernamePage.clickHelpLink();
		Assert.assertEquals(title, "Login - ProofHub Help", "Title of help link is not correct");
	}

	@Test(priority = 4)
	public void enterEmailTest() {
		passwordPage = usernamePage.enterEmail(prop.getProperty("username"));
	}

	@Test(priority = 5)
	public void blankUsernameValidationMsgTest() {
		boolean flag = usernamePage.verifyBlankUsernameValidationMsgPresence();
		Assert.assertTrue(flag, "Blank user validation message is not displayed");
		// System.out.println("xpath text is:" +text);
	}

	@Test(priority = 6)
	public void verifyLoginTextOnUsernamePageTest() {
		boolean flag = usernamePage.verifyLoginTextOnUsernamePage();
		Assert.assertTrue(flag, "Login to continue  text is not displayed on username page");

	}

	@Test(priority = 7)
	public void veriftNextButtonPresenceTest() {
		boolean flag = usernamePage.verifyNextButtonPresence();
		Assert.assertTrue(flag, "Next button is not displayed on username page");
		 System.out.println("flag is:" +flag);
		
	}

	 @AfterMethod
	 public void tearDown() {
	 driver.quit();
	 }

}

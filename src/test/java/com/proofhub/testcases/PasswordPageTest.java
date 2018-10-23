package com.proofhub.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.proofhub.base.Base;
import com.proofhub.pages.PasswordPage;

public class PasswordPageTest extends Base{
	PasswordPage passwordPage;
//write testcases of password page using testNG
	
	public PasswordPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		 passwordPage = new PasswordPage();
	
	
	}
	
	@Test(priority = 1)
	public void verifyUsernameOnPasswordPageTest() {
		boolean flag = passwordPage.verifyUsernameOnPasswordPage();
		Assert.assertTrue(flag);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}

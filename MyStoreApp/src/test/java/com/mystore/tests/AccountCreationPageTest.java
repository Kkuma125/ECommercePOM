package com.mystore.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mysrtore.base.BaseClass;
import com.mystore.pages.AccountCreationPage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.LoginPage;

public class AccountCreationPageTest extends BaseClass {
	IndexPage indexpage;
	LoginPage loginPage;

	AccountCreationPage accountCreationPage;

	@BeforeMethod
	public void setUp() {
		LaunchApp(); 	


	}
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	@Test
	public void verifyCreateAccountPageTest() {
		indexpage = new IndexPage(driver); 
		loginPage = indexpage.clickOnSignIn();
		accountCreationPage = loginPage.createNewAccount("124@gmail.com");
		boolean createact = accountCreationPage.verifyAccountCreatePage();
		System.out.println("We Are Reached Create an account Page : " + createact );
		Assert.assertTrue(createact);

	}

} 




package com.mystore.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mysrtore.base.BaseClass;
import com.mystore.pages.HomePage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.LoginPage;

public class LoginPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage  homePage;

	@BeforeMethod
	public void setUp() {
		LaunchApp();


	}
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	@Test
	public void loginTest() {
		indexPage = new IndexPage(driver);
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String ActualUrl = homePage.getCurrentUrl();
		String Expurl = "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(ActualUrl, Expurl);
		
	}
	
	

}	

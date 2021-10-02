package com.mystore.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mysrtore.base.BaseClass;
import com.mystore.pages.HomePage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.LoginPage;

public class HomePageTest extends BaseClass  {
	IndexPage indexpage;
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
	public void wishListTest() {
		indexpage = new IndexPage(driver);
		loginPage = indexpage.clickOnSignIn();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean results = 	homePage.validateMywishlist();
		Assert.assertTrue(results);	
	}	
	@Test
	public void OrderListTest() {
		indexpage = new IndexPage(driver);
		loginPage = indexpage.clickOnSignIn();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean results = 	homePage.validateOrderHistory();
		Assert.assertTrue(results);	
	}
	
	
	
}

package com.mystore.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mysrtore.base.BaseClass;
import com.mystore.pages.AccountCreationPage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.LoginPage;
import com.mystore.pages.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	IndexPage indexpage;
	LoginPage loginPage;
	SearchResultPage searchResultPage;

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
	public void productAvailabilityTest() {
		indexpage = new IndexPage(driver); 
		searchResultPage= indexpage.searchProduct("T-Shirt");
		boolean result = searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
	}
	
	
}
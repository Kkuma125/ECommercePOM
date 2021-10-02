package com.mystore.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mysrtore.base.BaseClass;
import com.mystore.pages.IndexPage;

public class IndexPageTest extends BaseClass {
	IndexPage indexPage;
	
	@BeforeMethod
	public void setUp() {
		LaunchApp();


	}
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	@Test
	public void verifyLogo() {
		Assert.assertTrue(indexPage.validateLogo());
	}

	@Test
	public void verifyTitle() {
		indexPage = new IndexPage(driver);
		String Title = indexPage.getTitle();
		String ExpectedTitle = "My Store";
		Assert.assertEquals(Title, ExpectedTitle);
	}

} 	

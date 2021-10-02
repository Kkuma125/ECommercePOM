package com.mystore.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mysrtore.base.BaseClass;
import com.mystore.pages.AddToCartPage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.OrderPage;
import com.mystore.pages.SearchResultPage;

public class OrderPageTest extends BaseClass {

	IndexPage indexpage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;


	@BeforeMethod
	public void setUp() {
		LaunchApp(); 	


	}
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test
	public void verifyTotalPrice() {
		indexpage = new IndexPage(driver);
		searchResultPage = indexpage.searchProduct("T-Shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQty("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickColor(); 
		addToCartPage.clickAddToCartbtn();
		orderPage = addToCartPage.clickOnCheckout();
		Double unitPrice = orderPage.getUnitPrice();
		Double TotalPrice =orderPage.TotalPrice();
		Double totalExpectedPrice =(unitPrice*2)+ 2;
		Assert.assertEquals(TotalPrice, totalExpectedPrice);
		
		
	}
	
}

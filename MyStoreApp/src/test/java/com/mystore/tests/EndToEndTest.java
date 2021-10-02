package com.mystore.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mysrtore.base.BaseClass;
import com.mystore.pages.AddToCartPage;
import com.mystore.pages.AddressPage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.LoginPage;
import com.mystore.pages.OrderConfirmationPage;
import com.mystore.pages.OrderPage;
import com.mystore.pages.OrderSummaryPage;
import com.mystore.pages.PaymentPage;
import com.mystore.pages.SearchResultPage;
import com.mystore.pages.ShippingPage;

public class EndToEndTest  extends BaseClass{
	IndexPage indexpage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;

	@BeforeMethod
	public void setUp() {
		LaunchApp(); 	


	}
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
	@Test
	public void endToEndTest() {
		
		indexpage = new IndexPage(driver);
		searchResultPage = indexpage.searchProduct("T-Shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQty("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickColor(); 
		addToCartPage.clickAddToCartbtn();
		orderPage = addToCartPage.clickOnCheckout();
		loginPage =orderPage.clickOncheckout();
		addressPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage =addressPage.clickonCheckOut();
		shippingPage.clickOnTerms();
		paymentPage =shippingPage.clickOncheckout();
		orderSummaryPage = paymentPage.clickOnBankwire();
		orderConfirmationPage =orderSummaryPage.clickOnconfirmOrder();
		String ActualMsg =orderConfirmationPage.ConfirmationMsg();
		String ExpectedMsg = "Your order on My Store is complete.";
		Assert.assertEquals(ActualMsg, ExpectedMsg);
		System.out.println("End to End AddToCart Order is Successfully Completed.....>>>");
	}
}

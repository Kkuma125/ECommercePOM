package com.mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mysrtore.base.BaseClass;
import com.mystore.utility.GetElement;


public class ShippingPage extends BaseClass {

	GetElement Util;
	
	By CheckBox = By.id("uniform-cgv");
	By Checkout = By.xpath("//button/span[contains(text(),'Proceed to checkout')]");
	
	public ShippingPage(WebDriver driver) {
		this.driver = driver;
		Util = new GetElement(this.driver);
	}
	
	public void clickOnTerms() {
		Util.doClick(CheckBox);
		
	}
	public PaymentPage clickOncheckout() {
		Util.doClick(Checkout);
		return new PaymentPage(driver);
	}
	
}

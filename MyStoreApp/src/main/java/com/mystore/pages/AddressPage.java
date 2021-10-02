package com.mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mysrtore.base.BaseClass;
import com.mystore.utility.GetElement;


public class AddressPage extends BaseClass {
	GetElement Util;
	
	By ProceedToCheckOut = By.xpath("//span[text()='Proceed to checkout']");
	
	public AddressPage(WebDriver driver) {
		this.driver = driver;
		Util = new GetElement(this.driver);
	}

	public ShippingPage clickonCheckOut() {
		Util.doClick(ProceedToCheckOut);
		return new ShippingPage(driver);
	}
	
	
}

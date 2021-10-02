package com.mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mysrtore.base.BaseClass;
import com.mystore.utility.GetElement;


public class OrderSummaryPage extends BaseClass {


	GetElement Util;

	By ConfirmOrderBtn = By.xpath("//span[text()='I confirm my order']");

	public OrderSummaryPage(WebDriver driver) {
		this.driver = driver;
		Util = new GetElement(this.driver);
	}
	
	public OrderConfirmationPage clickOnconfirmOrder() {
		Util.doClick(ConfirmOrderBtn);
		return new OrderConfirmationPage(driver);
	}
	
	 
}




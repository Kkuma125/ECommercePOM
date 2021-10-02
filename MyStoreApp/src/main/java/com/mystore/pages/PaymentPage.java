package com.mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mysrtore.base.BaseClass;
import com.mystore.utility.GetElement;


public class PaymentPage extends BaseClass {

	
	GetElement Util;
	
	By BankWire = By.xpath("//a[@class='bankwire']");
	
	
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		Util = new GetElement(this.driver);
	}
	
	public OrderSummaryPage clickOnBankwire() {
		Util.doClick(BankWire);
		return new OrderSummaryPage(driver);
	}
}

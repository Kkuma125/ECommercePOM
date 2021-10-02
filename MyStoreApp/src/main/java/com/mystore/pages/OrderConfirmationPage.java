package com.mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mysrtore.base.BaseClass;
import com.mystore.utility.GetElement;


public class OrderConfirmationPage extends BaseClass {
	
	GetElement Util;

	By ConfirmMsg = By.xpath("//strong[text()='Your order on My Store is complete.']");

	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
		Util = new GetElement(this.driver);
	}
	
	public String ConfirmationMsg() {
		String msg = Util.doGetText(ConfirmMsg);
		return msg;
		
	}
}

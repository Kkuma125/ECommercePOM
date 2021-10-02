package com.mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mysrtore.base.BaseClass;
import com.mystore.utility.GetElement;


public class AccountCreationPage extends BaseClass {

	GetElement Util;
	By VerifyAccountTitle = By.xpath("//h1[text()='Create an account']");
	
	public AccountCreationPage(WebDriver driver) {
		this.driver = driver;
		Util = new GetElement(this.driver);
		
	}
	
	public boolean verifyAccountCreatePage() {
		return Util.doIsDisplayed(VerifyAccountTitle);
	}
	
}

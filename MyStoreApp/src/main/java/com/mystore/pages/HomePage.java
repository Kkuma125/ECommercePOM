package com.mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mysrtore.base.BaseClass;
import com.mystore.utility.GetElement;


public class HomePage extends BaseClass {
	GetElement Util;

	By Mywishlist = By.xpath("//span[text()='My wishlists']");
	By OrderHistory = By.xpath("//span[text()='Order history and details']");



	public HomePage(WebDriver driver) {
		this.driver = driver;
		Util = new GetElement(this.driver);
	}

	public boolean validateMywishlist() {
		return Util.doIsDisplayed(Mywishlist);
	}
	public boolean validateOrderHistory() {
		return Util.doIsDisplayed(OrderHistory);
	}
	
	public String getCurrentUrl() {
		String HomePageUrl = driver.getCurrentUrl();
		System.out.println("Navigate To HomePage Current URL.....");
		return HomePageUrl;
	}
	
}

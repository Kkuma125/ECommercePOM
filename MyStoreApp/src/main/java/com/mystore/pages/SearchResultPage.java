package com.mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mysrtore.base.BaseClass;
import com.mystore.utility.GetElement;


public class SearchResultPage extends BaseClass {
	GetElement Util;
	
	By ProductResult = By.xpath("//a[@class='product_img_link']");
	
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		Util = new GetElement(this.driver);
		
	}
	
	public boolean isProductAvailable() {
		return Util.doIsDisplayed(ProductResult);
	}
	
	public AddToCartPage clickOnProduct() {
		Util.doClick(ProductResult);
		return new AddToCartPage(driver);
	}
}
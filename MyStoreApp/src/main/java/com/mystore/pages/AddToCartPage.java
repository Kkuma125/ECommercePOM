package com.mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.mysrtore.base.BaseClass;
import com.mystore.utility.GetElement;


public class AddToCartPage extends BaseClass {

	GetElement Util;

	By Quantity = By.id("quantity_wanted");
	By Size = By.id("group_1");
	By Color = By.id("color_14");
	By ClickAddToCart = By.xpath("//span[text()='Add to cart']");
	By verifyAddtoCartMsg = By.xpath("//i [@class='icon-ok']//..");
	By ProceedtoCheckout = By.xpath("//span[contains(text(),'Proceed to checkout')]");

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		Util = new GetElement(this.driver);
		
	}
	
	public void enterQty(String qty) {
		Util.doSendKeys(Quantity, qty);
		
	}
	public void selectSize(String size) {
		Util.doDropDownSelectByVisibleText(Size, size);
	}
	public void clickColor() {
		Util.doClick(Color);
		JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		Js1.executeScript("window.scrollBy(0,400)"); 
		
	}
	
	public void clickAddToCartbtn() {
		Util.doClick(ClickAddToCart);
		Util.waitForElementToBeVisible(verifyAddtoCartMsg, 10);
	}
	
	public boolean validateAddToCart() {
		return Util.doIsDisplayed(verifyAddtoCartMsg);
	}
	
	public OrderPage clickOnCheckout() {
		Util.doActionsClick(ProceedtoCheckout);
		return new OrderPage(driver);
		
	}
	
	
	
	
}
package com.mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mysrtore.base.BaseClass;
import com.mystore.utility.GetElement;


public class OrderPage extends BaseClass {

	GetElement Util;
	By UnitPrice = By.xpath("//td[@class='cart_unit']//span/span");
	By TotalPrice = By.xpath("//span[@id='total_price']");
	By ProceedtoCheck = By.xpath("//span[text()='Proceed to checkout']");

	public OrderPage(WebDriver driver) {
		this.driver = driver;
		Util = new GetElement(this.driver);

	}

	public double getUnitPrice() {
		String Unit = Util.doGetText(UnitPrice);
		String unit = Unit.replaceAll("[^a-zA-Z0-9]","");
		double finalUnit = Double.parseDouble(unit);
		return finalUnit/100;

	}
	public double TotalPrice() {
		String Total = Util.doGetText(UnitPrice);
		String unit1 = Total.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalprice = Double.parseDouble(unit1);
		return finalTotalprice/100;

	}
	
	public LoginPage clickOncheckout() {
		Util.doClick(ProceedtoCheck);
		return new LoginPage(driver);
	}
	
	
}

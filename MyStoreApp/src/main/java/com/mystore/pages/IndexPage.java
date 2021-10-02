package com.mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mysrtore.base.BaseClass;
import com.mystore.utility.GetElement;


public class IndexPage extends BaseClass {
	GetElement Util;

	


	By SigninBtn = By.xpath("//a[@class='login']");
	By Logo = By.xpath("//img[@class='logo img-responsive']");
	By SearchBox = By.xpath("//input[@id='search_query_top']");
	By SearchBtn = By.xpath("//button[@name='submit_search']");

	public IndexPage(WebDriver driver) {
		this.driver = driver;
		Util = new GetElement(this.driver);
		
	}
	public LoginPage clickOnSignIn() {
		Util.doClick(SigninBtn);
		return new LoginPage(driver);
	}

	public boolean validateLogo() {	
		return Util.doIsDisplayed(Logo);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}

	public SearchResultPage searchProduct(String ProductName) {
		Util.doSendKeys(SearchBox, ProductName);
		Util.doClick(SearchBtn);
		return new SearchResultPage(driver);
	}
}



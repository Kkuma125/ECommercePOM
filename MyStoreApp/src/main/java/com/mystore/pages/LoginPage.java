package com.mystore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mysrtore.base.BaseClass;
import com.mystore.utility.GetElement;

public class LoginPage extends BaseClass {
	GetElement Util;
 

	By username = By.id("email");
	By password = By.id("passwd");
	By SignInBtn = By.id("SubmitLogin");
	By CreateNewAcct = By.id("email_create");
	By ClickOnNewAcct = By.xpath("//button[@id='SubmitCreate']");



	public LoginPage(WebDriver driver) {
		this.driver = driver;
		Util = new GetElement(this.driver);
	}

	public HomePage login(String uname, String pwd) {
		Util.doSendKeys(username, uname);
		Util.doSendKeys(password, pwd);
		Util.doClick(SignInBtn);
		return new HomePage(driver);	
	}
	public AddressPage login1(String uname, String pwd) {
		Util.doSendKeys(username, uname);
		Util.doSendKeys(password, pwd);
		Util.doClick(SignInBtn);
		return new AddressPage(driver);	
	}


	public AccountCreationPage createNewAccount(String newaccountName) {
		Util.doSendKeys(CreateNewAcct, newaccountName);
		Util.doClick(ClickOnNewAcct);
		return new AccountCreationPage(driver);
	}

}

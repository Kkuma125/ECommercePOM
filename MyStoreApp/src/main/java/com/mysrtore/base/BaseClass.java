/**
 * 
 */
package com.mysrtore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;


import com.mystore.utility.GetElement;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author kumar
 *
 */
public class BaseClass {

	public static Properties prop;
	public static  WebDriver driver;
	public  GetElement Util;
	
	
	

	@BeforeTest
	public void LoadConfig() {
		try {
			prop = new Properties();
			System.out.println("Loading Config Proerties File");
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void LaunchApp() {

		WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");

		if(browserName.equals("Chrome")) {
			driver = new ChromeDriver();	
		} else if(browserName.equals("Firefox")) {
			driver = new FirefoxDriver();

		} else {
			System.out.println("Please Pass the Correct Browser : " + browserName) ;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
		}

	} 


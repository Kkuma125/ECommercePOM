package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This method is used to initialize the webdriver on the basis of given browser name..
 * @author kumar
 *
 */

public class DriverFactory {
	
	private static final Logger LOGGER = Logger.getLogger(String.valueOf(DriverFactory.class));

	WebDriver driver;
	Properties prop;
	public static String highlight;
	OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();


	public WebDriver init_Driver(String browserName, String browserVersion) {
//		String browserName = prop.getProperty("browser");
		System.out.println("browser Name is: " + browserName);
		LOGGER.info("browser name is: " + browserName);
		highlight = prop.getProperty("highlight").trim();
		OptionsManager optionsManager = new OptionsManager(prop);

		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));

		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver(optionsManager.getFireFoxOptions())); 

		}
		else {
			System.out.println("Please Pass the  Correct BrowswerName :" + browserName );
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();

		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();

	}



	/**
	 * This method is used to initialize the properties from config file.
	 * @return returns Properties prop
	 */
	public Properties init_prop() {

		FileInputStream ip = null;
		prop = new Properties();
		String env = System.getProperty("env");
		LOGGER.info("Running on Environment -->: " + env);
		System.out.println("Running on Environment -->: " + env);

		if (env == null) {
			try {
				ip = new FileInputStream("./src/test/resources/config/config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {

			try {
				switch (env) {
				case "qa":
					ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
					break;
				case "stage":
					ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
					break;
				case "dev":
					ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
					break;
				case "prod":
					ip = new FileInputStream("./src/test/resources/config/config.properties");
					break;

				default:
					break;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				LOGGER.error("File Not found at the given location....");

			}
		}

		try {
			prop.load(ip);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	/**
	 * take sceenshot 
	 * Ashot
	 */
	public String getScreenshot() {
		String src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
		File srcFile = new File(src);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			LOGGER.error("some exception is coming while creating the screenshot");
			e.printStackTrace();
		}
		return path;
	}

	
}




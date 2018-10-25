package com.proofhub.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.proofhub.util.TestUtil;

public class Base {

	public static WebDriver driver;
	public static Properties prop;

	// constructor to read data from properties file
	public Base() {
		try {
			prop = new Properties();
			FileInputStream finput = new FileInputStream(
					"D:\\training\\ProofHub\\src\\main\\java\\" + "com\\proofhub\\config\\com.properties");
			prop.load(finput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	// method to initialize browser
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		// String url = prop.getProperty("url");
		// driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOADTIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		//TestUtil.webDriverWait();

	
	}

}

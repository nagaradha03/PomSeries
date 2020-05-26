package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	 WebDriver driver;
	 Properties prop;
	 
	 // this method is used to initialize the WebDriver on the basis of browser
	 //@param browser @return driver
	 
	public WebDriver init_driver(Properties prop) {
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\kishorelr\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\kishorelr\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("safari")) {
			//WebDriverManager.getInstance(SafariDriver.class).setup();
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\kishorelr\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
			driver=new SafariDriver();
		}
       driver.manage().deleteAllCookies();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       driver.get(prop.getProperty("url"));
		return driver;
	}
	
   //this method is used to initialize the properties form the config properties
	
	//@return prop
	
	public Properties init_prop() {
		prop=new Properties();
		try {
			FileInputStream fs=new FileInputStream(".\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
			prop.load(fs);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

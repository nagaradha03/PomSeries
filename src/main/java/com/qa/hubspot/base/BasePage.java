package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.hubspot.utils.ElementUtil;
import com.qa.hubspot.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;
	public OptionsManager optionsManager;
	public ElementUtil elementUtil;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();

	}

	// this method is used to initialize the WebDriver on the basis of browser
	// @param browser @return driver

	public WebDriver init_driver(Properties prop) {
		optionsManager=new OptionsManager(prop);
//if(System.getProperty("browser")) {
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			// WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\kishorelr\\Downloads\\chromedriver_win32_latest\\chromedriver.exe");
			// driver=new ChromeDriver();
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		} else if (browserName.equalsIgnoreCase("firefox")) {
			// WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\kishorelr\\Downloads\\chromedriver_win32_latest\\chromedriver.exe");
			// driver=new FirefoxDriver();
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		} else if (browserName.equalsIgnoreCase("safari")) {
			// WebDriverManager.getInstance(SafariDriver.class).setup();
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\kishorelr\\Downloads\\chromedriver_win32_latest\\chromedriver.exe");
			// driver=new SafariDriver();
			tlDriver.set(new SafariDriver());
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}

	// this method is used to initialize the properties form the config properties file on the basis of given 
	// env variables
	

	// @return prop

	public Properties init_prop() {
		prop=new Properties();
		String path=null;
		String env=null;
		
			try {
				
			env=System.getProperty("env");
			if(env==null) {
				path=".\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties";
			}
			else {
				switch(env) {
				
				case "qa":
					path=".\\src\\main\\java\\com\\qa\\hubspot\\config\\qa.config.properties";
					break;
				case "dev":
					path=".\\src\\main\\java\\com\\qa\\hubspot\\config\\dev.config.properties";
					break;
				case "stage":
					path=".\\src\\main\\java\\com\\qa\\hubspot\\config\\stage.config.properties";
					break;
				default:
						System.out.println("Please pass the correct path" +env);
						break;
					}
				}
			
				
			FileInputStream fs=new FileInputStream(path);
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

	// This method is used to take a screen shot

	public String getScreenshot() {

		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;

	}

}

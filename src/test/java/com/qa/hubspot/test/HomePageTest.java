package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	Properties prop;
	
	
//	basePage=new BasePage();
//	prop=basePage.init_prop();
//	driver=basePage.init_driver(prop);
//	loginPage=new LoginPage(driver);
	@BeforeTest
	public void setup() {
		basePage=new BasePage();
		prop=basePage.init_prop();
		driver=basePage.init_driver(prop);
		loginPage=new LoginPage(driver);
		homePage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		}
	
	@Test(priority=3)
	public void verifyHomePageTitle() {
		String title=homePage.getHomePageText();
		System.out.println("The title of the home page is : "+ title);
		Assert.assertEquals(title,Constants.HOME_PAGE_TITLE,"title is not found");
		
	}
	@Test(priority=2)
	public void verifyGetLoggedInUserTest() {
		boolean value=homePage.getLoggedInUser();
		
		Assert.assertTrue(value,"account name is not desplayed");
		
		
		
	}
	@Test(priority=1)
	public void verifyHomePageHeaderTest() {
		String title=homePage.getHomePageHeaderText();
		System.out.println("The title of the header is:"+title);
		Assert.assertEquals(title,Constants.HOME_PAGE_HEADER,"header is not found");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	

}

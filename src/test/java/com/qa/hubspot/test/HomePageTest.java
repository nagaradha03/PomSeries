package com.qa.hubspot.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest extends BaseTest {
	HomePage homePage;
	
	@BeforeClass
	public void homeSetUP() {
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
		
		Assert.assertTrue(value,"account name is not displayed");
		
		
		
}
	@Test(priority=1)
	public void verifyHomePageHeaderTest() {
		String title=homePage.getHomePageHeaderText();
		System.out.println("The title of the header is:"+title);
		Assert.assertEquals(title,Constants.HOME_PAGE_HEADER,"header is not found");
	}
	
	
	
	
	

}

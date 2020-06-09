package com.qa.hubspot.test;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.listeners.ExtentReportListener;
import com.qa.hubspot.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

//@Listeners(ExtentReportListener.class)
@Epic("Epic-101 :design login page with different features...")
@Story("US-102:design basic page login with signup,title and login form")
public class LoginPageTest extends BaseTest{
	
	
	@Test(priority=1)
	@Description("Verify sign up link test")
	@Severity(SeverityLevel.NORMAL)
	public void verifySignUpLinkTest() {
		
		Assert.assertTrue(loginPage.verifySignUpLink(),"sign up link is not displayed");
		
		
	}
	@Test(priority=2)
	@Description("Verify login page title......")
	
	public void verifyLoginPageTitle() {
		String title=loginPage.getLoginPageTitle();
		System.out.println("The title of the page is:" + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE,"The title of the page is not found");
		
	}
	
	@Test(priority=3)
	@Severity(SeverityLevel.BLOCKER)
	public void verifydoLoginTest() {
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	
	

}

package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {

	
		private WebDriver driver;
		
		
		//By locators....Object Repository OR
		By username=By.id("username");
		By password=By.id("password");
		By loginButton=By.id("loginBtn");
		By signUp=By.linkText("Sign up");
		
		
		//Creating constructor 
		
		public LoginPage(WebDriver driver) {
			 this.driver=driver;
			 elementUtil=new ElementUtil(this.driver);
		}
		
		//page actions
		
		@Step("get login page title")
		public String getLoginPageTitle() {
			//return driver.getTitle();
			return elementUtil.waitForTitleToBePresent(Constants.LOGIN_PAGE_TITLE, 10);
			
			
		}
		@Step("check sign up link on login page")
		public boolean verifySignUpLink() {
			//return driver.findElement(signUp).isDisplayed();
			return elementUtil.doIsDisplayed(signUp);
		}
		@Step("login to app with username:{0} and password:{1}")
		public HomePage doLogin(String username,String password) {
           elementUtil.waitForElementToBeVisible(this.username, 10);
			elementUtil.DoSendKeys(this.username, username);
			elementUtil.DoSendKeys(this.password, password);
			elementUtil.doClick(this.loginButton);
			
			return new HomePage(this.driver);
			
			
		}
	}

	


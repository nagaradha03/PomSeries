package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

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
		}
		
		//page actions
		
		public String getLoginPageTitle() {
			return driver.getTitle();
			
			
		}
		public boolean verifySignUpLink() {
			return driver.findElement(signUp).isDisplayed();
		}
		
		public HomePage doLogin(String username,String password) {
			driver.findElement(this.username).sendKeys(username);
			driver.findElement(this.password
					).sendKeys(password);
			driver.findElement(this.loginButton).click();
			return new HomePage(driver);
			
			
			
		}
	}

	


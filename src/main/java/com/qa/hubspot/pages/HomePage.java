package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {

		private WebDriver driver;
		
		By header=By.cssSelector("h1.private-header__heading.private-header__heading--solo");
		
		By accountName=By.xpath("//a[@id='account-menu']");
		
		
		public HomePage(WebDriver driver) {
			this.driver=driver;
			
		}
		public String getHomePageText() {
			return driver.getTitle();
		}
		
		public String getHomePageHeaderText() {
			if(driver.findElement(header).isDisplayed()) {
				return driver.findElement(header).getText();
			}
			return null;
		}

		public boolean getLoggedInUser() {
			
			boolean b=driver.findElement(accountName).isDisplayed();
				return b;
		}
		
		
	}


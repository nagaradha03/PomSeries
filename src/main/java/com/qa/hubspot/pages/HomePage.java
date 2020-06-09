package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {

		private WebDriver driver;
		
		By header=By.cssSelector("h1.private-header__heading.private-header__heading--solo");
		By accountName=By.xpath("//a[@id='account-menu']");
		By contactsPrimary=By.id("nav-primary-contacts-branch");
		By contactsSecondary=By.id("nav-secondary-contacts");
		
		
		
		public HomePage(WebDriver driver) {
			this.driver=driver;
			elementUtil=new ElementUtil(this.driver);
			
		}
		public String getHomePageText() {
			
			return elementUtil.waitForTitleToBePresent(Constants.HOME_PAGE_TITLE, 20);
		}
		
		public String getHomePageHeaderText() {
			if(driver.findElement(header).isDisplayed()) {
				return elementUtil.doGetText(header);
			}
			return null;
		}

		public boolean getLoggedInUser() {
			
//			boolean b=driver.findElement(accountName).isDisplayed();
//				return b;
			 return elementUtil.doIsDisplayed(accountName);
			
			
		}
		public ContactsPage goToContactsPage() {
			clickOnContacts();
			return new ContactsPage(this.driver);
		}
		private void clickOnContacts() {
			elementUtil.waitForElementToBeVisible(contactsPrimary,20);
			elementUtil.doClick(contactsPrimary);
			elementUtil.waitForElementToBeVisible(contactsSecondary,20);
			elementUtil.doClick(contactsSecondary);
			
			
			
			
		}
		

}

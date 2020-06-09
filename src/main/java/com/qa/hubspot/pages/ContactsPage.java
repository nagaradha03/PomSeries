package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class ContactsPage extends BasePage{

	 private WebDriver driver;
	 
		By header=By.xpath("//i18n-string[@data-key='genericTypes.capitalized.CONTACT']");
		By createContactPrimary=By.xpath("//span[text()='Create contact']");
		By email=By.xpath("//input[@data-field='email']");
		By firstName=By.xpath("//input[@data-field='firstname']");
		By lastName=By.xpath("//input[@data-field='lastname']");
		By jobTitle=By.xpath("//input[@data-field='jobtitle']");
		By createContactSecondary=By.xpath("(//button[@data-loading='false'])[position()=1]");
		By createContactsBack=By.xpath("(//i18n-string[text()='Contacts'])[position()=1]");
		public ContactsPage(WebDriver driver) {
			this.driver = driver;
			elementUtil=new ElementUtil(this.driver);
		}
		
		public String getContactsPageTitle() {
			return elementUtil.waitForTitleToBePresent(Constants.CONTACTS_PAGE_TITLE, 10);
			
			}
		public String getContactsPageHeader() {
			elementUtil.waitForElementToBeVisible(header, 10);
			return elementUtil.doGetText(header);
		}
		
		public void createContact(String email,String firstName,String lastName,String jobTitle) {
			driver.navigate().refresh();
		   elementUtil.waitForElementToBeVisible(createContactPrimary,30);
			elementUtil.doClick(createContactPrimary);
//			JavascriptExecutor executor1 =((JavascriptExecutor) driver);
//			executor1.executeScript("arguments[0].click();", createContactPrimary); 
			
			elementUtil.waitForElementToBeVisible(this.email,10);
			elementUtil.DoSendKeys(this.email, email);
			elementUtil.DoSendKeys(this.firstName, firstName);
			elementUtil.DoSendKeys(this.lastName, lastName);
			
			elementUtil.waitForElementToBeVisible(this.jobTitle,10);
			elementUtil.DoSendKeys(this.jobTitle, jobTitle);
			//elementUtil.waitForElementPresent(createContactSecondary,20);
			//JavascriptExecutor executor2 = (JavascriptExecutor)driver;
			//executor2.executeScript("arguments[0].click();",createContactSecondary);
			elementUtil.waitForElementToBeVisible(createContactSecondary, 10);
			elementUtil.doClick(createContactSecondary);
			
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			elementUtil.clickWhenReady(createContactsBack, 5);
//			elementUtil.doActionClick(createContactSecondary);
			
			
			
			
			
			
			
			
			
		}
		
		
	}



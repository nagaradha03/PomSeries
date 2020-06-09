package com.qa.hubspot.test;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ExcelUtil;


public class ContactsPageTest extends BaseTest{
	
	HomePage homePage;
	ContactsPage contactPage;
	
	@BeforeClass
	public void contactsSetUp() {
		homePage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		contactPage=homePage.goToContactsPage();
	}
	@Test
	public void verifyContactsPageTitleTest() {
		String title=contactPage.getContactsPageTitle();
		System.out.println("The title of the contact page is:" +title);
		Assert.assertEquals(title,Constants.CONTACTS_PAGE_TITLE,"Title is wrong");
	
		}
	
	@DataProvider
	public Object[][] getContactsTestData() {
		Object data[][] =ExcelUtil.getTestData(Constants.CONTACT_SHEET_NAME);
		return data;
	}
	
	@Test(dataProvider="getContactsTestData")
	public void verifyContactTest(String email,String firstName,String lastName,String jobTitle) {
		contactPage.createContact(email,firstName,lastName,jobTitle);
		
		
		}
	
	
	
   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

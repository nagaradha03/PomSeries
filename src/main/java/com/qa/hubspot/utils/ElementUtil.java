package com.qa.hubspot.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	
		
			WebDriver driver;
			JavaScriptUtils js;
			public  ElementUtil(WebDriver driver) {
				this.driver=driver;
				js=new JavaScriptUtils(this.driver);
				
			}
			public WebElement getElement(By locator) {
				WebElement element=null;
					try {
						System.out.println("locator is :" + locator);
						element=driver.findElement(locator);
						js.flash(element);
						System.out.println("WebElement is created successfully:");
					}
					catch(Exception e) {
						System.out.println("got some exception for this locator"+locator);
					}
				    System.out.println("*******");
				    System.out.println(element);
				    System.out.println("********");
					return element;
				}
			
			public List<WebElement> getElements(By locator) {
				List<WebElement> elementsList = driver.findElements(locator);
				return elementsList;
			}
			
			public void DoSendKeys(By locator,String value) {
				getElement(locator).sendKeys(value);
			}
			public void doClick(By locator) {
				getElement(locator).click();
			}
			public String doGetText(By locator) {
				return getElement(locator).getText();
				
			}
			public boolean doIsDisplayed(By locator) {
				return getElement(locator).isDisplayed();
			}
			
			//****************Select class Drop down utils******************
		    public void doSelectVisibleByText(By locator,String value) {
		    	Select select=new Select(getElement(locator));
		    	select.selectByVisibleText(value);  
		    	}
		    public void doSelectByIndex(By locator,int value) {
		    	Select select=new Select(getElement(locator));
		    	select.selectByIndex(value);
		    }
		    public void doSelectByValue(By locator,String value) {
		    	Select select= new Select(getElement(locator));
		    	select.selectByValue(value);
		    }
		    public  int doDropDownOptionsCount(By locator) {
				return doGetDropDownOptions(locator).size();
			}

				public  ArrayList<String> doGetDropDownOptions(By locator) {
					ArrayList<String> ar=new ArrayList<String>();
					Select select=new Select(getElement(locator));
					List<WebElement> OptionsList=select.getOptions();
					System.out.println(OptionsList.size());
					for(int i=0;i<OptionsList.size();i++) {
						String text=OptionsList.get(i).getText();
						//System.out.println(text);
						ar.add(text);
						
					
				}
					return ar;
			}
				public  void doSelectDropDownValue(By locator,String value) {
			    	Select selectMonth=new Select(getElement(locator));
					List<WebElement> OptionsList=selectMonth.getOptions();
					System.out.println(OptionsList.size());
					for(int i=0;i<OptionsList.size();i++) {
						String text=OptionsList.get(i).getText();
						System.out.println(text);
						if(text.equals("Oct")) {
							OptionsList.get(i).click();
							break;
						}
					}
				}
					public void doSelectDropDownValueWithoutSelect(By locator, String value) {
						List<WebElement> optionsList = getElements(locator);

						for (int i = 0; i < optionsList.size(); i++) {
							String text = optionsList.get(i).getText();
							if (text.equals(value)) {
								optionsList.get(i).click();
								break;
							}
						}
					}

					public void selectChoiceValues(By locator, String... value) {
						// List<WebElement> choiceList =
						// driver.findElements(By.cssSelector("span.comboTreeItemTitle"));
						List<WebElement> choiceList = getElements(locator);

						if (!value[0].equalsIgnoreCase("ALL")) {

							for (int i = 0; i < choiceList.size(); i++) {
								String text = choiceList.get(i).getText();
								System.out.println(text);

								for (int k = 0; k < value.length; k++) {
									if (text.equals(value[k])) {
										choiceList.get(i).click();
										break;
									}
								}

							}
						}
						// select all the values:
						else {
							try {
								for (int all = 0; all < choiceList.size(); all++) {
									choiceList.get(all).click();
								}
							} catch (Exception e) {

							}
						}
					}
					
			    	


				//********************Action class**************
				
				public void doDragAndDrop(By Source,By Target) {
					
					WebElement Source1=getElement( Source);
					WebElement Target1=getElement(Target);
					Actions action=new Actions(driver);
					action.dragAndDrop(Source1, Target1).build().perform();
					
				}
				
				public void doActionSendKeys(By locator,String value) {
					Actions action=new Actions(driver);
					action.sendKeys(getElement(locator),value).build().perform();
				}
				public void doActionClick(By locator) {
					Actions action=new Actions(driver);
					
					action.sendKeys(getElement(locator)).build().perform();
				}
				public void doMoveToSpecificElement(By locator) {
					WebElement element=getElement(locator);
					Actions action=new Actions(driver);
					action.moveToElement(element).build().perform();
				}
				public void doContext(By locator) {
					WebElement element=getElement(locator);
					Actions action=new Actions(driver);
					action.contextClick(element).build().perform();
				}
				
				public void doRightClick(By locator,String value) {
					List<WebElement> RightOptions=getElements(locator);
					System.out.println(RightOptions.size());
					for(int i=0;i<RightOptions.size();i++) {
						String text=RightOptions.get(i).getText();
						System.out.println(text);
						
						if(text.equals(value)) {
							RightOptions.get(i).click();
							break;
						}
						
					}
					
		}
			//	*************************WaitUtils********************
				public List<WebElement> visibilityOfAllWebElements(By locator,int timeout) {
					
					WebDriverWait wait=new WebDriverWait(driver,timeout);
					return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
					
				}
				public  WebElement waitForElementPresent(By locator,int timeout){
					WebDriverWait wait = new WebDriverWait(driver, timeout);
					WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					return element;
					
				}
				public  WebElement waitForElementToBeVisible(By locator,int timeout){
					WebElement element=getElement(locator);
					WebDriverWait wait = new WebDriverWait(driver, timeout);
					 wait.until(ExpectedConditions.visibilityOf(element));
					return element;
					
				}
				public  WebElement waitForElementToBeClickable(By locator,int timeout){
					WebDriverWait wait = new WebDriverWait(driver, timeout);
					WebElement element= wait.until(ExpectedConditions.elementToBeClickable(locator));
					return element;
					
				}
				public Boolean waitForUrl(String url,int timeout){
					WebDriverWait wait = new WebDriverWait(driver, timeout);
					return wait.until(ExpectedConditions.urlContains(url));
					
					
				}
				public Alert waitForAlertToBePresent(int timeout){
					WebDriverWait wait = new WebDriverWait(driver, timeout);
					 Alert alert=wait.until(ExpectedConditions.alertIsPresent());
					 return alert;
					 }
				public  void clickWhenReady(By locator,int timeout){
					WebDriverWait wait = new WebDriverWait(driver, timeout);
					WebElement element= wait.until(ExpectedConditions.elementToBeClickable(locator));
					 element.click();
					
				}
				public String waitForTitleToBePresent(String title,int timeout){
					WebDriverWait wait = new WebDriverWait(driver, timeout);
					 wait.until(ExpectedConditions.titleContains(title));
					 return  driver.getTitle();
					
				}
				
				
				private String getTitle() {
					// TODO Auto-generated method stub
					return null;
				}
				private String getCurrentUrl() {
					// TODO Auto-generated method stub
					return null;
				}
				
	}

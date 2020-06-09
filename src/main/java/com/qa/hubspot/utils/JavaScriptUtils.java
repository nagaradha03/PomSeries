package com.qa.hubspot.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

WebDriver driver;
	
	public JavaScriptUtils (WebDriver driver) {
		this.driver=driver;
	}
	public void flash(WebElement element) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String bgcolor=element.getCssValue("backgroundColor");
		for(int i=0;i<10;i++) {
			changeColor("rgb(0,200,0)",element);
			changeColor(bgcolor,element);
		}
		
	}
	private void changeColor(String color, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor='"+color +"'",element);
		try {
			Thread.sleep(20);
		}
		catch(Exception e) {
		
	}
	}
	public void refreshBrowserByJs() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
		}
   
	public String getTitleByJs() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String title=js.executeScript("return document.title;").toString();
		return title;
		
	}
	
	public String getPageInnerText() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String pageText=js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	public void scrollPagedown() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void scrollPageUp() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}
	
	public void scrollIntoview(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		
	}
	public void drawBorder(WebElement element) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'",element);
		
	}
	
	public void generateAlert(String message) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert('" +message+"')");
		
	}
	public void clickElementByJs(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	
	
	public String getBrowserInfo() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String uAgent=js.executeScript("return navigator.userAgent;").toString();
		return uAgent;
		
	}
	
	
}

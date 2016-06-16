package com.discount.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseUtils {
	
	
	public static void waitForElementVis(int millisecond)
	{
		try 
		{
			Thread.sleep(millisecond);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void clickElement(WebDriver driver, WebElement element) 
	{
		String mouseOverScript = "arguments[0].click();";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(mouseOverScript, element);
	}

}

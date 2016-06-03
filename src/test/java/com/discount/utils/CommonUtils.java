package com.discount.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;




public class CommonUtils
{
	public static void setInputValue(WebElement inputElement, String value)
	{
		inputElement.clear();
		inputElement.sendKeys(value);
		waitForElementVis(200);
	}

	public static boolean setDropdownListValue(List<WebElement> optionElements, String value)
	{
		boolean isFound = false;
		for (WebElement option : optionElements)
		{
			if (option.getText().trim().equals(value))
			{
				isFound = true;
				option.click();
				break;
			}
		}
		waitForElementVis(200);
		return isFound;
	}
	
	public static boolean elementExist(WebElement webElement, By id) 
	{
		try 
		{
			webElement.findElement(id);
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}	
	}
	
	public static boolean elementExist(WebElement webElement) 
	{
		try 
		{
			webElement.isDisplayed();
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}		
	}
	
	/*public static boolean elementExist(WebDriver driver, By id) 
	{
		try 
		{
			PageFactory.initElements(driver, DTFitmentExpandPage.class);
			driver.findElement(id);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	*/
	public static String emailAddressGenerator() 
	{
		StringBuffer sb = generatorStringByCount(8);
		sb.append("@automation.com");
		
		return sb.toString();
	}
	
	public static StringBuffer generatorStringByCount(int charactersCount) 
	{
		StringBuffer sb = new StringBuffer();
		String allChar = "abcdefghijklmnopqrstuvwxyz";
		Random random = new Random();
		for (int i = 0; i < charactersCount; i++) 
		{
			sb.append(allChar.charAt(random.nextInt(allChar.length())));
		}
		return sb;
	}
	
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
	
	public static void perventChromeConfirmNavigationPopupLayer(WebDriver driver)
	{
		if("CHROME".equalsIgnoreCase(System.getProperty(CommonConstants.BROWSER_PROP_KEY)))
		{
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("window.onbeforeunload = null");
		}
	}
	
	public static void clickContinueToThisWebsiteForIEDriver(WebDriver driver)
	{
		if(CommonConstants.BroswerType.IE_BROSWER.equals(System.getProperty(CommonConstants.BROWSER_PROP_KEY)))
		{
			try
			{
				CommonUtils.waitForElementVis(2000);
				//driver.findElement(By.id("overridelink")).click();
				driver.navigate().to("javascript:document.getElementById('overridelink').click()");
			}
			catch (Exception e)
			{
				System.out.println("Error: Can't click the Continue to this website link in ie driver: " + e.getMessage());
			}
		}
	}
	
	public static boolean isIEBroswer()
	{
		return CommonConstants.BroswerType.IE_BROSWER.equals(System.getProperty(CommonConstants.BROWSER_PROP_KEY));
	}
	
	public static boolean isFireFoxBroswer()
	{
		return CommonConstants.BroswerType.FIREFOX_BROSWER.equals(System.getProperty(CommonConstants.BROWSER_PROP_KEY));
	}
	
	public static boolean isChromeBroswer()
	{
		return CommonConstants.BroswerType.CHROME_BROSWER.equals(System.getProperty(CommonConstants.BROWSER_PROP_KEY));
	}
	
	public static boolean isSafariBroswer()
	{
		return CommonConstants.BroswerType.SAFARI_BROSWER.equals(System.getProperty(CommonConstants.BROWSER_PROP_KEY));
	}
	
	public static String readValueForKey(String key) 
	{
		Properties property = new Properties();
		String value = new String("");
		try 
		{
			InputStream inputStream = new BufferedInputStream(new FileInputStream(CommonConstants.CONFIG_FILE));
			property.load(inputStream);
			value = property.getProperty(key);
		}
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}

		return value == null ? "" : value.trim();
	}
	
	public static String extractionPrice(String priceStr)
	{
		Pattern p = Pattern.compile("[0-9\\.]+");
		Matcher m = p.matcher(priceStr);
		String price = "";
		while(m.find())
		{   
			price += m.group();  
		}
		return price;
	}
	
	public static void moveToElement(WebDriver driver, WebElement element) 
	{
		if (!CommonUtils.isSafariBroswer()) 
		{
			Actions action = new Actions(driver);
			action.moveToElement(element,0,200).build().perform();
		}
		else 
		{
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			String locatorType = locator.toString().substring(3);
//			String elem = "var elem = document;";
//			if (locatorType.startsWith("id")) {
//				elem = "var elem = document.getElementById(\""+locatorType.substring(4)+"\");";
//			}
//			else if (locatorType.startsWith("xpath")) {
//				String snippet = "document.getElementByXPath = function(sValue) { var a = this.evaluate(sValue, this, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null); if (a.snapshotLength > 0) { return a.snapshotItem(0); } }; ";
//				js.executeScript(snippet);
//				elem = "var elem = document.getElementByXPath(\""+locatorType.substring(7)+"\");";
//			}
//			else if (locatorType.startsWith("className")) {
//				elem = "var elem = document.getElementsByClassName(\""+locatorType.substring(11)+"\")[0];";
//			}
//			String mouseOverScript = elem + " if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false);" +
//					" elem.dispatchEvent(evObj);} else if(document.createEventObject) { elem.fireEvent('onmouseover');}";
//			js.executeScript(mouseOverScript);
			String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(mouseOverScript, element);
		}
	}
	
	public static boolean extractionPriceFilter(String priceStr, String price)
	{
		if(priceStr.contains("+"))
		{
			String filter = priceStr.substring(priceStr.indexOf("$") + 1, priceStr.indexOf("+"));
			Double range = Double.parseDouble(filter);
			Double value = Double.parseDouble(price);
			return value >= range ? true : false;
		}
		
		else if(priceStr.contains("-"))
		{
			String start = priceStr.substring(priceStr.indexOf("$") + 1, priceStr.indexOf("-"));
			String end = priceStr.substring(priceStr.indexOf("-") + 2, priceStr.indexOf(" "));
			Double startValue = Double.parseDouble(start);
			Double endValue = Double.parseDouble(end);
			Double value = Double.parseDouble(price);
			return (value >= startValue) && (value <= endValue) ? true : false;
		}
		
		else
		{
			return false;
		}
	}
	
	
	public static void clickElement(WebDriver driver, WebElement element) 
	{
		String mouseOverScript = "arguments[0].click();";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(mouseOverScript, element);
	}
	
	public static void clickElementByJs(WebDriver driver,String jsStr) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(jsStr);
    }
	
	public static void clickBackButton(WebDriver driver) 
	{
		driver.navigate().back();
    }
	
}
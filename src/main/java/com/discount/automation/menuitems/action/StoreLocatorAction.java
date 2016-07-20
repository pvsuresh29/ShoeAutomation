package com.discount.automation.menuitems.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.discount.automation.menuitems.pages.MenuItemsDTPage;
import com.discount.automation.menuitems.pages.StoreLocatorPage;

public class StoreLocatorAction {
	WebDriver driver;
	
	public static void enterZipCode(WebDriver driver, String zipcode){
		PageFactory.initElements(driver, StoreLocatorPage.class);
		StoreLocatorPage.zipcode.sendKeys(zipcode);
		}
	
	public static void clickSearchButton(WebDriver driver){
		PageFactory.initElements(driver, StoreLocatorPage.class);
		StoreLocatorPage.searchButton.click();
		}
	
	public static void clickSendToPhone(WebDriver driver){
		PageFactory.initElements(driver, StoreLocatorPage.class);
		StoreLocatorPage.sendToPhone.click();
		}
	
	public static void enterPhoneNumber(WebDriver driver, String phoneNumber){
		PageFactory.initElements(driver, StoreLocatorPage.class);
		StoreLocatorPage.sendToPhoneNumber.sendKeys(phoneNumber);
		}
	
	public static void clickSendButton(WebDriver driver){
		PageFactory.initElements(driver, StoreLocatorPage.class);
		StoreLocatorPage.sendButton.click();
		}
	
	public static void closePopUp(WebDriver driver){
		PageFactory.initElements(driver, StoreLocatorPage.class);
		StoreLocatorPage.closePopUpButton.click();
		}

}

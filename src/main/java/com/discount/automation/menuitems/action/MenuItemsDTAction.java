package com.discount.automation.menuitems.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.discount.automation.menuitems.pages.MenuItemsDTPage;
import com.discount.testUtils.CommonUtils;


public class MenuItemsDTAction {
	
	WebDriver driver;
	public static void clickStoreLocatorMenu(WebDriver driver){
		PageFactory.initElements(driver, MenuItemsDTPage.class);
		MenuItemsDTPage.storeLocator.click();
		}

	public static void clickMyStore(WebDriver driver){
		PageFactory.initElements(driver, MenuItemsDTPage.class);
		CommonUtils.waitForElementVis(2000);
		MenuItemsDTPage.myStoreHeader.click();
		}
	
	public static void clickScheduleAppointmentButton(WebDriver driver){
		PageFactory.initElements(driver, MenuItemsDTPage.class);
		MenuItemsDTPage.scheduleAppointmentButton.click();
		}
}

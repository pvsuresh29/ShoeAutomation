package com.discount.automation.menuitems.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuItemsDTPage {
	
WebDriver driver;
	
	@FindBy(xpath="/html/body/main/header/div[2]/div/div[2]/a[1]")
	public static WebElement shopMenu;
	
	@FindBy(xpath="/html/body/main/header/div[2]/div/div[2]/a[2]")
	public static WebElement serviceMenu;
	
	@FindBy(xpath="/html/body/main/header/div[2]/div/div[2]/a[3]")
	public static WebElement storeLocator;
	
	@FindBy(xpath="//*[@id='js-site-search-input']")
	public static WebElement searchBox;
	
	@FindBy(className="headerMystore")
	public static WebElement myStoreHeader;
	
	@FindBy(className="mystore__service")
	public static WebElement scheduleAppointmentButton;
	
	public MenuItemsDTPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

}

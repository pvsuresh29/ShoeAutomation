package com.discount.automation.menuitems.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreLocatorPage {

	
WebDriver driver;
	
	@FindBy(id="storelocator-query")
	public static WebElement zipcode;
	
	@FindBy(xpath="//*[@id='storeFinderForm']/div[3]/button")
	public static WebElement searchButton;
	
	@FindBy(xpath="//*[@id='storeFinder']/div/div/div/div[2]/dl[2]/dd[6]/div/a")
	public static WebElement sendToPhone;
	
	@FindBy(id="sendToPhoneNumber")
	public static WebElement sendToPhoneNumber;
	
	@FindBy(xpath="//*[@id='sendStoreToPhoneForm']/div/button")
	public static WebElement sendButton;
	
	@FindBy(className="icon-close ")
	public static WebElement closePopUpButton;
	
	
	public StoreLocatorPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}

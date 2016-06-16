package com.discount.automation.menuitems.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuItemsPage {
	
	WebDriver driver;
	
	@FindBy(xpath="/html/body/main/header/div[2]/div/div[2]/a[1]")
	WebElement shopMenu;
	
	@FindBy(xpath="/html/body/main/header/div[2]/div/div[2]/a[2]")
	WebElement serviceMenu;
	
	@FindBy(xpath="/html/body/main/header/div[2]/div/div[2]/a[3]")
	WebElement storeLocator;
	
	@FindBy(xpath="//*[@id='js-site-search-input']")
	WebElement searchBox;
	
	public MenuItemsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickShopLink(){
		shopMenu.click();
	}
	
	public void clickInstallersLink(){
		serviceMenu.click();
	}
	
	public void clickLearnLink(){
		storeLocator.click();
	}
	
	public void search(String query){
		searchBox.sendKeys(query);
	}
}

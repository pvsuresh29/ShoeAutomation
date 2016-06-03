package com.discount.automation.storelocator.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class StoreLocatorPage {

	WebDriver driver;
	
	@FindBy(className="chosen-single")
	WebElement radiusDropDown;
	
	@FindBy(id="storelocator-query")
	WebElement zipcodeTextBox;
	
	@FindBy(css="button.btn-default.block")
	WebElement searchButton;
	
	@FindBy(className="store-locator__storelist")
	WebElement storeList;
	
	public StoreLocatorPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setZipCode(String zip){
		zipcodeTextBox.click();
		zipcodeTextBox.clear();
		zipcodeTextBox.sendKeys(zip);
		System.out.println("Inside Zipcode " );
	}
	
	public void clickSearch(){
		searchButton.click();
	}
}



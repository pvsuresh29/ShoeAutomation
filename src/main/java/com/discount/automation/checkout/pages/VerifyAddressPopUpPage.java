package com.discount.automation.checkout.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyAddressPopUpPage {
	WebDriver driver;
	
	@FindBy(id="use_suggested_address_button")
	public static WebElement continueButton;
	
	public VerifyAddressPopUpPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}

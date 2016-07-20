package com.discount.automation.paypal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaypalConfirmationPage {

	
WebDriver driver;
	
	public PaypalConfirmationPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="confirmButtonTop")
	public static WebElement continueButton;
}

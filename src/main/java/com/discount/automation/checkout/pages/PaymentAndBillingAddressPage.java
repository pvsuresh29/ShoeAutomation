package com.discount.automation.checkout.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentAndBillingAddressPage {
	
	WebDriver driver;
	
	public PaymentAndBillingAddressPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="checkout-payment__firstName")
	public static WebElement firstName;

}

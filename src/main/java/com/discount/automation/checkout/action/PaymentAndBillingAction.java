package com.discount.automation.checkout.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.discount.automation.checkout.pages.PaymentAndBillingAddressPage;

public class PaymentAndBillingAction {
	
	WebDriver driver;
	public static void enterShippingAddress(WebDriver driver){
		PageFactory.initElements(driver, PaymentAndBillingAddressPage.class);
		PaymentAndBillingAddressPage.firstName.sendKeys("Alpha");
		
		
	}

}

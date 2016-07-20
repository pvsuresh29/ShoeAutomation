package com.discount.automation.paypal.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.discount.automation.paypal.pages.PaypalConfirmationPage;
import com.discount.automation.paypal.pages.PaypalLoginPage;

public class PaypalConfirmationAction {
	
	WebDriver driver;
	public static void clickContinueButton(WebDriver driver){
		PageFactory.initElements(driver, PaypalConfirmationPage.class);
		PaypalConfirmationPage.continueButton.click();
		
	}
	

}

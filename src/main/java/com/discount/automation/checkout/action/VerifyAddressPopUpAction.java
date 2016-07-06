package com.discount.automation.checkout.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.discount.automation.checkout.pages.VerifyAddressPopUpPage;

public class VerifyAddressPopUpAction {
	
	WebDriver driver;
	public static void clickContinueButton(WebDriver driver){
		PageFactory.initElements(driver, VerifyAddressPopUpPage.class);
		VerifyAddressPopUpPage.continueButton.click();
		
	}

}

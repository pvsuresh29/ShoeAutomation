package com.discount.automation.homepage.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.discount.automation.homepage.pages.AddToCartPopUpPage;

public class AddToCartPopUpAction {
	
	WebDriver driver;
	public static void clickViewShoppingCart(WebDriver driver){
		PageFactory.initElements(driver, AddToCartPopUpPage.class);
		AddToCartPopUpPage.viewShoppingCartButton.click();
		
	}

}

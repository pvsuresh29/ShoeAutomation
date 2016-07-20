package com.discount.automation.cart.action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.discount.automation.cart.pages.CartPage;


public class CartAction {
	
	WebDriver driver;
	public static void clickCheckOutButton(WebDriver driver){
		PageFactory.initElements(driver, CartPage.class);
		CartPage.checkoutButton.click();
		
	}
	
	public static void clickPaypalCheckOutButton(WebDriver driver){
		PageFactory.initElements(driver, CartPage.class);
		CartPage.paypalCheckoutButton.click();
		
	}

}

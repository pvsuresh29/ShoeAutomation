package com.discount.automation.cart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="checkWithDefault")
	public static WebElement checkoutButton;
	
	@FindBy(className="checkWithPaypal")
	public static WebElement paypalCheckoutButton;

}

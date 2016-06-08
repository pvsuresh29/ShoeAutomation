package com.discount.automation.homepage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPopUpPage {
WebDriver driver;
	
	@FindBy(className="block")
	public static WebElement viewShoppingCartButton;
	
	public AddToCartPopUpPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}

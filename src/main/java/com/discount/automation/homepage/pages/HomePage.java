package com.discount.automation.homepage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(className="fitment-component__select-box")
	public static WebElement fitmentComponent;
	
	@FindBy(className="fitment__vehicle-button")
	public static WebElement shopVehicleButton;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static void clickShopLink(){
		shopVehicleButton.click();
	}
	
}



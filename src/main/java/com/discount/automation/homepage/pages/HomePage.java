package com.discount.automation.homepage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(className="fitment-component__select-box")
	public static WebElement fitmentComponent;
	
	@FindBy(xpath="/html/body/main/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/form/div[6]/button")
	public static WebElement shopVehicleButton;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static void clickShopLink(){
		shopVehicleButton.click();
	}
	
}



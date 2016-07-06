package com.discount.automation.homepage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FitmentResultsPopUpPage {
	
WebDriver driver;
	
	@FindBy(className="fitment-box__alllink")
	public static WebElement allTiresLink;
	
	public FitmentResultsPopUpPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

}

package com.discount.automation.homepage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FitmentResultsPopUpPage {
	
WebDriver driver;
	
	@FindBy(xpath="/html/body/div[2]/div[1]/div/div/div/div/div/div[3]/div[1]/a[2]")
	public static WebElement allTiresLink;
	
	public FitmentResultsPopUpPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

}

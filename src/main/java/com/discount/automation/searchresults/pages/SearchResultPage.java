package com.discount.automation.searchresults.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
WebDriver driver;
	
	@FindBy(className="results-row__cartbutton")
	public static WebElement addtoCart;
	
	public SearchResultPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}

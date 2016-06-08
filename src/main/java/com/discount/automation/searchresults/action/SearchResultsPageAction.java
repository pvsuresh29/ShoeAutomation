package com.discount.automation.searchresults.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.discount.automation.searchresults.pages.SearchResultPage;

public class SearchResultsPageAction {

	WebDriver driver;
	public static void clickAddToCartButton(WebDriver driver){
		PageFactory.initElements(driver, SearchResultPage.class);
		SearchResultPage.addtoCart.click();
		
	}
	
}

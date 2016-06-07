package com.discount.automation.homepage.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.discount.automation.homepage.pages.FitmentResultsPopUpPage;
import com.discount.utils.BaseUtils;

public  class FitmentResultsPopUpAction {
	
	WebDriver driver;
	
	public static void clickAllTiresLink(WebDriver driver){
		PageFactory.initElements(driver, FitmentResultsPopUpPage.class);
		FitmentResultsPopUpPage.allTiresLink.click();
		
	}

}

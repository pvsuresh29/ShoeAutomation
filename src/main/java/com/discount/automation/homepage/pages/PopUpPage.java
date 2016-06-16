package com.discount.automation.homepage.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PopUpPage {
	WebDriver driver;
	
	@FindBy(className="btn-default")
	WebElement chooseStoreButton;
	
	public void clickChooseStoreButton(){
		chooseStoreButton.click();
	}
	
	public PopUpPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

}

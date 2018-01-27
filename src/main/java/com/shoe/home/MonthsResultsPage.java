package com.shoe.home;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonthsResultsPage {
WebDriver driver;
	
	@FindBy(xpath="//*[@id='header_nav'/nav/ul/li[")
	public static WebElement monthsList;
	
	@FindBy(id="remind_email_input")
	public static WebElement shopVehicleButton;
	
	@FindBy(xpath="html/body/div[2]/h2")
	public static WebElement brandTitle;
		
	public MonthsResultsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		
	public WebElement getMonths() {
		return monthsList;
	}
}


package com.shoe.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(id="brand")
	public static WebElement brandID;
	
	@FindBy(id="remind_email_input")
	public static WebElement emailRemaindID;
	
	@FindBy(id="flash")
	public static WebElement flashID;
	
	@FindBy(id="remind_email_submit")
	public static WebElement emailSubmitID;
	
	@FindBy(id="search_button")
	public static WebElement searchButtonID;
	
	
	@FindBy(xpath="html/body/div[2]/div/h2")
	public static WebElement headerText;
	
	
	@FindBy(xpath="//*[@id='home_link_div']/a")
	public static WebElement homeText;
	
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
}

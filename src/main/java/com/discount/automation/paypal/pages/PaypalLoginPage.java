package com.discount.automation.paypal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaypalLoginPage {
	
WebDriver driver;
	
	public PaypalLoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/div[1]/section/div/div/form/div[1]/div[1]/div[1]/input")
	public static WebElement emailTextField;
	
	@FindBy(xpath="/html/body/div[1]/section/div/div/form/div[1]/div[2]/div[1]/input")
	public static WebElement passwordTextField;
	
	@FindBy(xpath="//*[@id='btnLogin']")
	public static WebElement logInButton;
	
	

}

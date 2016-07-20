package com.discount.automation.paypal.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.discount.automation.paypal.pages.PaypalLoginPage;


public class PayPalLoginAction {
	
	WebDriver driver;
	public static void clickLoginButton(WebDriver driver){
		PageFactory.initElements(driver, PaypalLoginPage.class);
		PaypalLoginPage.logInButton.click();
		
	}
	
	
	public static void enterPaypalCredentials(WebDriver driver, String paypalusername, String paypalpassword){
		PageFactory.initElements(driver, PaypalLoginPage.class);
		PaypalLoginPage.emailTextField.sendKeys(paypalusername);
		PaypalLoginPage.passwordTextField.sendKeys(paypalpassword);
		
	}
}

package com.discount.automation.checkout.action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import com.discount.automation.checkout.pages.PaymentAndBillingAddressPage;
import com.discount.testUtils.CommonUtils;

public class PaymentAndBillingAction {
	
	WebDriver driver;
	public static void enterShippingAddress(WebDriver driver,String firstName, String lastName, String addr1, String addr2, String city, String zip, String Phone, String email){
		PageFactory.initElements(driver, PaymentAndBillingAddressPage.class);
		PaymentAndBillingAddressPage.firstName.sendKeys(firstName);
		PaymentAndBillingAddressPage.lastName.sendKeys(lastName);
		PaymentAndBillingAddressPage.address1.sendKeys(addr1);
		PaymentAndBillingAddressPage.address2.sendKeys(addr2);
		PaymentAndBillingAddressPage.city.sendKeys(city);
		PaymentAndBillingAddressPage.zip.sendKeys(zip);
		PaymentAndBillingAddressPage.phone.sendKeys(Phone);
		PaymentAndBillingAddressPage.email.sendKeys(email);
		PaymentAndBillingAddressPage.confEmail.sendKeys(email);
		
		
	}
	
	public static void chooseCountryDropdown(int countryOption){
		PaymentAndBillingAddressPage.countryDropDown.click();
		PaymentAndBillingAddressPage.countryDropDown.findElement(By.xpath("//*[@id='country_chosen']/div/ul/li[" +countryOption + "]")).click();
		
	}
	
	public static void chooseStateDropdown(int countryOption){
		PaymentAndBillingAddressPage.stateDropDown.click();
		PaymentAndBillingAddressPage.stateDropDown.findElement(By.xpath("//*[@id='addressProvince_chosen']/div/ul/li[" +countryOption + "]")).click();
		
	}
	
	public static void choosePhoneTypeDropdown(int countryOption){
		PaymentAndBillingAddressPage.phoneTypeDropDown.click();
		PaymentAndBillingAddressPage.phoneTypeDropDown.findElement(By.xpath("//*[@id='phoneTypeId_chosen']/div/ul/li[" +countryOption + "]")).click();
		
	}

	public static void clickDeliveryOptionsButton(WebDriver driver){
		PageFactory.initElements(driver, PaymentAndBillingAddressPage.class);
		PaymentAndBillingAddressPage.deliveryOptionsButton.submit();
		
	}
	
	public static void clickPaymentButton(WebDriver driver){
		PageFactory.initElements(driver, PaymentAndBillingAddressPage.class);
		PaymentAndBillingAddressPage.paymentButton.click();
		
	}
	
	public static void enterNameOnCC(WebDriver driver, String firstname){
		PageFactory.initElements(driver, PaymentAndBillingAddressPage.class);
		PaymentAndBillingAddressPage.nameOnCard.sendKeys(firstname);
		
	}
	
	public static void enterCCNumber(WebDriver driver, String creditcard){
		PageFactory.initElements(driver, PaymentAndBillingAddressPage.class);
		PaymentAndBillingAddressPage.cardNumber.sendKeys(creditcard);
		
	}
	
	public static void chooseMonthExpDropdown(int month){
		PaymentAndBillingAddressPage.ccMonthExpiry.click();
		PaymentAndBillingAddressPage.ccMonthExpiry.findElement(By.xpath("//*[@id='month_chosen']/div/ul/li[" +month + "]")).click();
		
	}
	
	public static void chooseYearExpDropdown(int year){
		PaymentAndBillingAddressPage.ccYearExpiry.click();
		PaymentAndBillingAddressPage.ccYearExpiry.findElement(By.xpath("//*[@id='year_chosen']/div/ul/li[" +year + "]")).click();
		
	}
	
	public static void enterCvn(WebDriver driver, String cvn){
		PageFactory.initElements(driver, PaymentAndBillingAddressPage.class);
		PaymentAndBillingAddressPage.cardCvn.sendKeys(cvn);
		}

	public static void clickReviewButton(WebDriver driver){
		PageFactory.initElements(driver, PaymentAndBillingAddressPage.class);
		PaymentAndBillingAddressPage.paymentSubmitButton.click();
		
	}
	
	public static void clickPlaceOrderButton(WebDriver driver){
		PageFactory.initElements(driver, PaymentAndBillingAddressPage.class);
		PaymentAndBillingAddressPage.placeOrderButton.click();
		
	}
}

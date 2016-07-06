package com.discount.automation.checkout.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentAndBillingAddressPage {
	
	WebDriver driver;
	
	public PaymentAndBillingAddressPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="checkout-payment__firstName")
	public static WebElement firstName;
	
	@FindBy(className="checkout-payment__lastName")
	public static WebElement lastName;

	@FindBy(className="checkout-payment__address1")
	public static WebElement address1;
	
	@FindBy(className="checkout-payment__address2")
	public static WebElement address2;
	
	@FindBy(className="checkout-payment__city")
	public static WebElement city;
	
	@FindBy(className="checkout-payment__zip")
	public static WebElement zip;
	
	@FindBy(className="checkout-payment__phone")
	public static WebElement phone;
	
	@FindBy(className="checkout-payment__email")
	public static WebElement email;
	
	@FindBy(name="confirmEmail")
	public static WebElement confEmail;
	
	@FindBy(xpath="//*[@id='country_chosen']")
	public static WebElement countryDropDown;
	
	@FindBy(xpath="//*[@id='addressProvince_chosen']")
	public static WebElement stateDropDown;
	
	@FindBy(xpath="//*[@id='phoneTypeId_chosen']")
	public static WebElement phoneTypeDropDown;
	
	@FindBy(id="addressForm")
	public static WebElement deliveryOptionsButton;
	
	@FindBy(id="deliveryMethodSubmit")
	public static WebElement paymentButton;
	
	@FindBy(id="nameOnCard")
	public static WebElement nameOnCard;
	
	@FindBy(id="cardNumber")
	public static WebElement cardNumber;
	
	@FindBy(xpath="//*[@id='month_chosen']")
	public static WebElement ccMonthExpiry;
	
	@FindBy(xpath="//*[@id='year_chosen']")
	public static WebElement ccYearExpiry;
	
	@FindBy(id="cardCvn")
	public static WebElement cardCvn;
	
	@FindBy(id="paymentSubmit")
	public static WebElement paymentSubmitButton;
	
	@FindBy(id="placeOrder")
	public static WebElement placeOrderButton;
	
}


package com.discount.automation.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import com.discount.automation.cart.action.CartAction;
import com.discount.automation.checkout.action.PaymentAndBillingAction;
import com.discount.automation.checkout.action.VerifyAddressPopUpAction;
import com.discount.automation.homepage.action.AddToCartPopUpAction;
import com.discount.automation.homepage.action.FitmentResultsPopUpAction;
import com.discount.automation.homepage.action.HomePageAction;
import com.discount.automation.homepage.pages.HomePage;
import com.discount.automation.paypal.action.PayPalLoginAction;
import com.discount.automation.paypal.action.PaypalConfirmationAction;
import com.discount.automation.paypal.pages.PaypalConfirmationPage;
import com.discount.automation.searchresults.action.SearchResultsPageAction;
import com.discount.testUtils.Hooks;

public class CheckoutSteps {
	
	public WebDriver driver;
	
	 public CheckoutSteps()
	    {
		 driver = Hooks.getDriver();
	    }
	
	 @Given("^I open DThomepage$")
	public void i_open_DThomepage() throws Throwable {
		 //Done by Hooks class
	}
	 @Then("^I select \"(.*?)\" from \"(.*?)\" which is dropdown \"(.*?)\"$")
	 public void selectDropDown(String dropDown, String dropDownName, String dropDownOrder) throws Throwable {
		 int dropDownOrderInt = Integer.parseInt(dropDownOrder);
		 HomePageAction.clickVehicleDropDownListAndSelectFitment(driver, dropDownName, dropDown, dropDownOrderInt);
	 }
	 
	 @And("^I click the Shop for my vehicle Button$")
	 public void clickShopVehicleButton() throws Throwable {
		 HomePage.clickShopLink();
	 }
	 
	 @And("^I get a popup for fitment page and I click on the All Tires link$")
	 public void clickAllTiresLink() throws Throwable {
		 FitmentResultsPopUpAction.clickAllTiresLink(driver);
	 }
	 
	 @When("^I click on Add to cart button on Search Results Page$")
	 public void clickAddToCart() throws Throwable {
		 SearchResultsPageAction.clickAddToCartButton(driver);
	 }
	 
	 @When("^I click on View Shopping Cart button on the Add to cart popup$")
	 public void clickViewShoppingCart() throws Throwable {
		 AddToCartPopUpAction.clickViewShoppingCart(driver);
	 }
	 
	 @And("^I click the checkout Button$")
	 public void clickCheckOutButton() throws Throwable {
		 CartAction.clickCheckOutButton(driver);
	 }
	 
	 @And("^I enter \"([^\"]*)\"  \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	 public void enterShippingData(String firstName, String lastName, String addr1, String addr2, String city, String zip, String Phone, String email) throws Throwable {
		 PaymentAndBillingAction.enterShippingAddress(driver, firstName,  lastName,  addr1,  addr2,  city,  zip,  Phone,  email);	 
	 }
	 
	 @And("^I choose \"([^\"]*)\" from country dropdown$")
	    public void chooseCountryDropdown(String countryOption) throws Throwable {
	       PaymentAndBillingAction.chooseCountryDropdown(Integer.parseInt(countryOption)); 
	    }
	 
	 @And("^I choose \"([^\"]*)\" from state dropdown$")
	    public void chooseStateDropdown(String stateOption) throws Throwable {
		 	PaymentAndBillingAction.chooseStateDropdown(Integer.parseInt(stateOption)); 
	    }

	 @And("^I choose \"([^\"]*)\" from Phone dropdown$")
	    public void choosePhoneTypeDropdown(String phonetypeOption) throws Throwable {
		 	PaymentAndBillingAction.choosePhoneTypeDropdown(Integer.parseInt(phonetypeOption)); 
	    }

	 @And("^I click on Next Steps Delivery options button$")
	    public void clickdeliveryOptions() throws Throwable {
		 	PaymentAndBillingAction.clickDeliveryOptionsButton(driver);  
	    }
	 
	 @And("^I click on continue on the verify your address popup$")
	    public void clickContinueButton() throws Throwable {
		 VerifyAddressPopUpAction.clickContinueButton(driver);
	    }
	 
	 @And("^I click on Next Step Payment Button$")
	    public void clickPaymentButton() throws Throwable {
		 PaymentAndBillingAction.clickPaymentButton(driver);
	    }

	 @And("^I enter \"([^\"]*)\" on the Card$")
	    public void enterNameOnCreditCard(String firstname) throws Throwable {
		 PaymentAndBillingAction.enterNameOnCC(driver, firstname);
	    }
	    
	 @And("^I enter \"([^\"]*)\" number$")
	    public void enterCreditCardNumber(String creditcard) throws Throwable {
		 PaymentAndBillingAction.enterCCNumber(driver, creditcard);
	    }

	 @And("^I select Credit card Expiration$")
	    public void enterCreditCardExpiration() throws Throwable {
		 PaymentAndBillingAction.chooseMonthExpDropdown(3);
		 PaymentAndBillingAction.chooseYearExpDropdown(3);
	    }
	 
	 @And("^I enter \"([^\"]*)\" for CC$")
	    public void enterCvn(String cvn) throws Throwable {
		 PaymentAndBillingAction.enterCvn(driver, cvn);  
	    }

	 @And("^I click the Next Step Review button$")
	    public void clickReviewButton() throws Throwable {
		 PaymentAndBillingAction.clickReviewButton(driver);
	    }
	 
	 @And("^I click on the Place Order Button$")
	    public void clickPlaceOrderButton() throws Throwable {
		 PaymentAndBillingAction.clickPlaceOrderButton(driver);
	    }
	 
	 @Then("^I click on check out with Paypal Button$")
	    public void clickPaypalCheckoutButton() throws Throwable {
		 CartAction.clickPaypalCheckOutButton(driver);
	    }

	 @And("^I enter \"([^\"]*)\" \"([^\"]*)\" and click LogIn$")
	    public void enterPaypalCredentials(String paypalusername, String paypalpassword) throws Throwable {
		 PayPalLoginAction.enterPaypalCredentials(driver, paypalusername, paypalpassword);
		 PayPalLoginAction.clickLoginButton(driver); 
	    }

	 @And("^I click Continue$")
	    public void clickContinue() throws Throwable {
		 PaypalConfirmationAction.clickContinueButton(driver);
		   
	    }

	 
	 @And("^I clear browser cookies$")
	 public void clearCookies() throws Throwable {
		 driver.manage().deleteAllCookies();
		 //driver.quit();
	 }
}

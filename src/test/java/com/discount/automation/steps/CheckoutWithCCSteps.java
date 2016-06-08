package com.discount.automation.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.discount.automation.homepage.action.AddToCartPopUpAction;
import com.discount.automation.homepage.action.FitmentResultsPopUpAction;
import com.discount.automation.homepage.action.HomePageAction;
import com.discount.automation.homepage.pages.FitmentResultsPopUpPage;
import com.discount.automation.homepage.pages.HomePage;
import com.discount.automation.searchresults.action.SearchResultsPageAction;
import com.discount.utils.Hooks;

public class CheckoutWithCCSteps {
	
	public WebDriver driver;
	
	 public CheckoutWithCCSteps()
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
}

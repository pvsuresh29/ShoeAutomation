package com.discount.automation.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.discount.automation.homepage.action.FitmentResultsPopUpAction;
import com.discount.automation.homepage.action.HomePageAction;
import com.discount.automation.homepage.pages.FitmentResultsPopUpPage;
import com.discount.automation.homepage.pages.HomePage;
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
	 public void i_select_from_which_is_dropdown(String dropDown, String dropDownName, String dropDownOrder) throws Throwable {
		 int dropDownOrderInt = Integer.parseInt(dropDownOrder);
		 HomePageAction.clickVehicleDropDownListAndSelectFitment(driver, dropDownName, dropDown, dropDownOrderInt);
	 }
	 
	 @And("^I click the Shop for my vehicle Button$")
	 public void i_click_the_Shop_for_my_vehicle_Button() throws Throwable {
		 HomePage.clickShopLink();
	 }
	 
	 @When("^I get a popup for fitment page and I click on the All Tires link$")
	 public void i_click_on_the_All_Tires_link() throws Throwable {
		 FitmentResultsPopUpAction.clickAllTiresLink(driver);
	 }
}

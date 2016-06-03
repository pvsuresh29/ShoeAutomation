package com.discount.automation.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import com.discount.automation.homepage.data.HomePageData;
import com.discount.automation.homepage.pages.HomePage;
import com.discount.utils.Driver;
import com.discount.utils.EnvUrl;
import com.discount.utils.Hooks;

public class CheckoutWithCCSteps {
	
	public WebDriver driver;
	
	 public CheckoutWithCCSteps()
	    {
		 driver = Hooks.getDriver();
	    }
	
	 @Given("^I open DThomepage$")
	public void i_open_DThomepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//driver.get(urlToTest);
	   // throw new Exception();
	}
	 @Then("^I select \"(.*?)\" from \"(.*?)\" which is dropdown \"(.*?)\"$")
	 public void i_select_from_which_is_dropdown(String arg1, String arg2, String arg3) throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
		 int arg = Integer.parseInt(arg3);
		 HomePageData.clickVehicleDropDownListAndSelectFitment(driver, arg2, arg1, arg);
	    // throw new Exception();
	 }
	 
	 @Then("^I click the Shop for my vehicle Button$")
	 public void i_click_the_Shop_for_my_vehicle_Button() throws Throwable {
		 HomePage.clickShopLink();
	     // Write code here that turns the phrase above into concrete actions
	     //throw new PendingException();
	 }
	 
}
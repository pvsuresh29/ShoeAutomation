package com.discount.automation.steps;

import org.openqa.selenium.WebDriver;

import com.discount.automation.ScheduleAppointment.action.ScheduleServiceAction;
import com.discount.automation.menuitems.action.MenuItemsDTAction;
import com.discount.automation.menuitems.action.StoreLocatorAction;
import com.discount.testUtils.Hooks;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

public class ScheduleServiceSteps {
	
	public WebDriver driver;
	
	 public ScheduleServiceSteps()
	    {
		 driver = Hooks.getDriverforDT();
	    }
	 
	 	@Then("^I click on Store Locator$")
	    public void clickStoreLocator() throws Throwable {
	 		MenuItemsDTAction.clickStoreLocatorMenu(driver);
	    }

	    @And("^I enter \"([^\"]*)\"$")
	    public void enterZipCode(String zipcode) throws Throwable {
	    	StoreLocatorAction.enterZipCode(driver, zipcode);
	    }
	    
	    @And("^I click on Search Button$")
	    public void clickSearchButton() throws Throwable {
	    	StoreLocatorAction.clickSearchButton(driver);
	    }

	    @And("^I click a store and click on Send to Phone$")
	    public void clickOnSendToPhone() throws Throwable {
	    	StoreLocatorAction.clickSendToPhone(driver);
	    }

	    @And("^I enter a valid \"([^\"]*)\"$")
	    public void enterPhoneNumber(String phoneNumber) throws Throwable {
	    	StoreLocatorAction.enterPhoneNumber(driver, phoneNumber);
	    }
	    
	    @And("^I click on send Button$")
	    public void i_click_on_send_button() throws Throwable {
	    	StoreLocatorAction.clickSendButton(driver);
	    }

	    @And("^I close the popup$")
	    public void closePopUp() throws Throwable {
	    	StoreLocatorAction.closePopUp(driver);
	    } 
	    
	    @And("^I click on My Store Header$")
	    public void ClickMyStoreHeader() throws Throwable {
	    	MenuItemsDTAction.clickMyStore(driver);
	    }

	    @And("^I click on Schedule Appointment on the menu$")
	    public void ClickScheduleAppointmentOnMenu() throws Throwable {
	    	MenuItemsDTAction.clickScheduleAppointmentButton(driver);
	    }

	    @And("^I click on a Service and click Next Steps Store and Time$")
	    public void clickNextSteps() throws Throwable {
	    	ScheduleServiceAction.selectService(driver);
	    	ScheduleServiceAction.clickNextStepForDateAndTime(driver);
	    }

	    @And("^I select a Date and Time and Click on Customer Information$")
	    public void selectDateandTime() throws Throwable {
	    	ScheduleServiceAction.clickSelectDateBox(driver);
	    	ScheduleServiceAction.selectDate(driver);
	    	ScheduleServiceAction.clickSelectTimeBox(driver);
	    	ScheduleServiceAction.selectTime(driver);
	    	ScheduleServiceAction.clickNextStepForCustomerInfo(driver);
	    }

	    @And("^I enter \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	    public void enterCustomerInformation(String firstname, String lastname, String email, String phonenumber) throws Throwable {
	    	ScheduleServiceAction.enterCustomerInfo(driver, firstname, lastname, email, phonenumber);
	    }
	    @And("^I click on Schedule Appointment$")
	    public void clickScheduleAppointment() throws Throwable {
	    	ScheduleServiceAction.clickScheduleAppointmentButton(driver);
	    }

}

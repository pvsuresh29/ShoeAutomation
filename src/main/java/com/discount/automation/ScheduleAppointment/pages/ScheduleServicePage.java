package com.discount.automation.ScheduleAppointment.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScheduleServicePage {
	
WebDriver driver;
	
	@FindBy(id="span-80222")
	public static WebElement serviceSelected;
	
	@FindBy(className="appointment-steps__review-button")
	public static WebElement nextStepForDateandTimeButton;
	
	@FindBy(id = "dateDiv")
	public static WebElement selectAnAppointmentDateField;
	
	@FindBy(id = "choose-date")
	public static WebElement selectDateBox;
	
	@FindBy(id = "choose-time")
	public static WebElement selectTimeBox;
	
	@FindBy(id = "choose-date_table")
	public static WebElement chooseDateTable;
	
	@FindBy(className = "picker__list")
	public static  WebElement timeListEle;
	
	@FindBy(id="appointmentInfoForm")
	public static WebElement nextStepForCustomerInfoButton;
	
	@FindBy(id = "firstName")
	public static WebElement firstNameBox;
	
	@FindBy(id = "lastName")
	public static WebElement lastNameBox;
	
	@FindBy(id = "phone")
	public static WebElement phoneNumberBox;
	
	@FindBy(id = "accountEmailId")
	public static WebElement emailBox;
	
	@FindBy(id = "confirmEmail")
	public static WebElement confirmEmailBox;
	
	@FindBy(id="phoneTypeId_chosen")
	public static WebElement phoneDropDown;
	
	@FindBy(id = "customerInfo")
	public static WebElement customerInformaitonField;
	
}

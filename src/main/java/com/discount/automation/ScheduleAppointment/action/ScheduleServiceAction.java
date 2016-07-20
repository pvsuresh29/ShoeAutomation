package com.discount.automation.ScheduleAppointment.action;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.discount.automation.ScheduleAppointment.pages.ScheduleServicePage;
import com.discount.testUtils.CommonUtils;


public class ScheduleServiceAction {
	
	WebDriver driver;
	public static void selectService(WebDriver driver){
		PageFactory.initElements(driver, ScheduleServicePage.class);
		ScheduleServicePage.serviceSelected.click();
		}

	public static void clickNextStepForDateAndTime(WebDriver driver){
		PageFactory.initElements(driver, ScheduleServicePage.class);
		ScheduleServicePage.nextStepForDateandTimeButton.click();
		}
	
	public static void clickSelectDateBox(WebDriver driver)
	{

		PageFactory.initElements(driver, ScheduleServicePage.class);
		CommonUtils.waitForElementVis(2000);		
		int count = 5;
		while(count > 0)
		{
			try
			{
				CommonUtils.clickElement(driver, ScheduleServicePage.selectDateBox);
				CommonUtils.waitForElementVis(5000);
				CommonUtils.elementExist(ScheduleServicePage.chooseDateTable.findElements(By.className("picker__day--infocus")).get(1));
				break;
			}
			catch(Exception e)
			{
				count--;
			}
		}
		
	}
	
	public static void selectDate(WebDriver driver)
	{
		
		PageFactory.initElements(driver, ScheduleServicePage.class);
		List<WebElement> dayList = ScheduleServicePage.chooseDateTable.findElements(By.className("picker__day--infocus"));
		for(int i = dayList.size() - 1 ;i >= 0 ;i--)
		{
			if (dayList.get(i).getAttribute("class").contains("picker__day--disabled"))
			{
				dayList.remove(i);
			}
		}
		CommonUtils.clickElement(driver, dayList.get(1));
		
	}
	
	public static void clickSelectTimeBox(WebDriver driver)
	{
		
		PageFactory.initElements(driver, ScheduleServicePage.class);
		CommonUtils.waitForElementVis(1000);
		int count = 10;
		while(count > 0)
		{
			try
			{
				CommonUtils.clickElement(driver, ScheduleServicePage.selectTimeBox);
		    	CommonUtils.waitForElementVis(3000);
				CommonUtils.elementExist(ScheduleServicePage.timeListEle.findElements(By.tagName("li")).get(0));
				break;
			}
			catch(Exception e)
			{
				count--;
			}
		}	
	}
	
	public static void selectTime(WebDriver driver)
	{
    	CommonUtils.waitForElementVis(2000);
		PageFactory.initElements(driver, ScheduleServicePage.class);
		List<WebElement> timeList = ScheduleServicePage.timeListEle.findElements(By.tagName("li"));
		for(WebElement timeEle : timeList) 
		{
			if(!timeEle.getAttribute("class").contains("item--disabled"))
			{
				CommonUtils.clickElement(driver, timeEle);
				break;
			}
		}
    	CommonUtils.waitForElementVis(1000);
	}

	public static void clickNextStepForCustomerInfo(WebDriver driver){
		PageFactory.initElements(driver, ScheduleServicePage.class);
		ScheduleServicePage.nextStepForCustomerInfoButton.submit();
		}
	
	public static void enterCustomerInfo(WebDriver driver, String FirstName, String LastName, String Email, String PhoneNumber){
		PageFactory.initElements(driver, ScheduleServicePage.class);
		
		ScheduleServicePage.firstNameBox.sendKeys(FirstName);
		ScheduleServicePage.lastNameBox.sendKeys(LastName);
		ScheduleServicePage.emailBox.sendKeys(Email);
		ScheduleServicePage.confirmEmailBox.sendKeys(Email);
		ScheduleServicePage.phoneNumberBox.sendKeys(PhoneNumber);
		ScheduleServicePage.phoneDropDown.click();
		clickPhoneType(driver);
		}
	
	public static void clickScheduleAppointmentButton(WebDriver driver){
		PageFactory.initElements(driver, ScheduleServicePage.class);
		ScheduleServicePage.customerInformaitonField.submit();
		}
	
	public static void clickPhoneType(WebDriver driver){
		PageFactory.initElements(driver, ScheduleServicePage.class);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement ul = driver.findElement(By.xpath("//ul[contains(@class, 'chosen-results')]"));
		jse.executeScript("arguments[0].scrollIntoView()", ul); 
		List<WebElement> li_ =  ul.findElements(By.tagName("li"));  
		if (li_.size() != 0) 
		{
		for (int i = 0; i <li_.size(); i++)
			{
				if (li_.get(i).getAttribute("data-option-array-index").contains("2"))
				{
						li_.get(i).click();
						break;
				}
			}
		}
	}
	
}

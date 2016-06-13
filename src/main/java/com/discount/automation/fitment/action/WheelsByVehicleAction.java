package com.discount.automation.fitment.action;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import com.discount.automation.fitment.pages.WheelsByVehiclePage;
import com.discount.utils.BaseUtils;


public class WheelsByVehicleAction {
	
	WebDriver driver;
	
	WebElement  el;
	
	public WheelsByVehicleAction(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setYearDropDown(WebDriver driver, String year){
		WheelsByVehiclePage wheels = new WheelsByVehiclePage(driver) ;
	}
	
	
	public static void clickVehicleDropDownListAndSelectFitment(WebDriver driver, String dropDownListName, String dropDownListValue) throws Exception
    {
		PageFactory.initElements(driver, WheelsByVehiclePage.class);
        BaseUtils.waitForElementVis(3000);
        List<WebElement> dropDownLists = WheelsByVehiclePage.fitmentBoxContainer.findElement(By.className("fitment-box__drivebox")).findElements(By.xpath("div"));
        loop: for (WebElement dropDownList: dropDownLists)
        {
        	if (dropDownList.findElement(By.className("Select-placeholder")).getText().equalsIgnoreCase(dropDownListName))
        	{
        		BaseUtils.waitForElementVis(3000);        		
        		dropDownList.findElement(By.className("Select-input")).click();
        		BaseUtils.waitForElementVis(3000);               
                List<WebElement> valueLists = dropDownList.findElement(By.className("Select-menu-outer")).findElements(By.xpath("div/div"));
                for (WebElement valueEle: valueLists)
                {
                	if (valueEle.getText().equalsIgnoreCase(dropDownListValue))
                	{
                		BaseUtils.clickElement(driver, valueEle);
                		//valueEle.click();
                		break loop;
                	}
                }
        	}
        }
    }

}

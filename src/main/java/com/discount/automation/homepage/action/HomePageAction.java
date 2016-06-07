package com.discount.automation.homepage.action;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.discount.automation.fitment.pages.WheelsByVehiclePage;
import com.discount.automation.homepage.pages.HomePage;
import com.discount.utils.BaseUtils;

public class HomePageAction {
	
	WebDriver driver;
	WebElement  el;
	
	public static void clickVehicleDropDownListAndSelectFitment(WebDriver driver, String dropDownListName, String dropDownListValue, int i) throws Exception
    {
		//LOGGER.info("clickVehicleDropDownListAndSelectFitment Method start");
		PageFactory.initElements(driver, HomePage.class);
        BaseUtils.waitForElementVis(3000);
        List<WebElement> dropDownLists = HomePage.fitmentComponent.findElements(By.xpath("/html/body/main/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/form/div[" +i+"]"));
        loop: for (WebElement dropDownList: dropDownLists)
        { 
        	if (dropDownList.findElement(By.className("Select-placeholder")).getText().equalsIgnoreCase(dropDownListName))
        	{
        		BaseUtils.waitForElementVis(3000);        		
        		dropDownList.findElement(By.className("Select-control")).click();
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
    	//LOGGER.info("clickVehicleDropDownListAndSelectFitment Method end");
    }


}

package com.discount.automation.shop.wheels.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ShopWheelsPage {
	WebDriver driver;
	
	@FindBy(xpath="/html/body/main/header/div[3]/div/div[1]/ul/li[2]/a")
	WebElement wheelsMenu;
	
	@FindBy(xpath="//*[@id='tab-wheels']/div/div[1]/a[1]/button")
	WebElement wheelsByVehicle;
	
	@FindBy(xpath="//*[@id='tab-wheels']/div/div[1]/a[2]/button")
	WebElement wheelsBySize;
	
	@FindBy(xpath="//*[@id='tab-wheels']/div/div[1]/a[3]/button")
	WebElement wheelsByBrand;
	
	@FindBy(xpath="//*[@id='tab-wheels']/div/div[1]/a[4]/button")
	WebElement shopWheels;
	
	public ShopWheelsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickWheelsMenu(){
		wheelsMenu.click();
	}
	
	public void clickWheelsByVehicle(){
		wheelsByVehicle.click();
	}
	
	public void clickWheelsBySize(){
		wheelsBySize.click();
	}
	
	public void clickWheelsByBrand(){
		wheelsByBrand.click();
	}
	
	public void clickWheelsSearch(){
		shopWheels.click();
	}
}

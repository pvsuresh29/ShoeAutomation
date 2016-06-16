package com.discount.automation.shop.tires.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ShopTiresPage {
	
	WebDriver driver;
	
	@FindBy(xpath="/html/body/main/header/div[3]/div/div[1]/ul/li[1]/a")
	WebElement tiresMenu;
	
	@FindBy(xpath="//*[@id='tab-tires']/div/div[1]/a[1]/button")
	WebElement tiresByVehicle;
	
	@FindBy(xpath="//*[@id='tab-tires']/div/div[1]/a[2]/button")
	WebElement tiresBySize;
	
	@FindBy(xpath="//*[@id='tab-tires']/div/div[1]/a[3]/button")
	WebElement tiresByBrand;
	
	@FindBy(xpath="//*[@id='tab-tires']/div/div[1]/a[4]/button")
	WebElement tiresSearch;
	
	public ShopTiresPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickTiresMenu(){
		tiresMenu.click();
	}
	
	public void clickTiresByVehicle(){
		tiresByVehicle.click();
	}
	
	public void clickTiresBySize(){
		tiresBySize.click();
	}
	
	public void clickTiresByBrand(){
		tiresByBrand.click();
	}
	
	public void clickTiresSearch(){
		tiresSearch.click();
	}
}



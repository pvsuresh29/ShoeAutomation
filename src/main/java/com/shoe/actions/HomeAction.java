package com.shoe.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shoe.home.HomePage;



public class HomeAction {
	WebDriver driver;
	public static void setEmail(WebDriver driver, String email){
		PageFactory.initElements(driver, HomePage.class);
		HomePage.emailRemaindID.sendKeys(email);
		}

	public static void clickSubmit(WebDriver driver){
		PageFactory.initElements(driver, HomePage.class);
		HomePage.emailSubmitID.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
		}

	public static String  getEmailMessage(WebDriver driver){
		PageFactory.initElements(driver, HomePage.class);
		return HomePage.flashID.getText();
		}

public static String getBrand(WebDriver driver){
	Select oSelect = new Select(driver.findElement(By.id("brand")));
	List <WebElement> elementCount = oSelect.getOptions();
	int iSize = elementCount.size();
	String sValue = null;
	
	//for(int i =0; i<=iSize ; i++){
		sValue = elementCount.get((int)(Math.random()*iSize+1)).getText();
		System.out.println(sValue);
		//}
	return sValue;
}

public static void clickSearch(WebDriver driver){
	PageFactory.initElements(driver, HomePage.class);
	HomePage.searchButtonID.click();
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/h2")));
}

public static String  getHeaderMessage(WebDriver driver){
	PageFactory.initElements(driver, HomePage.class);
	return HomePage.headerText.getText();
	}

public static void selectBrandByValue(WebDriver driver, String value) {
	PageFactory.initElements(driver, HomePage.class);
    Select selectElement = new Select(HomePage.brandID);
    selectElement.selectByValue(value);
}

public static void clickHome(WebDriver driver){
	PageFactory.initElements(driver, HomePage.class);
	HomePage.homeText.click();
}


	
}

package com.shoe.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.shoe.home.MonthsResultsPage;


public class MonthsAction {

	WebDriver driver;
	public static void clickMonthsList(WebDriver driver, String month){
		PageFactory.initElements(driver, MonthsResultsPage.class);
		driver.findElement(By.linkText(month)).click();
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("//*[@id='shoe_list']/li")));

	}
	
	public static String[] getAllMonthsList(WebDriver driver){
		PageFactory.initElements(driver, MonthsResultsPage.class);
		String[] months= new String[15];
	List<WebElement> allElements = driver.findElements(By.xpath("html/body/header/div[1]/nav/ul/li"));
		for (int i=0;i<allElements.size();i++){
			//System.out.println(allElements.get(i).getText());
			months[i]=allElements.get(i).getText();
	      }
		return months;


	}

	public static String getBrandTitle(WebDriver driver){
		PageFactory.initElements(driver, MonthsResultsPage.class);
		return driver.findElement(By.xpath("html/body/div[2]/h2")).getText();
	}

	public static void selectMonths(WebDriver driver, String month){
		PageFactory.initElements(driver, MonthsResultsPage.class);
		//MonthsResultsPage.monthsList.click();
		driver.findElement(By.linkText(month));
		//Assert.assertEquals(MonthsResultsPage.brandTitle.getText(), month+"'s Shoes");
	}
	
	public static void verifyMonthResults(WebDriver driver, String month){
		PageFactory.initElements(driver, MonthsResultsPage.class);
		List <WebElement> le = driver.findElements(By.xpath("//*[@id='shoe_list']/li"));
		boolean temp= true;
		for (int i=0;i<le.size();i++)
		{
			List<WebElement> allRows = le.get(i).findElements(By.tagName("tr"));
			int rowCount= allRows.size();
			int x=0;
				for (WebElement row : allRows) {
					List<WebElement> cells = row.findElements(By.tagName("td"));
					if (x==2){
							String str=cells.get(0).getText();
							String price= cells.get(1).getText();
							if (! str.contains("Price") && price ==null) {
								System.out.println("Failed for "+ month + str+"="+price);  
								  temp = false; break;
								  //System.out.println(str+price);
							}
						}
						if(x==3){
							String str=cells.get(0).getText();
							String desc= cells.get(1).getText();
							if (!str.contains("Description") && desc ==null) {
								 System.out.println("Failed for "+ month + str+"="+desc);  
								temp = false; 
								  break;
								 
							}
						}
						
						if(x==5){
							WebElement str=cells.get(0).findElement(By.tagName("img"));
							if (str.getAttribute("src") == null) {
								System.out.println("Failed for "+ month + "IMG");  
								  temp = false; 
								  break;
								  
							}
						}
				
					x=x+1;
				 }
		    
	}
	}
}

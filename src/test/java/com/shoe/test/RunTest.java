package com.shoe.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.testUtils.Hooks;
import com.shoe.actions.HomeAction;
import com.shoe.actions.MonthsAction;
import com.shoe.home.MonthsResultsPage;



public class RunTest {
	
	
		public  WebDriver driver;
		
		@BeforeClass 
		public  void runBeforeTest()
		    {
			 driver = Hooks.getDriver();
		    }
		 
		 @AfterClass
		 public  void closePage(){
			 driver.quit();
			 
		 }
		
		 /*
		  * This test validates valid email address and invalid email address message(s)
		  * 
		  */
		 @Test
		 public void testEmailStory2() {
	
			String email="1@t.com";
			HomeAction.setEmail(driver, email );
			HomeAction.clickSubmit(driver);
			Assert.assertEquals("Thanks! We will notify you of our new shoes at this email: "+email,HomeAction.getEmailMessage(driver)); 

			HomeAction.setEmail(driver, "abc" );
			HomeAction.clickSubmit(driver);
			Assert.assertEquals("Invalid email format. Ex. name@example.com",HomeAction.getEmailMessage(driver)); 

		 }

		 /*
		  * This test validates Brand selection and Page header, f run the same test with for loop
		  * it selects different BRAND every time(randomly) and verifies the Brand and page header
		  */
		 @Test
		 public void testBrandAndHeaderHome() {
			
			// for (int i=0;i<10;i++){
			HomeAction.clickHome(driver);
			Assert.assertEquals("Welcome to Shoe Store!", HomeAction.getHeaderMessage(driver));
			String brand= HomeAction.getBrand(driver);
			HomeAction.selectBrandByValue(driver, brand);
			HomeAction.clickSearch(driver);
			Assert.assertEquals(brand+"'s Shoes",MonthsAction.getBrandTitle(driver)); 
			// }
			//System.out.println(brand+"'s Shoes");
		 }

		 /*
		  * The below test reads Shoe description,Price and Img SRC data elements
		  * and make sure the fields are not empty, if any data item is empty-it gets Failed
		  * For loop runs for all months
		  */
		 @Test
		 public void testMonthsDataStory1() {
			 String[] month= {null};
			 //HomeAction.clickHome(driver);
			 month= MonthsAction.getAllMonthsList(driver);
			//for (int i=0; i<month.length;i++){
			 MonthsAction.clickMonthsList(driver, month[12]); 
			 Assert.assertEquals(MonthsResultsPage.brandTitle.getText(), month[12]+"'s Shoes");
			 MonthsAction.verifyMonthResults(driver, month[10]);
			//}
		
		 }
		 


}

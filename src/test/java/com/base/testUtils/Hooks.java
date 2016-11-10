package com.base.testUtils;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Hooks {
	
	
	public static Driver initDriver=new Driver();
	private static WebDriver driver= initDriver.driverInit();
	public static String urlToTest="https://rb-shoe-store.herokuapp.com";
	
		 
	 public static WebDriver getDriver()
	    {
		 	
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	driver.get(urlToTest);
	        return driver;
	    }
	 
		 
	 @BeforeClass

	    public void openBrowser() throws MalformedURLException 
	    {

	    	//driver = initDriver.driverInit();
	    	try
	    	{
	    		driver.manage().deleteAllCookies();
	    		driver.manage().window().maximize();
	    		
	    	 	//	driver.manage().window().setSize(new Dimension(400,300));
			}
	    	catch (Exception e) 
	    	{
	    		
			}
	    }
	 
	 @AfterClass
	    public void QuitDriver()
	    {
	        //driver.close();
	    }
	    
	  

}

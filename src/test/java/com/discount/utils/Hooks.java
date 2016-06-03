package com.discount.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.TemporaryFilesystem;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	
	public static Driver initDriver=new Driver();
	private static WebDriver driver= initDriver.driverInit();
	public static EnvUrl envURL= new EnvUrl();
	public static String urlToTest= envURL.getEnvUrl();
	
	 
	 
	 public static WebDriver getDriver()
	    {
		 	
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	driver.get(urlToTest);
	        return driver;
	    }
	 
	 @Before
	    /**
	     * Delete all cookies at the start of each scenario to avoid
	     * shared state between tests
	     */

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
	 
	 @After(order=1)
	    public void QuitDriver()
	    {
	        driver.close();
	    }
	    
	    @After(order=0)
	    public void cleanUpTempFiles()
	    {
	    	if(Boolean.parseBoolean(CommonUtils.readValueForKey("IsRemoting")))
	    	{
	    		TemporaryFilesystem tf = TemporaryFilesystem.getDefaultTmpFS();
	    		tf.deleteTemporaryFiles();
	    	}
	    	else
	    	{
		    	if(CommonUtils.isFireFoxBroswer() || CommonUtils.isIEBroswer())
		    	{
		    		CommonUtils.waitForElementVis(10000);
		    		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "rmdir /S /Q " + System.getenv("temp"));
		   	        builder.redirectErrorStream(true);
		   	        Process process = null;
		   			try
		   			{
		   			    process = builder.start();
		   			    
		   		        Scanner scanner = new Scanner(process.getInputStream());
		   		        StringBuilder result = new StringBuilder();
		   		        while (scanner.hasNextLine())
		   		        {
		   		            result.append(scanner.nextLine());
		   		            result.append(System.getProperty("line.separator"));
		   		        }
		
		   		        scanner.close();
		   		        System.out.println(result.toString());	   			    
		   			} 
		   			catch (IOException e) 
		   			{
		   				e.printStackTrace();
		   			}
		   	        finally
		   	        {
		   	        	process.destroy();
		   	        }
		    	}
	    	 }
	    		
	    }
	 

}

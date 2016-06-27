package com.discount.testUtils;
import org.openqa.selenium.WebDriver;


public class Driver  {
	
	WebDriver driver;
	BrowserFactory bwFactory;
	PropertyFileConfig propCtx ;
	
	
	
	public WebDriver driverInit(){
		  // System.out.println("in setup");
		   propCtx = new PropertyFileConfig();
		   String bw = propCtx.BrowserSetup();
		   bwFactory = new BrowserFactory();
		   driver = bwFactory.driverInit(bw);
		   return driver;
	   }
	
	 public void close(){
		   propCtx.ContextClose();
		   driver.close();
		   driver.quit();
	   }
}

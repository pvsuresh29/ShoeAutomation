package com.base.testUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;


public class Driver  {
	
	WebDriver driver;
	
	public WebDriver driverInit(){
/*		 DesiredCapabilities desiredCapabilities = DesiredCapabilities.safari();
    	 SafariOptions safariOptions = new SafariOptions();
    	 safariOptions.setUseCleanSession(true);
    	 desiredCapabilities.setCapability(SafariOptions.CAPABILITY, safariOptions);
    	 driver =  new SafariDriver(desiredCapabilities);
    	 return driver;*/
    	 
             	//System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
            System.setProperty("webdriver.ie.driver", "resources/IEDriverServer.exe");
             return new InternetExplorerDriver();
         
	   }
	
	 public void close(){
		   driver.close();
		   driver.quit();
	   }
}

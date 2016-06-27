package com.discount.testUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.discount.testUtils.CommonConstants.RemoteSeleniumServerURL;

public class BrowserFactory  
{
    /**
     * creates the browser driver specified in the system property "browser"
     * if no property is set then a firefox browser driver is created.
     * The allow properties are ie, firefox, safari and chrome
     * @return WebDriver
     */
	
		
		public WebDriver driverInit(String browserInUse){
			Browsers browser;
	        WebDriver driver;

	        if(browserInUse==null)
	        {
	            browser = Browsers.FIREFOX;
	        }
	        else
	        {
	            browser = Browsers.browserForName(browserInUse);
	        }
	        switch(browser)
	        {
	            case CHROME:
	                driver = createChromeDriver();
	                break;
	            case SAFARI:
	                driver = createSafariDriver();
	                break;
	            case IE:
	                driver = createIEDriver();
	                break;
	            case FIREFOX:
	            default:
	                driver = createFirefoxDriver();  //getFirefoxProfile()
	                break;
	        }
	        addAllBrowserSetup(driver);
	        return driver;
			
			
		}
	
		
	 public  WebDriver getBrowser()
	    {
	        Browsers browser;
	        WebDriver driver;

	        if(System.getProperty(CommonConstants.BROWSER_PROP_KEY)==null)
	        {
	            browser = Browsers.FIREFOX;
	        }
	        else
	        {
	            browser = Browsers.browserForName(System.getProperty(CommonConstants.BROWSER_PROP_KEY));
	        }
	        switch(browser)
	        {
	            case CHROME:
	                driver = createChromeDriver();
	                break;
	            case SAFARI:
	                driver = createSafariDriver();
	                break;
	            case IE:
	                driver = createIEDriver();
	                break;
	            case FIREFOX:
	            default:
	                driver = createFirefoxDriver();  //getFirefoxProfile()
	                break;
	        }
	        addAllBrowserSetup(driver);
	        return driver;
	    }
    

    private  WebDriver createSafariDriver() 
    {
         if(Boolean.parseBoolean(CommonUtils.readValueForKey("IsRemoting")))
         {
 	         DesiredCapabilities capabilities = DesiredCapabilities.safari();
 	         SafariOptions safariOptions = new SafariOptions();
 	         safariOptions.setUseCleanSession(false);
 	         WebDriver driver = null;
 	         try 
 	         {
 	             driver = new RemoteWebDriver(new URL(CommonUtils.readValueForKey(CommonConstants.RemoteSeleniumServerURL.SAFARI)),capabilities);
 	         } 
 	         catch (MalformedURLException e)
 	         {
 	             e.printStackTrace();
 	         }
 	             return driver;
         }
         else
         {
             DesiredCapabilities desiredCapabilities = DesiredCapabilities.safari();
        	 SafariOptions safariOptions = new SafariOptions();
        	 safariOptions.setUseCleanSession(true);
        	 desiredCapabilities.setCapability(SafariOptions.CAPABILITY, safariOptions);
             return new SafariDriver(desiredCapabilities);
         }
    }

    private  WebDriver createIEDriver()
    {
         if(Boolean.parseBoolean(CommonUtils.readValueForKey("IsRemoting")))
         {
 	         DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
 	         capabilities.setCapability("nativeEvents", false);   
             capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
             capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
 	         WebDriver driver = null;
 	         try 
 	         {
 	             driver = new RemoteWebDriver(new URL(CommonUtils.readValueForKey(CommonConstants.RemoteSeleniumServerURL.IE)),capabilities);
 	         } 
			 catch (MalformedURLException e) 
 	         {
 	             e.printStackTrace();
 	         }
 	             return driver;
         }
         else
         {
             System.setProperty("webdriver.ie.driver", "resources/IEDriverServer.exe");
             DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
             capabilities.setCapability("nativeEvents", false);   
             capabilities.setCapability("ignoreZoomSetting", true);
             capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
             capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
             return new InternetExplorerDriver(capabilities);
         }

    }

    private  WebDriver createChromeDriver() 
    {
        if(Boolean.parseBoolean(CommonUtils.readValueForKey("IsRemoting")))
        {
	        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	        capabilities.setPlatform(Platform.WIN8);
	        capabilities.setVersion("2.45");
	        WebDriver driver = null;
	        try 
	        {
	            driver = new RemoteWebDriver(new URL(CommonUtils.readValueForKey(CommonConstants.RemoteSeleniumServerURL.CHROME)),capabilities);
	        } 
	        catch (MalformedURLException e)
	        {
	            e.printStackTrace();
	        }
	            return driver;
        }
        else
        {
        	//System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            return new ChromeDriver();
        }
    }

    private  WebDriver createFirefoxDriver() 
    {     //FirefoxProfile firefoxProfile

        if(Boolean.parseBoolean(CommonUtils.readValueForKey("IsRemoting")))
        {
	        //FirefoxProfile profile = new FirefoxProfile();
	        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	        //capabilities.setCapability("firefox_profile", profile);	      
	        WebDriver driver = null;	
	        try 
	        {
	            driver = new RemoteWebDriver(new URL(CommonUtils.readValueForKey(CommonConstants.RemoteSeleniumServerURL.FIREFOX)),capabilities);
	        } 
	        catch (MalformedURLException e) 
	        {
	            e.printStackTrace();
	        }
	            return driver;
        }
        else
        {
        	final String fireFoxDriverBinPath = CommonUtils.readValueForKey("FireFoxDriverBinPath");
        	if(!fireFoxDriverBinPath.isEmpty())
        	{
                System.setProperty("webdriver.firefox.bin", fireFoxDriverBinPath);
        	}        	
            return  new FirefoxDriver();
        }
    }
    //firefoxProfile
    /*private static FirefoxProfile getFirefoxProfile() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        try {
            firefoxProfile.addExtension(FileUtils.getFile("firebug/firebug-1.9.2.xpi"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e){
            e.printStackTrace();
        }

        //See http://getfirebug.com/wiki/index.php/Firebug_Preferences
        firefoxProfile.setPreference("extensions.firebug.currentVersion", "1.9.2");  // Avoid startup screen
        firefoxProfile.setPreference("extensions.firebug.script.enableSites", true);
        firefoxProfile.setPreference("extensions.firebug.console.enableSites", true);
        firefoxProfile.setPreference("extensions.firebug.allPagesActivation", true);
        firefoxProfile.setPreference("extensions.firebug.delayLoad", false);
        return firefoxProfile;
    }*/

    private  void addAllBrowserSetup(WebDriver driver) 
    {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        //driver.manage().window().setPosition(new Point(0, 0));
        //java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(400,300));
    }    
}



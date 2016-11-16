package utilities;

import common.Config;
import common.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Suresh Venkata on 10/4/16.
 */
public class DriverFactory {

    private enum Browsers {
        IE,
        FIREFOX,
        CHROME,
        SAFARI;

        public static Browsers browserForName(String browser) throws IllegalArgumentException {
            for(Browsers b: values()) {
                if(b.toString().equalsIgnoreCase(browser)) {
                    return b;
                }
            }
            throw browserNotFound(browser);
        }

        private static IllegalArgumentException browserNotFound(String outcome) {
            return new IllegalArgumentException(("Invalid browser [" + outcome + "]"));
        }
    }

    public static WebDriver getDriver(String browserInUse){
        Browsers browser;
        WebDriver driver;

        if(browserInUse==null) {
            browser = Browsers.CHROME;
        }
        else {
            browser = Browsers.browserForName(browserInUse);
        }
        switch(browser) {
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
                driver = createFirefoxDriver();
                break;
        }
        addAllBrowserSetup(driver);
        return driver;

    }


    private static WebDriver createSafariDriver() {
        if (Config.getIsRemoting()) {
            DesiredCapabilities capabilities = DesiredCapabilities.safari();
            WebDriver driver = null;
            try {
                driver = new RemoteWebDriver(new URL(Constants.SAFARI_REMOTE),capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return driver;
        } else if (Config.getIsSaucelabs()) {
            DesiredCapabilities capabilities = DesiredCapabilities.safari();
            if (Config.getSaucelabsBrowser() != null) {
                setSaucelabsOnDemandCapabilities(capabilities);
            } else {
                capabilities.setCapability("platform", "OS X 10.11");
                capabilities.setCapability("version", "10.0");
            }
            WebDriver driver = null;
            try {
                driver = new RemoteWebDriver(new URL(Config.getSaucelabsUrl()), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return driver;
        } else {
            System.setProperty("webdriver.safari.driver", getDriverPath(Constants.SAFARI_BROWSER));
            DesiredCapabilities desiredCapabilities = DesiredCapabilities.safari();
            SafariOptions safariOptions = new SafariOptions();
            safariOptions.setUseCleanSession(true);
            desiredCapabilities.setCapability(SafariOptions.CAPABILITY, safariOptions);
            return new SafariDriver(desiredCapabilities);
        }
    }

    private static  WebDriver createIEDriver() {
        if (Config.getIsRemoting()) {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability("nativeEvents", false);
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            WebDriver driver = null;
            try {
                driver = new RemoteWebDriver(new URL(Constants.IE_REMOTE),capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return driver;
        } else if (Config.getIsSaucelabs()) {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            if (Config.getSaucelabsBrowser() != null) {
                setSaucelabsOnDemandCapabilities(capabilities);
            } else {
                capabilities.setCapability("platform", "Windows 7");
                capabilities.setCapability("version", "11.0");
            }
            WebDriver driver = null;
            try {
                driver = new RemoteWebDriver(new URL(Config.getSaucelabsUrl()), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return driver;
        } else {
            System.setProperty("webdriver.ie.driver", getDriverPath(Constants.IE_BROWSER));
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability("nativeEvents", false);
            capabilities.setCapability("ignoreZoomSetting", true);
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            return new InternetExplorerDriver(capabilities);
        }

    }

    private static  WebDriver createChromeDriver() {

        if (Config.getIsRemoting()) {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            WebDriver driver = null;
            try {
                driver = new RemoteWebDriver(new URL(Constants.CHROME_REMOTE),capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return driver;
        } else if (Config.getIsSaucelabs()) {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            if (Config.getSaucelabsBrowser() != null) {
                setSaucelabsOnDemandCapabilities(capabilities);
            } else {
                capabilities.setCapability("platform", "Windows 7");
                capabilities.setCapability("version", "54.0");
            }
            WebDriver driver = null;
            try {
                driver = new RemoteWebDriver(new URL(Config.getSaucelabsUrl()), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return driver;
        } else {
            System.setProperty("webdriver.chrome.driver", getDriverPath(Constants.CHROME_BROWSER));
            return new ChromeDriver();
        }

    }

    private static  WebDriver createFirefoxDriver() {

        if (Config.getIsRemoting()) {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            //capabilities.setCapability("marionette", true);
            WebDriver driver = null;
            try {
                driver = new RemoteWebDriver(new URL(Constants.FIREFOX_REMOTE),capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return driver;
        } else if (Config.getIsSaucelabs()) {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            if (Config.getSaucelabsBrowser() != null) {
                setSaucelabsOnDemandCapabilities(capabilities);
            } else {
                capabilities.setCapability("platform", "Windows 10");
                capabilities.setCapability("version", "49.0");
            }
            WebDriver driver = null;
            try {
                driver = new RemoteWebDriver(new URL(Config.getSaucelabsUrl()), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return driver;
        } else {
            System.setProperty("webdriver.gecko.driver", getDriverPath(Constants.FIREFOX_BROWSER));
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
            return new FirefoxDriver(capabilities);
        }
    }


    private static  void addAllBrowserSetup(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    private static String getDriverPath(String browserType) {

        String osType = System.getProperty("os.name");
        String cwd = System.getProperty("user.dir");
        String driverPath = cwd + "/src/test/resources/external/";

        if (browserType.equalsIgnoreCase(Constants.SAFARI_BROWSER)) {
            driverPath = driverPath + "SafariDriver";
        } else if (browserType.equalsIgnoreCase(Constants.IE_BROWSER)) {
            driverPath = driverPath + "IEDriverServer.exe";
        } else if (browserType.equalsIgnoreCase(Constants.CHROME_BROWSER)) {
            if (osType.contains("Windows")) {
                driverPath = driverPath + "chromedriver.exe";
            } else {
                driverPath = driverPath + "chromedriver";
            }
        } else if (browserType.equalsIgnoreCase(Constants.FIREFOX_BROWSER)) {
            if (osType.contains("Windows")) {
                driverPath = driverPath + "geckodriver.exe";
            } else {
                driverPath = driverPath + "geckodriver";
            }
        }
        return driverPath;
    }

    /**
     * Sets desired capabilities for the Sauce OnDemand plugin. For more information:
     * https://wiki.saucelabs.com/display/DOCS/Setting+Desired+Capabilities+for+Jenkins+Projects
     *
     * @param desiredCapabilities	  The desiredCapabilties to set
     */
    private static void setSaucelabsOnDemandCapabilities(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setBrowserName(Config.getSaucelabsBrowser());
        desiredCapabilities.setVersion(Config.getSaucelabsBrowserVersion());
        desiredCapabilities.setCapability(CapabilityType.PLATFORM, Config.getSaucelabsPlatform());
    }
}

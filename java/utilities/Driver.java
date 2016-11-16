package utilities;

/**
 * Created by Suresh Venkata on 9/21/16.
 */

import common.Config;
import common.Constants;
import common.ScenarioData;
import cucumber.api.Scenario;
import dtc.web.pages.AppointmentPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class Driver  {

    protected static WebDriver driver;
    public ScenarioData scenarioData;
    private static final String BROWSER = Config.getBrowser();
    private final Logger LOGGER = Logger.getLogger(AppointmentPage.class.getName());

    public Driver() {
        scenarioData = new ScenarioData();
    }

    public void initialize() {
        if (driver == null)
            createNewDriverInstance();
    }

    private void createNewDriverInstance() {
        driver = DriverFactory.getDriver(BROWSER);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void destroyDriver() {
        driver.quit();
        driver = null;
    }


    /**
     * Sleeps for set time to allow for animation to complete.
     */
    public void waitForMilliseconds() {
        waitForMilliseconds(Constants.ANIMATION_WAIT);
    }


    /**
     * Sleeps for passed in time.
     */
    public void waitForMilliseconds(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            LOGGER.info(e.toString());
        }
    }


    /**
     * Waits until the element is clickable.
     *
     * @param element The element to wait for
     */
    public void waitForElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * Waits until the element is visible.
     *
     * @param element	        The element to wait for
     */
    public void waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * Waits until the element is not visible.
     *
     * @param element	        The element to wait for
     */
    public void waitForElementNotVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_WAIT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }


    /**
     * Waits until the execution of the javascript returns with true.
     *
     * @param javaScript	    The javascript to be executed
     * @param timeOutInSeconds  The time in seconds to wait until returning a failure
     *
     * @return boolean
     */
    public boolean pollUntil(final String javaScript, int timeOutInSeconds) {
        boolean jsCondition = false;
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            (new WebDriverWait(driver, timeOutInSeconds)).until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driverObject) {
                    return (Boolean) ((JavascriptExecutor) driverObject).executeScript(javaScript);
                }
            });
            jsCondition = (Boolean) ((JavascriptExecutor) driver).executeScript(javaScript);
            driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_WAIT, TimeUnit.SECONDS);
            System.out.println("jsCondition:" + jsCondition);
            return jsCondition;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsCondition;
    }


    /**
     * Wait for the Text to be present in the given element, regardless of being displayed or not.
     *
     * @param by	            Selector of the given element, which should contain the text
     * @param text	            The text we are looking for
     * @param timeOutInSeconds  The time in seconds to wait until returning a failure
     *
     * @return boolean
     */
    public boolean waitForTextPresent(final By by, final String text, int timeOutInSeconds) {
        boolean isPresent = false;
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            new WebDriverWait(driver, timeOutInSeconds) {
            }.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driverObject) {
                    return driverObject.findElement(by).getText().contains(text);
                }
            });
            isPresent = driver.findElement(by).getText().contains(text);
            driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_WAIT, TimeUnit.SECONDS);
            return isPresent;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * Returns element among multiple that contains text substring, if substring not found
     * returns first
     *
     * @param elementBy	        The By element to build list with
     * @param value             The value to search for with element
     *
     * @return WebElement
     */
    public WebElement getElementWithText(By elementBy, String value) {
        WebElement returnElement = driver.findElement(elementBy);
        waitForElementVisible(returnElement);
        List<WebElement> elements = driver.findElements(elementBy);
        for (WebElement element : elements) {
            if (element.getText().toLowerCase().contains(value.toLowerCase())) {
                returnElement = element;
            }
        }
        return returnElement;
    }


    /**
     * Clicks an element via javascript executor
     *
     * @param element	        The element to click
     */
    public void jsClick(WebElement element) {
        String mouseOverScript = "arguments[0].click();";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(mouseOverScript, element);
    }

    public void clickElementByText(String linkText) {
        WebElement linkElement = driver.findElement(By.linkText(linkText));
        waitForElementClickable(linkElement);
        linkElement.click();
    }

    public void clickElementByPartialText(String linkText) {
        WebElement linkElement = driver.findElement(By.partialLinkText(linkText));
        waitForElementClickable(linkElement);
        linkElement.click();
    }

    /**
     * Scrolls an element into view before firing the click event. Useful when a modal or menu has options
     * listed outside current view such that they may be behind another element. This method will scroll them into
     * view and make a click collision between elements much less likely to occur.
     *
     * @param element The element to scroll into view on the page
     */
    public void jsScrollToElementClick(WebElement element) {
        String scrollScript = "arguments[0].scrollIntoView(true);";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(scrollScript, element);
        waitForElementClickable(element);
        jsClick(element);
    }

    /**
     * Returns the last substring of string with delimiter
     *
     * @param delimiter     The character preceding the string to extract
     */
    public String getLastSubstring(WebElement element, String delimiter) {
        return element.getText().substring(element.getText().lastIndexOf(delimiter) + 1);
    }


    /**
     * Moves to element
     *
     * @param element     The element to move to
     */
    public void moveToElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }


    /**
     * Gets the URL passed in
     *
     * @param url     The url to go to
     */
    public void getUrl(String url) {
        LOGGER.info("getUrl started");
        driver.get(url);
        LOGGER.info("Setting session ID...");
        this.scenarioData.setSessionId(driver);
        LOGGER.info("getUrl completed");
    }


    /**
     * Checks if element is displayed
     *
     * @param element     The element to check
     *
     * @return boolean
     */
    public boolean isElementDisplayed(WebElement element) {
        boolean isDisplayed = false;
        try {
            isDisplayed = element.isDisplayed();
        } catch (Exception e) {
            LOGGER.info("There was an error with checking for the element: " + e.toString());
        }
        return isDisplayed;
    }


    /**
     * Embeds a screenshot into a scenario if it is failed
     *
     * @param scenario     The scenario to check status of and embed screenshot if failed
     */
    public void embedScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                final byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                LOGGER.info(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
    }



}

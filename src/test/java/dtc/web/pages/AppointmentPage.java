package dtc.web.pages;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import common.Constants;
import data.Customer;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import utilities.Driver;

/**
 * Created by Suresh Venkata on 9/28/16. Updated by aarora
 */
public class AppointmentPage {

    private WebDriver webDriver;
    private Driver driver;
    private CommonActions commonActions;
    private final Logger LOGGER = Logger.getLogger(AppointmentPage.class.getName());

    public AppointmentPage(Driver driver) {
        this.driver = driver;
        webDriver = driver.getDriver();
        commonActions = new CommonActions(driver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "span-80222")
    public static WebElement serviceSelected;

    @FindBy(className = "appointment-steps__review-button")
    public static WebElement nextStepForDateandTimeButton;

    @FindBy(className = "btn-default")
    public static WebElement defaultButton;

    @FindBy(id = "dateDiv")
    public static WebElement selectAnAppointmentDateField;

    @FindBy(id = "choose-date")
    public static WebElement selectDateBox;

    @FindBy(id = "choose-time")
    public static WebElement selectTimeBox;

    @FindBy(id = "choose-date_table")
    public static WebElement chooseDateTable;

    @FindBy(className = "picker__list")
    public static WebElement timeListEle;

    @FindBy(className = "appointment-steps__review-button") //btn-default
    public static WebElement nextStepForCustomerInfoButton;

    @FindBy(id = "firstName")
    public static WebElement firstNameBox;

    @FindBy(id = "lastName")
    public static WebElement lastNameBox;

    @FindBy(id = "phone")
    public static WebElement phoneNumberBox;

    @FindBy(id = "accountEmailId")
    public static WebElement emailBox;

    @FindBy(id = "confirmEmail")
    public static WebElement confirmEmailBox;

    @FindBy(id = "phoneTypeId_chosen")
    public static WebElement phoneDropDown;

    @FindBy(id = "customerInfo")
    public static WebElement customerInfoField;

    @FindBy(className = "appointment-steps__review-button")
    public static WebElement makeReservationButton;

    @FindBy(className = "appointment-steps__edit")
    public static WebElement appointmentEditLink;

    @FindBy(linkText = "Change store")
    public static WebElement changeStoreLink;

    @FindBy(className = "picker__nav--next")
    public static WebElement nextMonthArrow;

    @FindBy(xpath = "//div[contains(@class,'picker--focused')]")
    public static WebElement pickTimeInFocus;

    @FindBy(id = "choose-date")
    public static WebElement appointmentDate;

    @FindBy(id = "choose-time")
    public static WebElement appointmentTime;

    @FindBy(className = "appointment-steps__storeinfo")
    public static WebElement appointmentStoreInfo;

    @FindBy(className = "appointment-store__time")
    public static WebElement appointmentDateTimeInfo;

    @FindBy(className = "global-message-content")
    public static WebElement globalMessage;

    public static final By nextBtnBy = By.className("btn-default");

    public static final String nextBtnText = "Customer Information";

    public static final String pickDayInfocus = "picker__day--infocus";

    public static final String pickDayDisabled = "picker__day--disabled";

    public static final String PHONE_TYPE = "phoneTypeId_chosen";

    public static final String serviceOptionXpath = "//span[text()='%s']";

    private static String passableDate;
    private static String passableTime;

    public static String getPassableDate() {
        return passableDate;
    }

    public static String getPassableTime() {
        return passableTime;
    }

    public void setPassableDate(String passableDate) {
        AppointmentPage.passableDate = passableDate;
    }

    public void setPassableTime(String passableTime) {
        AppointmentPage.passableTime = passableTime;
    }

    public void makeAppointment(Customer customer) {
        WebElement nextStepBtn = driver.getElementWithText(nextBtnBy, nextBtnText);
        selectDate();
        selectTime();
    }


    /**
     * Selects services from a string of options, separated by commas. Iterates over list to select
     * each individual service.
     *
     * @param options String of services to be selected, separated by commas.
     */
    public void selectService(String options) {
        LOGGER.info("selectService started");
        List<String> optionsToSelect = Lists.newArrayList(Splitter.on(",").trimResults().split(options));

        for (String option : optionsToSelect) {
            webDriver.findElement(By.xpath(String.format(serviceOptionXpath, option))).click();
        }

        LOGGER.info("selectService completed");
    }

    public void clickNextStepForDateAndTime() {
        LOGGER.info("clickNextStepForDateAndTime started");
        nextStepForDateandTimeButton.click();
        LOGGER.info("clickNextStepForDateAndTime completed");
    }

    public void clickNextStepForCustomerInformation() {
        LOGGER.info("clickNextStepForCustomerInformation started");
        webDriver.manage().timeouts().implicitlyWait(Constants.VERY_SHORT_WAIT, TimeUnit.SECONDS);
        try {
            nextStepForCustomerInfoButton.click();
        } catch (Exception e) {
            defaultButton.click();
        }
        webDriver.manage().timeouts().implicitlyWait(Constants.DEFAULT_WAIT, TimeUnit.SECONDS);
        LOGGER.info("clickNextStepForCustomerInformation completed");
    }

    /**
     * Selects a date from the month modal window, by clicking on the next month and selecting a date that
     * that is NOT disabled (Sundays)
     */
    public void selectDate() {
        LOGGER.info("selectDate started");
        driver.waitForMilliseconds();

        driver.waitForElementClickable(selectDateBox);

        driver.waitForMilliseconds();
        //TODO CCL 10/18 - On initial load date / time section, date field seems to have cursor focus which
        //TODO CCL 10/18 con't- is throwing off click();. This is a hopefully temporary workaround
        selectDateBox.sendKeys(Keys.SPACE);
        driver.waitForMilliseconds();
        selectDateBox.click();
        driver.waitForMilliseconds();

        driver.waitForElementVisible(chooseDateTable);
        nextMonthArrow.click();
        driver.waitForMilliseconds();

        List<WebElement> dayList = chooseDateTable.findElements(By.className(pickDayInfocus));
        for (int i = dayList.size() - 1; i >= 0; i--) {
            if (dayList.get(i).getAttribute("class").contains(pickDayDisabled)) {
                dayList.remove(i);
            }
        }

        dayList.get(1).click();
        driver.waitForMilliseconds(Constants.ANIMATION_LONG_WAIT);

        LOGGER.info("selectDate completed");
    }

    /**
     * Selects the first available time slot from the Time picker menu.
     */
    public void selectTime() {
        LOGGER.info("selectTime started");
        driver.waitForElementClickable(selectTimeBox);
        selectTimeBox.click();

        driver.waitForMilliseconds();
        driver.waitForElementVisible(pickTimeInFocus);

        //pickList = document.getElementsByClassName('picker__list')[0].childNodes'
        //for (i=0; i<pickList.length; i++){
        //  if ((pickList[i].className.indexOf('item--disabled')==-1)&&
        //      (pickList[i].className.indexOf('item-selected')>-1)){
        //       pickList[i].click();
        //  }
        //}

        List<WebElement> timeList = timeListEle.findElements(By.tagName("li"));
        for (WebElement timeEle : timeList) {
            //TODO: May need to leverage js (above) to deal with staleelementreference here
            if (!timeEle.getAttribute("class").contains("item--disabled")
                    && !timeEle.getAttribute("class").contains("item--selected")) {
                driver.jsScrollToElementClick(timeEle);
                driver.waitForMilliseconds(Constants.ANIMATION_LONG_WAIT);
                Assert.assertFalse("There were no available appointment times",
                        driver.isElementDisplayed(timeEle));
                break;
            }
        }

        LOGGER.info("selectTime completed");
    }

    public void enterCustomerInformation(Customer customer) {

        LOGGER.info("enterCustomerInformation started");
        driver.waitForElementClickable(firstNameBox);
        firstNameBox.sendKeys(customer.firstName);

        driver.waitForElementClickable(lastNameBox);
        lastNameBox.sendKeys(customer.lastName);

        driver.waitForElementClickable(emailBox);
        emailBox.sendKeys(customer.email);

        driver.waitForElementClickable(confirmEmailBox);
        confirmEmailBox.sendKeys(customer.email);

        driver.waitForElementClickable(phoneDropDown);
        commonActions.selectDropDownValue(PHONE_TYPE, customer.phoneType);

        driver.waitForElementClickable(phoneDropDown);
        phoneNumberBox.sendKeys(customer.phone);
        LOGGER.info("enterCustomerInformation completed");
    }

    public void clickMakeReserveButton() {
        LOGGER.info("clickMakeReserveButton started");
        driver.waitForElementClickable(makeReservationButton);
        makeReservationButton.click();
        LOGGER.info("clickMakeReserveButton completed");
    }

    public void clickAppointmentEditLink() {
        LOGGER.info("clickAppointmentEditLink started");
        driver.waitForElementVisible(appointmentEditLink);
        appointmentEditLink.click();
        LOGGER.info("clickAppointmentEditLink completed");
    }

    public void clickChangeStore() {
        LOGGER.info("clickChangeStore started");
        driver.waitForElementVisible(changeStoreLink);
        changeStoreLink.click();
        LOGGER.info("clickChangeStore completed");
    }

    public void assertCustomerInfoPageLoaded() {
        driver.waitForElementVisible(customerInfoField);
        LOGGER.info("Customer Information Form Displayed");
    }

    public String extractDate() {
        driver.waitForElementVisible(appointmentDate);
        setPassableDate(appointmentDate.getAttribute("value"));
        return getPassableDate();
    }

    public String extractTime() {
        driver.waitForElementVisible(appointmentTime);
        setPassableTime(appointmentTime.getAttribute("value"));
        return getPassableTime();
    }

    public void verifyDateAndTime(String date, String time) {
        driver.waitForElementVisible(appointmentDateTimeInfo);
        Assert.assertTrue("Did not see expected date (" + date + ") in appointment info: " +
                appointmentDateTimeInfo.getText(), appointmentDateTimeInfo.getText().contains(date));
        LOGGER.info("Confirmed that expected date (" + date + ") was listed in appointment info");
        Assert.assertTrue("Did not see expected time (" + time + ") in appointment info: " +
                appointmentDateTimeInfo.getText(), appointmentDateTimeInfo.getText().contains(time));
        LOGGER.info("Confirmed that expected date (" + time + ") was listed in appointment info");
    }

    public void verifyStore(String store) {
        driver.waitForElementVisible(appointmentStoreInfo);
        Assert.assertTrue("Did not see expected store (" + store + ") in appointment info: " +
                appointmentStoreInfo.getText(), appointmentStoreInfo.getText().contains(store));
        LOGGER.info("Confirmed that expected store (" + store + ") was listed in appointment info");
    }

    public void verifySpecialOrderMessage() {
        driver.waitForElementVisible(globalMessage);
        Assert.assertTrue(globalMessage.getText().contains(Constants.SPECIAL_ORDER_MESSAGE));
        LOGGER.info("verify Special Order Message is displayed");
    }

    public void verifyCallUsMessage() {
        driver.waitForElementVisible(globalMessage);
        Assert.assertTrue(globalMessage.getText().contains(Constants.CALL_US_MESSAGE));
        LOGGER.info("verify Call Us Message is displayed");
    }

}

package dtc.web.pages;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import data.Customer;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Suresh Venkata on 10/17/2016.
 */
public class AppointmentConfirmationPage {

    private Driver driver;
    private WebDriver webDriver;
    private final Customer customer;
    private final Logger LOGGER = Logger.getLogger(AppointmentPage.class.getName());

    public AppointmentConfirmationPage(Driver driver) {
        this.driver = driver;
        webDriver = driver.getDriver();
        customer = new Customer();
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(className = "confirmation-order__title")
    public static WebElement confirmationMessage;

    @FindBy(css = "div.confirmation-information > div:nth-child(1)")
    public static WebElement appointmentDetailsSection;

    public static final By appointmentNumberMessage = By.xpath("//p[contains(., 'Your appointment number is ')]");

    public static final By appointmentDetailsEmail =
            By.xpath("//p[contains(text(),\"A copy of your appointment details has been sent to\")]");

    public static final By appointmentDetailsMyInfo = By.xpath("//h6[text()='My Information']/following-sibling::dl");

    public static final By scheduledServices = By.xpath("//div[@class='appointment-service__item']/h5");

    /**
     * Confirms an appointment has successfully been created for the specified customer. Validates messaging, an
     * appointment number, email to receive details, and My Info section contents match with customer info.
     *
     * @param customerType name of customer enum to be used from Customer.java
     */
    public void confirmAnAppointmentPlaced(String customerType) {
        LOGGER.info("confirmAnAppointmentPlaced started");
        Customer apptCust = customer.getCustomer(customerType);

        Assert.assertTrue(confirmationMessage.getText().contains("Your order has been placed successfully."));

        Pattern pattern = Pattern.compile("Your appointment number is [0-9]{8}");
        Matcher match = pattern.matcher(webDriver.findElement(appointmentNumberMessage).getText());
        Assert.assertTrue("An appointment number was NOT displayed for the customer", match.find());

        Assert.assertTrue("Details NOT sent to expected email " + apptCust.email,
                webDriver.findElement(appointmentDetailsEmail).getText().contains(apptCust.email));

        List<String> myInfoDetails = Arrays.asList(
                apptCust.firstName, apptCust.lastName, apptCust.email, apptCust.phone.replaceAll("[\\s\\-()]", ""));

        for (String detail : myInfoDetails) {
            Assert.assertTrue("My Info section does NOT contain expected detail: " + detail,
                    webDriver.findElement(appointmentDetailsMyInfo).getText().contains(detail));
        }
        LOGGER.info("confirmAnAppointmentPlaced completed");
    }

    /**
     * Validates expected service option(s) is/are displayed on the appointment confirmation page.
     *
     * @param serviceOptions service option(s) expected to be on confirmation page
     */
    public void assertServiceOnConfirmationPage(String serviceOptions) {
        LOGGER.info("assertServiceOnConfirmationPage started");
        List<String> expectedOptions = Lists.newArrayList(Splitter.on(",").trimResults().split(serviceOptions));
        List<WebElement> displayedOptionElements = webDriver.findElements(scheduledServices);
        List<String> displayedOptions = new ArrayList<String>(displayedOptionElements.size());

        for (WebElement displayedOptionEle : displayedOptionElements) {
            displayedOptions.add(displayedOptionEle.getText());
        }

        Assert.assertTrue("Failed to find previously selected service options: " + expectedOptions +
                        "; in displayed section: " + displayedOptions,
                displayedOptions.containsAll(expectedOptions));
        LOGGER.info("assertServiceOnConfirmationPage completed");
    }

    /**
     * Validates the expected store, date, and time are displayed in the Appointment Details section of the Appointment
     * confirmation page.
     * @param store expected store to validate
     * @param date  expected date to validate
     * @param time  expected time to validate
     */
    public void verifyAppointmentDetailsSectionInfo(String store, String date, String time) {
        LOGGER.info("verifyAppointmentDetailsSectionInfo started");
        driver.waitForElementVisible(appointmentDetailsSection);
        List<String> appointmentDetails = Lists.newArrayList(store, date, time);

        for (String details : appointmentDetails) {
            Assert.assertTrue("The appointment detail: '" + details + "' was not found in the Appointment Details" +
                    " section", appointmentDetailsSection.getText().contains(details));
        }
        LOGGER.info("verifyAppointmentDetailsSectionInfo completed");
    }
}

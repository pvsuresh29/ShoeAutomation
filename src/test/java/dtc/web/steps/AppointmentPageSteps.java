package dtc.web.steps;

import common.Config;
import common.Constants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import data.Customer;
import dtc.web.pages.AppointmentPage;
import dtc.web.pages.CommonActions;
import dtc.web.pages.StoreLocatorPage;
import utilities.Driver;

/**
 * Created by Suresh Venkata on 10/24/16.
 */
public class AppointmentPageSteps {

    private AppointmentPage appointmentPage;
    private CommonActions commonActions;
    private Customer customer;
    private String appointmentDate;
    private String appointmentTime;

    public AppointmentPageSteps(Driver driver) {
        appointmentPage = new AppointmentPage(driver);
        commonActions = new CommonActions(driver);
        customer = new Customer();
    }

    @And("^I schedule an appointment for \"([^\"]*)\"$")
    public void i_schedule_an_appointment(String customerType) throws Throwable {
        Customer apptcCust = customer.getCustomer(customerType);
        appointmentPage.makeAppointment(apptcCust);
    }

    @Then("^I am brought to the appointment confirmation page$")
    public void i_am_brought_to_the_appointment_confirmation_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^I select an appointment \"(.*?)\"$")
    public void i_select_an_appointment_date(String date) throws Throwable {
        //TODO: refactor selectDate method to utilize date value
        appointmentPage.selectDate();
        appointmentPage.selectTime();
    }

    @And("^I reserve items for \"([^\"]*)\"$")
    public void i_reserve_items(String customerType) throws Throwable {
        Customer apptcCust = customer.getCustomer(customerType);
        appointmentPage.clickNextStepForCustomerInformation();
        appointmentPage.enterCustomerInformation(apptcCust);
        appointmentPage.clickMakeReserveButton();
    }

    @And("^I click next step for customer information$")
    public void i_click_next_for_customer_information() throws Throwable {
        appointmentPage.clickNextStepForCustomerInformation();
    }

    @Then("^I should see customer information page$")
    public void i_should_see_customer_information_page() throws Throwable {
        appointmentPage.assertCustomerInfoPageLoaded();
        commonActions.confirmCurrentUrl(Constants.CUSTOMER_INFO_URL, true);
    }

    @When("^I select edit and select change store$")
    public void i_select_edit_and_change_store() throws Throwable {
        appointmentPage.clickAppointmentEditLink();
        appointmentPage.clickChangeStore();
    }

    @When("^I select service options: \"(.*?)\"$")
    public void i_select_service_options(String options) throws Throwable {
        appointmentPage.selectService(options);
    }

    @When("^I select default date and time$")
    public void i_enter_appointment_information() throws Throwable {
        appointmentPage.clickNextStepForDateAndTime();
        appointmentPage.selectDate();
        appointmentPage.selectTime();

        i_extract_date_and_time_for_validation();
    }

    @And("^I extract date and time for validation$")
    public void i_extract_date_and_time_for_validation() throws Throwable {
        appointmentDate = appointmentPage.extractDate();
        appointmentTime = appointmentPage.extractTime();
    }

    @Then("^I verify date and time on the customer information appointment page$")
    public void i_verify_date_and_time_on_the_customer_information_page() throws Throwable {
        appointmentPage.verifyDateAndTime(appointmentDate, appointmentTime);
    }

    @And("^I verify store on the customer information appointment page$")
    public void i_verify_store_on_the_customer_information_page() throws Throwable {
        appointmentPage.verifyStore(Config.getDefaultStore());
    }

    @When("^I click reserve after entering customer information for \"([^\"]*)\"$")
    public void i_enter_customer_information(String customerType) throws Throwable {
        Customer apptcCust = customer.getCustomer(customerType);
        appointmentPage.enterCustomerInformation(apptcCust);
        appointmentPage.clickMakeReserveButton();
    }

    @And("^I validate the Special Order header message$")
    public void i_validate_the_special_order_header_message() throws Throwable {
        appointmentPage.verifySpecialOrderMessage();
    }

    @And("^I validate the Call Us message$")
    public void i_validate_the_call_us_message() throws Throwable {
        appointmentPage.verifyCallUsMessage();
    }
}

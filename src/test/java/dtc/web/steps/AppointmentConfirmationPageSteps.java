package dtc.web.steps;

import common.Config;
import cucumber.api.java.en.Then;
import dtc.web.pages.AppointmentConfirmationPage;
import dtc.web.pages.AppointmentPage;
import utilities.Driver;

/**
 * Created by Suresh Venkata on 10/24/16.
 */
public class AppointmentConfirmationPageSteps {

    private AppointmentConfirmationPage appointmentConfirmationPage;

    public AppointmentConfirmationPageSteps(Driver driver) {
        appointmentConfirmationPage = new AppointmentConfirmationPage(driver);
    }

    @Then("^I should see an appointment confirmation message for \"(.*?)\" with service options: \"(.*?)\"$")
    public void i_see_appointment_confirmation_message_and_selected_services(String customer, String serviceOptions)
            throws Throwable {
        appointmentConfirmationPage.confirmAnAppointmentPlaced(customer);
        appointmentConfirmationPage.assertServiceOnConfirmationPage(serviceOptions);
    }

    @Then("^I should see my previously selected store, date and time, in the appointment details section$")
    public void i_see_selected_store_date_and_time_in_appointment_details() throws Throwable {
        appointmentConfirmationPage.verifyAppointmentDetailsSectionInfo(Config.getDefaultStore(),
                AppointmentPage.getPassableDate(), AppointmentPage.getPassableTime());
    }
}

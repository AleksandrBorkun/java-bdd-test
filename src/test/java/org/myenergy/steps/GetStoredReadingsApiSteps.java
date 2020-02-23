package org.myenergy.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.myenergy.entities.StoredReading;

import static org.junit.Assert.*;
import static org.myenergy.api.SmartEnergyAPI.*;
import static org.myenergy.steps.BaseSteps.*;

public class GetStoredReadingsApiSteps {

    @When("get smart meter readings {string}")
    public void get_smart_meter_readings(String smartMeterID) {
        response = getReadings(smartMeterID);
    }

    @Given("company employee name {string}")
    public void company_employee_name(String name) {
        addReadingsToSmartMeter(companyUsersMap.get(name).getStoredSmartMeterReadings());
    }

    @Then("smart meter readings length is {int}")
    public void smart_meter_readings_length_is(int expectedNumberOfReadings) {
        assertTrue(gson.fromJson(response.getEntity(String.class), StoredReading[].class).length == expectedNumberOfReadings);
    }
}

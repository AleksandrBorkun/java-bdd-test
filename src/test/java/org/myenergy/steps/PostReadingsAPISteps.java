package org.myenergy.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.myenergy.entities.StoredReading;
import org.myenergy.entities.StoredSmartMeterReadings;

import static org.myenergy.api.SmartEnergyAPI.addReadingsToSmartMeter;
import static org.myenergy.api.SmartEnergyAPI.getReadings;
import static org.myenergy.utils.CustomUtils.getDate;

import static org.junit.Assert.*;
import static org.myenergy.steps.BaseSteps.*;

public class PostReadingsAPISteps {

    @When("add {double} power reading")
    public void add_power_reading(Double readings) {
        add_power_reading(readings, getDate());
    }

    @Then("check smart meter {double}")
    public void check_smart_meter(Double readings) {
        StoredReading[] actualData = gson.fromJson(getReadings(SMART_METER_ID).getEntity(String.class), StoredReading[].class);
        double actualReadings = actualData[0].getReading();
        assertTrue("Check That There is Only One Reading Value", actualData.length == 1);
        assertTrue(String.format("Check That Readings Value Is %s", readings), actualReadings == readings);
    }

    @When("add {double} power reading {string}")
    public void add_power_reading(Double readings, String time) {
        response = addReadingsToSmartMeter(new StoredSmartMeterReadings(SMART_METER_ID, time, readings));
    }

    @When("add power reading")
    public void add_power_reading() {
        StoredSmartMeterReadings emptyReadings = new StoredSmartMeterReadings(SMART_METER_ID);
        emptyReadings.addReading(new StoredReading());
        response = addReadingsToSmartMeter(emptyReadings);
    }
}

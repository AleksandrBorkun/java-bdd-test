package org.myenergy.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.myenergy.entities.PricePlanComparison;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.myenergy.api.SmartEnergyAPI.getPlanComparison;
import static org.myenergy.steps.BaseSteps.*;

public class GetCurrentPlanAPISteps {

    PricePlanComparison comparison;

    @When("get current plan {string}")
    public void get_current_plan(String smartMeterID) {
        response = getPlanComparison(smartMeterID);
    }

    @Then("check that price plan {string}")
    public void check_that_price_plan(String planName) {
        comparison = gson.fromJson(response.getEntity(String.class), PricePlanComparison.class);
        assertEquals(String.format("Check That Price plan id is '%s'", planName), planName, comparison.getPricePlanId());
    }

    @Then("check available plans {int}")
    public void check_available_plans(int expectedNumber) {
        int plans = comparison.getPricePlanComparisons().size();
        assertTrue(expectedNumber == plans);
    }
}

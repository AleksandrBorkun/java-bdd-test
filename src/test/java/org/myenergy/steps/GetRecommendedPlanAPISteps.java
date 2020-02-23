package org.myenergy.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.myenergy.entities.CompanyUsers;

import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.myenergy.api.SmartEnergyAPI.addReadingsToSmartMeter;
import static org.myenergy.api.SmartEnergyAPI.getRecommendedPlan;
import static org.myenergy.steps.BaseSteps.*;

public class GetRecommendedPlanAPISteps {

    String recommendedPlans;

    @Given("all users in place")
    public void all_users_in_place() {
        for(Map.Entry<String, CompanyUsers> userInfo: companyUsersMap.entrySet()){
            addReadingsToSmartMeter(userInfo.getValue().getStoredSmartMeterReadings());
        }
    }

    @When("check recommended plan {string}")
    public void check_recommended_plan(String smartMeterId) {
        response = getRecommendedPlan(smartMeterId);
    }

    @Then("{int} recommended plans shown")
    public void recommended_plans_shown(int expectedPlansNumber) {
        recommendedPlans = response.getEntity(String.class);
        assertTrue(expectedPlansNumber == recommendedPlans.split(",").length);
    }
}

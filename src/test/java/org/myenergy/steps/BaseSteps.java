package org.myenergy.steps;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.myenergy.entities.CompanyUsers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.myenergy.utils.CustomUtils.waitBackendToStart;

public class BaseSteps {

    private Process proc;

    public static final Gson gson = new Gson();
    public static final Map<String, CompanyUsers> companyUsersMap = new HashMap<>();

    public static String SMART_METER_ID = "";
    public static ClientResponse response;

    @Before
    public void createCompanyUser() throws IOException {
        System.out.println("Start Process");
        proc = Runtime.getRuntime().exec("java -jar src/test/resources/my-energy-1.0.jar");
        waitBackendToStart(proc);
        System.out.println("Generate Company Users");
        companyUsersMap.put("John", new CompanyUsers("John"));
        companyUsersMap.put("Dave", new CompanyUsers("Dave"));
        companyUsersMap.put("Sam", new CompanyUsers("Sam"));
        companyUsersMap.put("Anders", new CompanyUsers("Anders"));
        companyUsersMap.put("Alex", new CompanyUsers("Alex"));
    }

    @After
    public void stopProcess(){
        System.out.println("Kill Process");
        proc.destroy();
    }

    @Given("smart meter id is {string}")
    public void smart_meter_id_is(String smartMeterID) {
        SMART_METER_ID = smartMeterID;
    }

    @Then("check status code {int}")
    public void check_status_code(Integer expectedStatus) {
        assertTrue(String.format("Expected Status Code: %s | Actual: %s", expectedStatus, response.getStatus()),
                expectedStatus == response.getStatus());
    }
}

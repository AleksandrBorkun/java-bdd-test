package org.myenergy.api;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.myenergy.entities.StoredSmartMeterReadings;

import javax.ws.rs.core.MediaType;

public class SmartEnergyAPI {

    private static Gson gson = new Gson();

    public static final String BASE_URL =  "http://localhost:8080/";
    private static final String GET_READINGS_URL =  BASE_URL + "readings/read/%s";
    private static final String POST_READINGS_URL =  BASE_URL + "readings/store/";
    private static final String GET_RECOMMENDED_PLAN_URL =  BASE_URL + "price-plans/recommend/%s";
    private static final String GET_PRICE_PLAN_COMPARISON_URL =  BASE_URL + "price-plans/compare-all/%s";

    static final Client client  = Client.create();

    public static ClientResponse getReadings(String smartMeterID){
        WebResource webResource = client.resource(String.format(GET_READINGS_URL, smartMeterID));
        return webResource.get(ClientResponse.class);
    }

    public static ClientResponse addReadingsToSmartMeter(StoredSmartMeterReadings smartMeterReadings){
        WebResource webResource = client.resource(POST_READINGS_URL);
        return webResource.type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, gson.toJson(smartMeterReadings));
    }

    public static ClientResponse getPlanComparison(String smartMeterId){
        WebResource webResource = client.resource(String.format(GET_PRICE_PLAN_COMPARISON_URL, smartMeterId));
        return webResource.get(ClientResponse.class);
    }

    public static ClientResponse getRecommendedPlan(String smartMeterId){
        WebResource webResource = client.resource(String.format(GET_RECOMMENDED_PLAN_URL, smartMeterId));
        return webResource.get(ClientResponse.class);
    }
}


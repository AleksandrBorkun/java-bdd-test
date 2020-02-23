package org.myenergy.entities;

import java.util.Map;

public class PricePlanComparison {

    Map<String, Double> pricePlanComparisons;
    String pricePlanId;

    public Map<String, Double> getPricePlanComparisons() {
        return pricePlanComparisons;
    }

    public String getPricePlanId() {
        return pricePlanId;
    }

    @Override
    public String toString() {
        return "{" +
                "\"pricePlanComparisons\":" + pricePlanComparisons +
                ", \"pricePlanId\":" + pricePlanId + '\'' +
                '}';
    }
}

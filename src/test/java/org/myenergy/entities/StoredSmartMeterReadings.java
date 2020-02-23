package org.myenergy.entities;

import java.util.ArrayList;

public class StoredSmartMeterReadings {

    private String smartMeterId;
    private ArrayList<StoredReading> electricityReadings;

    public StoredSmartMeterReadings(String smartMeterId) {
        this.smartMeterId = smartMeterId;
        electricityReadings = new ArrayList<>();
    }

    public StoredSmartMeterReadings(String smartMeterId, String time, double reading) {
        this.smartMeterId = smartMeterId;
        addReading(time, reading);
    }
    public void addReading(String time, double reading) {
        if (electricityReadings == null) {
            electricityReadings = new ArrayList<>();
        }
        electricityReadings.add(new StoredReading(time, reading));
    }

    public void addReading(StoredReading readings){
        if(electricityReadings == null){
            electricityReadings = new ArrayList<>();
        }
        electricityReadings.add(readings);
    }

    @Override
    public String toString() {
        return '{' +
                "\"smartMeterId\": \"" + smartMeterId + '"' +
                ",\"electricityReadings\": " + electricityReadings.toString() +
                '}';
    }
}

package org.myenergy.entities;

public class StoredReading {

    private String time;
    private double reading;

    public StoredReading(){

    }

    public StoredReading(String time, double reading) {
        this.time = time;
        this.reading = reading;
    }

    public double getReading() {
        return reading;
    }

    @Override
    public String toString() {
        return "{" +
                "\"time\":" + time +
                ", \"reading\":" + reading +
                "}";
    }

}

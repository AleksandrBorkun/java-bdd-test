package org.myenergy.entities;

import static org.myenergy.utils.CustomUtils.getDate;
import static org.myenergy.utils.CustomUtils.getRandomReadings;

public class CompanyUsers {

    String name;
    StoredSmartMeterReadings storedSmartMeterReadings;

    public CompanyUsers(String name) {
        this.name = name;
        if(name.equals("John")){
            storedSmartMeterReadings = new StoredSmartMeterReadings("smart-meter-0");
            fillReadings(10);
        } else  if(name.equals("Dave")){
            storedSmartMeterReadings = new StoredSmartMeterReadings("smart-meter-1");
            fillReadings(2);
        } else  if(name.equals("Sam")){
            storedSmartMeterReadings = new StoredSmartMeterReadings("smart-meter-2");
            fillReadings(10);
        } else  if(name.equals("Anders")){
            storedSmartMeterReadings = new StoredSmartMeterReadings("smart-meter-3");
            fillReadings(1);
        } else  if(name.equals("Alex")){
            storedSmartMeterReadings = new StoredSmartMeterReadings("smart-meter-4");
            fillReadings(2);
        }
    }

    public StoredSmartMeterReadings getStoredSmartMeterReadings() {
        return storedSmartMeterReadings;
    }

    private void fillReadings(int howMuch){
        for(int i = 0; i < howMuch; i++){
            storedSmartMeterReadings.addReading(getDate(i), getRandomReadings());
        }
    }
}

package org.myenergy.utils;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class CustomUtils {

    public static String getDate(){
        return getDate(0);
    }

    public static String getDate(int minusMonth){
        Date minus2Month = Date.from(LocalDate.now().minusMonths(minusMonth).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return String.valueOf((int)(minus2Month.getTime()/1000));
    }

    public static double getRandomReadings(){
        return ThreadLocalRandom.current().nextDouble(1, 100);
    }

    public static void waitBackendToStart(Process proc) throws IOException {
        while (true){
            InputStream is = proc.getInputStream();
            byte b[]=new byte[is.available()];
            is.read(b,0,b.length);
            if(new String(b).contains("Started MyEnergyApplication")){
                break;
            };
        }
    }
}

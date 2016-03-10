package com.aalonzo;

import org.apache.commons.lang3.*;
import org.apache.commons.lang3.time.*;
import java.util.*;
import java.text.*;


/**
 *  Contains the logic for creating a TimeStamp 
 * 
 **/
public class TimeStampController {
    public TimeStampController() {

    }
    public TimeStamp getTimeStamp(String strDate) {

        String naturalLanguageDate = null;
        Long unixDate = null;
        Date date = null;
        
        //if nothing is passed in, return a blank TimeStamp
        if (strDate == null || strDate == "") {
            return new TimeStamp();
        }
        
        //if the date is all numbers, then it's a unix timestamp
        if (StringUtils.isNumeric(strDate)) {
            System.out.println("unix timestamp entered");
            
            //unix timestamp
            try {
                date = new Date(Long.parseLong(strDate) * 1000);
            }
            catch (NumberFormatException e) {
                //input date is invalid
                return new TimeStamp();
            }

        }
        else {
        
            System.out.println("natural language timestamp entered");
            // input date is in natural language
           // String [] datePatterns = {"MMMM d, yyyy", "MMMM d,yyyy"};
            
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            format.setTimeZone(TimeZone.getTimeZone("UTC"));
                      
            try {
            	date = format.parse(strDate);
               // date = DateUtils.parseDate(strDate, Locale.ENGLISH, datePatterns);
            }
            catch (ParseException ex) {
                //input date is invalid
                return new TimeStamp();
            }
        }
        
        //convert the date to unixTime
        unixDate = date.getTime() / 1000;
        
        //convert the date to natural language

        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        
        naturalLanguageDate = format.format(date.getTime());
        
        return new TimeStamp(unixDate, naturalLanguageDate);
    }
}
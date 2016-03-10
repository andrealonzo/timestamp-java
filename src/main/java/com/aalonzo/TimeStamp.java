package com.aalonzo;


/**
 *  TimeStamp Model POJO
 * 
 **/
 
public class TimeStamp{
    Long unix;
    String natural;
    public TimeStamp(){
        unix = null;
        natural = null;
    }
    public TimeStamp(Long unixDate, String naturalLanguageDate){
        this.unix = unixDate;
        this.natural = naturalLanguageDate;
    }
    public void setUnixDate(Long unixDate){
        this.unix = unixDate;
    }
    public Long getUnixDate(){
        return unix;
    }
    public void setNaturalLanguageDate(String naturalLanguageDate){
        this.natural = naturalLanguageDate;
    }
    public String getNaturalLanguageDate(){
        return natural;
    }
}
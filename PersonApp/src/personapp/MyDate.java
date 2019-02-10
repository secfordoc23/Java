//Program: personapp
//This: MyDate.java
//Date: 1/24/2017
//Author: Jason Welch
//Purpose: A class to store a Date

package personapp;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class MyDate 
{
    private int year;
    private int month;
    private int day;
    
    private Calendar cal;
    
    //==================== Default constructor =========================
    public MyDate()
    {
        cal = Calendar.getInstance();
        
        this.year = cal.get(GregorianCalendar.YEAR);
        this.month = cal.get(GregorianCalendar.MONTH);
        this.day = cal.get(GregorianCalendar.DAY_OF_MONTH);        
    }
    
    //==================== Default constructor =========================
    public MyDate(long elapsedTime)
    {
        cal = Calendar.getInstance();
        
        cal.setTimeInMillis(elapsedTime);
        
        this.year = cal.get(GregorianCalendar.YEAR);
        this.month = cal.get(GregorianCalendar.MONTH);
        this.day = cal.get(GregorianCalendar.DAY_OF_MONTH);       
    }
    
    //==================== Default constructor =========================
    public MyDate(int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    //==================== setDate =========================
    public void setDate(long elapsedTime)
    {
        cal.setTimeInMillis(elapsedTime);
        
        this.year = cal.get(GregorianCalendar.YEAR);
        this.month = cal.get(GregorianCalendar.MONTH);
        this.day = cal.get(GregorianCalendar.DAY_OF_MONTH);         
    }
    //==================== Setters and Getters =========================
    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    //==================== toString ======================
    @Override
    public String toString()
    {
        String display =  "MyDate: " 
                + "\n\tyear=" + year 
                + "\n\tmonth=" + month 
                + "\n\tday=" + day;
        return display;
    }
    
}

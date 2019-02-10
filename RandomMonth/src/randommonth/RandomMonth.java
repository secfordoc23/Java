//Program: Random Month
//This: randomMonth.java
//Date: 9/8/2015
//Author: Jason Welch
//Purpose: To diplay a random month

package randommonth;

import java.util.Random;

public class RandomMonth 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Initialize random Number Generator
        Random myRand = new Random();
        
        // variable declaration
        int monthNum = myRand.nextInt(12) + 1;
        String monthName = "";
        
        switch(monthNum)
        {
            case 1: monthName = "January";
                break;
            case 2: monthName = "February";
                break;
            case 3: monthName = "March";
                break;
            case 4: monthName = "April";
                break;
            case 5: monthName = "May";
                break;
            case 6: monthName = "June";
                break;
            case 7: monthName = "July";
                break;
            case 8: monthName = "August";
                break;
            case 9: monthName = "September";
                break;
            case 10: monthName = "October";
                break;
            case 11: monthName = "November";
                break;
            case 12: monthName = "December";
                break;
        }  // end Switch
        
        System.out.println("Random Month is: " + monthName);
    }

}

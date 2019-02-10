//Program: OrderThreeCities
//This: orderThreeCities.java
//Date: 9/18/2015
//Author: Jason Welch
//Purpose: Sort three Cities into Alphabetical Order

package orderthreecities;

import java.util.Scanner;

public class OrderThreeCities 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        String firstCity = "";
        String secondCity = "";
        String thirdCity = "";
        String results = "";
        
        // Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the first City: ");
        firstCity = input.nextLine();
        
        System.out.print("Enter the second City: ");
        secondCity = input.nextLine();
        
        System.out.print("Enter the third City: ");
        thirdCity = input.nextLine();
        
        if(firstCity.charAt(0) < secondCity.charAt(0) && firstCity.charAt(0) < thirdCity.charAt(0))
        {
            results = firstCity + " ";
            if(secondCity.charAt(0) < thirdCity.charAt(0))
            {
                results += secondCity + " " + thirdCity;
            }
            else
            {
                results += thirdCity + " " + secondCity;
            }
        }
        else if(secondCity.charAt(0) < firstCity.charAt(0) && secondCity.charAt(0) < thirdCity.charAt(0))
        {
            results = secondCity + " ";
            if(firstCity.charAt(0) < thirdCity.charAt(0))
            {
                results += firstCity + " " + thirdCity;
            }
            else
            {
                results += thirdCity + " " + firstCity;
            }
        }
        else
        {
            results = thirdCity + " ";
            if(secondCity.charAt(0) < firstCity.charAt(0))
            {
                results += secondCity + " " + firstCity;
            }
            else
            {
                results += firstCity + " " + secondCity;
            }
        }
        
        System.out.println("The three cities in alphabetical order are " + results);
    }

}

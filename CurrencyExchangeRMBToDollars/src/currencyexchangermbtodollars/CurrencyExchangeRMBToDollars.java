//Program: Currency Exchange RMB to Dollars
//This: currencyExchangeRMBToDollars.java
//Date: 9/8/2015
//Author: Jason Welch
//Purpose: This program will display dollars to RMB and vise versa based on user 
// input.

package currencyexchangermbtodollars;

import java.util.Scanner;

public class CurrencyExchangeRMBToDollars 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        
        // user Input Scanner
        Scanner input = new Scanner(System.in);
        
        // Variable declaration
        int dollarsOrRMB = 0;
        double dollarAmount = 0;
        double rmbAmount = 0;
        double exchangeRate = 0;
        
        // Get User Input
        System.out.print("Enter the Exchange Rate from Dollars to RMB: ");
        exchangeRate = input.nextDouble();
        
        System.out.print("Enter 0 to convert Dollars to RMB and 1 vise versa: ");
        dollarsOrRMB = input.nextInt();
        
        if(dollarsOrRMB == 0)
        {
            // Dollars to RMB
            System.out.print("Enter the Dollar amount: ");
            dollarAmount = input.nextDouble();
            
            // calculate RMB amount
            rmbAmount = dollarAmount * exchangeRate;
            
            //Display Output
             System.out.println("$" + dollarAmount + " is " + rmbAmount + " yuan");           
        }
        else
        {
            // RMB to Dollars
            System.out.print("Enter the RMB amount: ");
            rmbAmount = input.nextDouble();
            
            // Calculate Dollar Amount
            dollarAmount = rmbAmount / exchangeRate;
            
            // Display Output
            System.out.println(rmbAmount + " yuan is $" + dollarAmount);
        }
        
        
    }

}

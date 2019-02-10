//Program: CostOfdriving
//This: CostOfdriving.java
//Date: 8/31/2015
//Author: Jason Welch
//Purpose: This program is designed to take distance, mpg, and Price per Gallon as input and display calculated
//  cost of Driving.

package costofdriving;

import java.util.Scanner;

public class CostOfDriving 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        double distance;
        double mpg;
        double pricePerGal;
        double totalCost;
        
        // Create Scanner to read console input
        Scanner input = new Scanner(System.in);
        
        // Get input from User
        System.out.print("Enter the Driving Distance: ");
        distance = input.nextDouble();
                
        System.out.print("Enter Miles per Gallon: ");
        mpg = input.nextDouble();
                
        System.out.print("Enter Price per Gallon: ");
        pricePerGal = input.nextDouble();
                
        // calculate
        totalCost = (distance / mpg) * pricePerGal;
        
        // Display Calculated output
        System.out.println("The Cost of Driving is: $" + (totalCost * 100) / 100);
    }

}

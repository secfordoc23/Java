//Program: CalculateCelsiusToFahrenheit
//This: CalculateCelsiusToFahrenheit.java
//Date: 8/31/2015
//Author: Jason Welch
//Purpose: This program is designed to take Celsius as input and display calculated
//  degrees in fahrenheit

package calculatecelsiustofahrenheit;

import java.util.Scanner;

public class CalculateCelsiusToFahrenheit 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // variable declaration
        double celsius;
        double fahrenheit;
        
        // Create Scanner to read console input
        Scanner input = new Scanner(System.in);
        
        // Get input from User
        System.out.print("Enter a degree in Celsius:");
        celsius = input.nextDouble();
        
        // calculate degrees in Fahrenheit
        fahrenheit = (9.0 / 5) * celsius + 32;
        
        // Display Calculated output
        System.out.println(celsius + " Celsius is " + fahrenheit + " Fahrenheit");
    }

}

//Program: AreaAndVolumeOfCylinder 
//This: AreaAndVolumeOfCylinder.java
//Date: 8/31/2015
//Author: Jason Welch
//Purpose: This program is designed to take radius and length as input and display calculated
//  area and volume of a Cylinder.

package areaandvolumeofcylinder;

import java.util.Scanner;

public class AreaAndVolumeOfCylinder 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Constant Declaration
        final double PI = 3.14159;
        
        // variable declaration
        double radius;
        double length;
        double area;
        double volume;
        
        // Create Scanner to read console input
        Scanner input = new Scanner(System.in);
        
        // Get input from User
        System.out.print("Enter the Radius and Length of a Cylinder: ");
        radius = input.nextDouble();
        length = input.nextDouble();
        
        // calculate Area
        area = radius * radius * PI;
        
        // Calculate Volume
        volume = area * length;
        
        // Display Calculated output
        System.out.println("The Area is:" + area);
        System.out.println("The Volume is: " + volume);
    }

}

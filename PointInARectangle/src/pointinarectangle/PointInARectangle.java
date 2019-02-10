//Program: Point In A rectangle
//This: pointinarectangle.java
//Date: 9/14/2015
//Author: Jason Welch
//Purpose: This program prompts the user to enter a point and determines if it 
//  is in the rectangle.

package pointinarectangle;

import java.util.Scanner;

public class PointInARectangle 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable declaration
        double x;
        double y;
        String results;
        
        //Scanner
        Scanner input = new Scanner(System.in);
        
        // get user input
        System.out.print("Enter a point with two coordintes: ");
        x = input.nextDouble();
        y = input.nextDouble();
        
        if(x <= 2.5 && x >= -2.5)
        {
            if(y >= -5 && y <= 5)
            {
                results = "in NOT in the rectangle";
            }
            else
            {
                results = "is in the rectangle";
            }
        }
        else
        {
            results = "in NOT in the rectangle";
        }
        
        System.out.println("Point (" + x + ", " + y + ") " + results);
    }

}

//Program: babynames
//This: InputValidator.java
//Date: 3/9/2016
//Author: Jason Welch
//Purpose: A class to validate user input

package babynames;

import java.util.Scanner;


public class InputValidator 
{
    private Scanner userInput;
    
    public InputValidator()
    {
        userInput = new Scanner(System.in);
    }
    
    //============================ getYear ============================
    public int getYear()
    {
        int year;
        
        do
        {
            //prompt user for a year and stores it in class variable year
            System.out.print("Enter a year (2001 - 2010): ");
            while(!userInput.hasNextInt())
            {
                System.out.print("Please enter a valid year (2001 - 2010): ");
                userInput.next();
            }
            year = userInput.nextInt();
        } while(year < 2001 || year > 2010);
        
        return year;
    }
    
    //=============================== getName ========================
    public String getName()
    {
        //prompt user for a name and stores it in class variable name
        System.out.print("Enter a name: ");
        String name = userInput.next();
        
        return name;
    }
    
    //============================= getGender ========================
    public char getGender()
    {
        boolean quit = false;
        char gender;
        
        do
        {
            //prompt user for gender and stores it in class variable sex
            System.out.print("Enter the gender M for male, F for female: ");
            gender = userInput.next().toUpperCase().charAt(0);
            if ( gender == 'M' || gender == 'F')
            {                    
                quit = true;
            }                
            else
            {
                System.out.println("Invalid entry");
            }            
        } while (quit == false);
        
        return gender;
    }
    
}

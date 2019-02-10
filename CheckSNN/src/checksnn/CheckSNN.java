//Program: CheckSNN
//This: checkSNN.java
//Date: 9/18/2015
//Author: Jason Welch
//Purpose: Check to see if user input is a valid SSN

package checksnn;

import java.util.Scanner;

public class CheckSNN 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        String ssn = "";
        String results = "";
        
        //Scanner 
        Scanner input = new Scanner(System.in);
        
// Get User input
        System.out.print("Enter a SNN: ");
        ssn = input.nextLine();
        
        System.out.println(ssn.length());
        System.out.println(ssn.charAt(3));
        System.out.println(ssn.charAt(6));
        
        // Check Valid 
        if(ssn.length() == 11)
        {
            if(ssn.charAt(3) == '-' && ssn.charAt(6) == '-')
            {
                results = " is a valid Social Security Number.";
            }
            else
            {
                results = " is an invalid Social Security Number.";
            }
                    
        }
        else
        {
            results = " is an invalid Social Security Number.";
        }
        
        System.out.println(ssn + results);
       
    }

}

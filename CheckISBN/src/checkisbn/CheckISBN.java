//Program: CheckISBN
//This: checkisbn.java
//Date: 9/29/2015
//Author: Jason Welch
//Purpose: To create a check sum for the first 12 digits of an ISBN13 book number
//      formula: 10-((d1 + 3 *d2 + d3 + 3 * d4 + d5 + 3 * d6 + d7 + 3 * d8 + d9 + 3 * d10 + d11 + 3 * d12)%10)

package checkisbn;

import java.util.Scanner;


public class CheckISBN 
{

    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable declaration
        int evenSum = 0;
        int oddSum = 0;
        int total = 0;
        boolean isValid = true;
        char playAgain;
        
        // Scanner
        Scanner input = new Scanner(System.in);
     do
     {
         
        System.out.println("Enter a 12 digit number for the ISBN: ");
        System.out.print(">");
        String isbn12 = input.next();
        
        for(int index = 0; index < isbn12.length(); index++)
        {
            boolean isADigit = (Character.isDigit(isbn12.charAt(index)));
            if(isADigit == false)
            {
                isValid = false;
            }
        }
        
        // Check to make sure 12 digits where entered and that all digits are numbers
        while(isbn12.length() != 12 || isValid == false)
        {
                    
            System.out.println("Invalid Input!");
            
            System.out.println("Enter a 12 digit number for the ISBN: ");
            System.out.print(">");
            isbn12 = input.next();
            
            for(int index = 0; index < isbn12.length(); index++)
            {
                boolean isADigit = (Character.isDigit(isbn12.charAt(index)));
                if(isADigit == false)
                {
                    isValid = false;
                    break;
                }
                else
                {
                    isValid = true;
                }
            }
            
        } // end while loop
        

        
        for(int index = 0; index < isbn12.length(); index++)
        {
            if (index % 2 == 1)
            {
                oddSum += ((isbn12.charAt(index) - 48 )* 3);
            }
            else
            {
                evenSum += (isbn12.charAt(index) - 48 );
            }
           
        } // end for loop
        
        total = oddSum + evenSum;
        int checkNum = 10 - (total % 10);
        
        if (checkNum == 10)
        {
            checkNum = 0;
        }
        String isbn13 = isbn12 + checkNum;
        
        System.out.println("The ISBN13 for the book is: " + isbn13);
        
        System.out.print("Do you wish to run again(y/n): ");
        String userCont = input.next();
        playAgain = userCont.charAt(0);
        
    } while (playAgain == 'Y' || playAgain == 'y');

    } // end Main
    
}

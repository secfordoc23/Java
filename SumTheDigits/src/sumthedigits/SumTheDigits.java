//Program: SumTheDigits
//This: sumthedigits.java
//Date: 10/10/2015
//Author: Jason Welch
//Purpose: Display the sum of the digits in an interger or long

package sumthedigits;

import java.util.Scanner;

public class SumTheDigits 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // variable declaration
        String number;
        int sum;
        boolean quit = false;
        
        
        // Scanner
        Scanner input = new Scanner(System.in);
        
        do
        {
           System.out.print("Choose:\n " +
                   "\t(1) Sum of Digits in a Number \n" +
                   "\t(0) Quit \n");
           
           System.out.print("Enter choice: ");
           String choose = input.next();
           
           char choice = choose.charAt(0);
           
           switch(choice)
           {
               case '0': quit = true;
                   break;
               case '1':
                   System.out.print("Enter in a number: ");
                   number = input.next();
                   sum = sumDigits(number);
                   System.out.println("The Sum of the digits for number " + number + " is " + sum);
                   break;
               default: System.out.println("Not valid - Choose again!");
           }
           
        } while(quit == false);
    }
    
    //===========  sumDigits ==========================
    private static int sumDigits(String number)
    {
        // Variable Declaration
        int sum = 0;
        int digit = 0;
        for(int index = 0;index < number.length(); index++)
        {
            if(number.charAt(index) >= '0' && number.charAt(index) <= '9')
            {
                digit = Integer.parseInt(number.substring(index, index + 1));
                sum += digit;
            }

        }
        return sum;
    }
}

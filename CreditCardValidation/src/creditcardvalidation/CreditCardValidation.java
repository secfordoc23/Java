//Program: CreditCardValidation
//This: creditcardvalidation.java
//Date: 10/13/2015
//Author: Jason Welch
//Purpose: To check to see if a credit card number is valid 

package creditcardvalidation;

import java.util.Scanner;

public class CreditCardValidation 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        String creditCardNum = "";
        boolean isValid;
                boolean quit = false;
        
        
        // Scanner
        Scanner input = new Scanner(System.in);
        do
        {
           System.out.print("Choose:\n " +
                   "\t(1) Verify Credit Card Number \n" +
                   "\t(0) Quit \n");
           
           System.out.print("Enter choice: ");
           String choose = input.next();
           
           char choice = choose.charAt(0);
           
           switch(choice)
           {
               case '0': quit = true;
                   break;
               case '1':
                   System.out.print("Enter in a Credit Card Number to see if it is valid: ");
                   creditCardNum = input.next();
                   isValid = isValid(creditCardNum);
                   
                   if(isValid == true)
                   {
                       System.out.println(creditCardNum + " is Valid.");
                   }
                   else
                   {
                       System.out.println(creditCardNum + " is Invalid.");
                   }
                   
                   break;
               default: System.out.println("Not valid - Choose again!");
           }
        } while(quit == false);
    }
    
    //===========  isValid ==========================
    private static boolean isValid(String number)
    {
        //Variable declaration
        boolean isValid;
        int length = getSize(number);
        int total = 0;
       
        if(length >= 13 && length <= 16)
        {
            if(prefixMatch(number, 37) == true || prefixMatch(number, 4) == true || prefixMatch(number, 5) == true || prefixMatch(number, 6) == true)
            {
               total = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);

               if((total % 10) == 0)
               {
                   isValid = true;
               }
               else
               {
                   isValid = false;

               }
            }
            else
            {
                isValid = false;

            }
        }
        else
        {
            isValid = false;

        }
        
        
        return isValid;
    }
    //=========== sumOfDoubleEvenPlace ==========================
    private static int sumOfDoubleEvenPlace(String number)
    {
        //Variable Declaration
        int length = getSize(number);
        int evenSum = 0;
        for(int index = 0; index < length ; index++)
        {
            if((index % 2) == 0)
            {
                evenSum += getDigit((number.charAt(index) - 48));
            }
        }
        
        return evenSum;
    }
    
    //===========  getDigit ==========================
    private static int getDigit(int number)
    {
        
        int total = number * 2;
        
        if(total > 9)
        {
            total = (total / 10) + (total % 10);
        }
        return total;
        
    }
    
    //===========  sumOfOddPlace ==========================
    private static int sumOfOddPlace(String number)
    {
        //Variable Declaration
        int length = getSize(number);
        int oddSum = 0;
        
        for(int index = 0; index < length ; index++)
        {
            if((index % 2) > 0 )
            {
                oddSum += (number.charAt(index) - 48);
            }

        }
        return oddSum;
    }
    
    //===========  prefixMatch ==========================
    private static boolean prefixMatch(String number, int prefixDigit)
    {
        //Variable Declaration
        boolean isValid;
        int prefix;
        
        if(prefixDigit > 9)
        {
            prefix = getPrefix(number, 2);
        }
        else
        {
            prefix = getPrefix(number, 1);
        }
        
        if(prefix == prefixDigit)
        {
            isValid = true;
        }
        else
        {
            isValid = false;
        }
        return isValid;
    }
    
    //===========  getSize ==========================
    private static int getSize(String number)
    {
        //Variable Declaration
        int length = number.length();
        
        return length;
    }
    
    //===========  getPrefix ==========================
    private static int getPrefix(String number, int numDigits)
    {
        //Variable Declaration
        int prefix = Integer.parseInt(number.substring(0, numDigits));
        
        return prefix;
    }
}

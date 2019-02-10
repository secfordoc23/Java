//Program: DistincNumbers
//This: distinctnumbers.java
//Date: 10/26/2015
//Author: Jason Welch
//Purpose: Display a list of distinct numbers from a  set of 10 numbers

package distinctnumbers;

import java.util.Scanner;

public class DistinctNumbers 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        String userInput = "";
        String distinctNumbers = "";
        boolean quit = false;
        
        
        // Get Keyboard input
        Scanner input = new Scanner(System.in);
        
        do
        {
           System.out.print("Choose:\n " +
                   "\t(1) Get Distinct numbers \n" +
                   "\t(0) Quit \n");
           
           System.out.print("Enter choice: ");
           String choose = input.next();
           
           char choice = choose.charAt(0);
           
           switch(choice)
           {
                case '0': quit = true;
                   break;
                case '1': 
                   userInput = getInput();
                   distinctNumbers = getDistinct(userInput);
                   int[] numArray = createArray(distinctNumbers);
                   System.out.println("The number of distinct numbers is: " + numArray.length);
                   System.out.print("The distinct numbers are: ");
                   for(int number : numArray)
                   {
                       System.out.print(number + " ");
                   }
                   System.out.println("");
                   break;
                default: System.out.println("Not valid - Choose again!");
           }
           
        } while(quit == false);                   
    }
    
    private static boolean checkDigit(String numbers)
    {
        //Variable Declaration
        boolean isValid = false;
        int index = 0;
        
        do
        {
            if(numbers.charAt(index) >= '0' && numbers.charAt(index) <= '9')
            {
                isValid = true;
            }
            else
            {
                isValid = false;
            }
            index++;
        } while(isValid == false && index < numbers.length());
        
        return isValid;
    }    
    
    
    private static String getDistinct(String numbers)
    {
        // Variable declaration
        String distinctNumbers = "";
        boolean isDistinct = true;
        for(int index = 0; index < numbers.length(); index++)
        {
            
            for(int index2 = 0; index2 < distinctNumbers.length(); index2++)
            {
                if(numbers.charAt(index) == distinctNumbers.charAt(index2))
                {
                    isDistinct = false;
                }

            }
            if(isDistinct == true)
            {
                distinctNumbers = distinctNumbers + numbers.charAt(index);
            }
            isDistinct = true;
        }
        
        return distinctNumbers;
    }

    
    private static int[] createArray(String numbers)
    {
        // variable declaration
        
        // Create array based on string length
        int[] array = new int[(numbers.length())];
        
        for(int index = 0; index < array.length; index++)
        {
            array[index] = numbers.charAt(index)- 48;

        }   
        
        return array;
    }
    
    private static String getInput()
    {
        //Variable Declaration
        String userInput = "";
        boolean isValid = false;
        
        // Get keyboard input
        Scanner input = new Scanner(System.in);
        
        do
        {
            System.out.print("Enter 10 numbers: ");
            userInput = input.next();
            
            if(getLength(userInput) > 10)
            {
                isValid = false;
                System.out.println("Please enter 10 digits!");
            }
            else
            {
                isValid = checkDigit(userInput);
                if(isValid == false)
                {
                    System.out.println("Please enter 10 digits!");
                }
                    
            }
            
        } while (isValid == false);
               
        return userInput;
    }
    
    private static int getLength(String numbers)
    {
        int length = numbers.length();
        
        return length;
    }
}

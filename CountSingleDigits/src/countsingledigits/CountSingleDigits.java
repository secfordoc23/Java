//Program: CountSingledigits
//This: countsingledigits.java
//Date: 10/26/2015
//Author: Jason Welch
//Purpose: Display the count of 100 Random numbers from 0 to 9

package countsingledigits;

import java.util.Random;
import java.util.Scanner;

public class CountSingleDigits 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        boolean quit = false;
        
        
        // Get Keyboard input
        Scanner input = new Scanner(System.in);
        
        do
        {
           System.out.print("Choose:\n " +
                   "\t(1) Count 100 random Numbers from 0 to 9 \n" +
                   "\t(0) Quit \n");
           
           System.out.print("Enter choice: ");
           String choose = input.next();
           
           char choice = choose.charAt(0);
           
           switch(choice)
           {
                case '0': quit = true;
                   break;
                case '1': 
                   int[] counts = countRandomNumbers();
                   System.out.println("The random number counts are: ");
                   for(int index = 0; index < counts.length; index++)
                   {
                       System.out.println(index + ": " + counts[index]);
                   }
                   System.out.println("");                   
                   break;
                default: System.out.println("Not valid - Choose again!");
           }
           
        } while(quit == false);         
        
    }
    
    private static int[] countRandomNumbers()
    {
        // Variable Declaration
        int digit = 0;
        
        // create array
        int[] numArray = new int[10];
        
        // Generate Random Numbers
        Random rand = new Random();
        
        for(int index = 0; index <=100; index++)
        {
            digit = rand.nextInt(10);
            switch(digit)
            {
                case 0: numArray[0] += 1;
                    break;
                case 1: numArray[1] += 1;
                    break;
                case 2: numArray[2] += 1;
                    break;
                case 3: numArray[3] += 1;
                    break;
                case 4: numArray[4] += 1;
                    break;
                case 5: numArray[5] += 1;
                    break;
                case 6: numArray[6] += 1;
                    break;
                case 7: numArray[7] += 1;
                    break;
                case 8: numArray[8] += 1;
                    break;
                case 9: numArray[9] += 1;
                    break;
            }
        }
        
        return numArray;
        
    }

}

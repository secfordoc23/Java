//Program: LargestIntegerApp
//This: largestintegerapp.java
//Date: 4/3/2016
//Author: Jason Welch
//Purpose: Find the Largest Integer in a set of Given Integers

package largestintegerapp; 

import java.util.Scanner;

 
public class LargestIntegerApp 
{ 
    
    //===========  main ==========================
    public static void main(String[] args) 
    { 
        // Variable Declaration
        boolean quit = false;
        char choice;
        //int index = 0;
        int[] intList;
        
        String[] choices = {"Quit", "Run Program"};
        
        
        Menu myMenu = new Menu(choices);
        
        do
        {
            System.out.println("**** Find Largest Integer in an Array of a given size ****\n");
            choice = myMenu.getChoice(); 
            switch(choice)
            {
                case '0': quit = true;
                   break;
                case '1': intList = createArray();
                    System.out.printf("The largest Integer in the Array is %d.\n",findLargest(intList, 0, 0));
                   break;                    
            }
        }while(quit == false); 
    }
    
    //===================== createArray ====================================
    private static int[] createArray()
    {
        int arrayLength = 0;
        int[] intList;
        Scanner userInput = new Scanner(System.in);
       
        System.out.print("How Many Integers do you want to Sort?: ");
        while(!userInput.hasNextInt())
        {
           System.out.print("Please enter a valid number!: ");
           userInput.next();        
        }

        arrayLength = userInput.nextInt();
        intList = new int[arrayLength];

        for(int index = 0; index < arrayLength; index++)
        {
            System.out.printf("Enter number %d out of %d: ", index, arrayLength);
            while(!userInput.hasNextInt())
            {
               System.out.print("Please enter a valid number!: ");
               userInput.next();        
            }
            intList[index] = userInput.nextInt();
        }
        
        return intList;
    }
    
    //===================== findLargest ====================================
    private static int findLargest(int[] intList, int index, int max)
    {        
        if(index == intList.length)
        {
            return max;
        }
        else
        {
            if(intList[index] > max)
            {
                max = intList[index];
            }
            return findLargest(intList,index + 1, max);
        }       
    }

} 
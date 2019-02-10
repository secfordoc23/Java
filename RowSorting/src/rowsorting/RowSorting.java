//Program: RowSorting
//This: rowsorting.java
//Date: 11/10/2015
//Author: Jason Welch
//Purpose: Display a sorted 3 by 3 array

package rowsorting;

import java.util.Arrays;
import java.util.Scanner;

public class RowSorting 
{
    
    private static double[][] twoDimArray = new double[3][3];
    
    //===========  main ==========================
    public static void main(String[] args) 
    {
        menu();
                
    }

    //===========  menu ==========================
    private static void menu()
    {
       // Variable Declaration
       boolean quit = false;
       
       // Keyboard input
       Scanner getInput = new Scanner(System.in);
      
       do
       {
           System.out.print("Choose:\n " +
                   "\t(1) Enter a 3 by 3 Matrix row by row. \n" +
                   "\t(0) Quit \n");
           
           System.out.print("Enter choice: ");
           String choose = getInput.next();
           
           char choice = choose.charAt(0);
           
           switch(choice)
           {
               case '0': quit = true;
                   break;
               case '1': 
                   optionOne();
                   break;

               default: System.out.println("Not valid - Choose again!");
           }
                   
       } while(quit == false);
    }
    
    //===========  optionOne ==========================
    private static void optionOne()
    {
        
        for(int index = 0; index < 3; index++)
        {
            String[] numbers = getNumbers(index);
            if(validateNumbers(numbers) == false)
            {
                System.out.println("Please enter Numbers for all elements in the array!");
                index--;
            }
            else
            {
                Arrays.sort(numbers);
                updateArray(numbers, index);
            }
        }
        displayRow();
    }
    
    //===========  validateNumbers ==========================
    private static boolean validateNumbers(String[] numbers)
    {
        boolean isValid = true;
        String number;
        
        for(int index = 0; index < numbers.length; index++)
        {
            number = numbers[index];
            if(number.length() == 1)
            {
                if(Character.isDigit(number.charAt(0)) == false)
                {
                    isValid = false;
                }

            }
            else
            {
                for(int index2 = 0; index2 < number.length(); index2++)
                {
                    if(Character.isDigit(number.charAt(index2)) == false && number.charAt(index2) != '.')
                    {
                        isValid = false;
                    }
                }
            }
        }
        
        return isValid;
    }
    
    //===========  getNumbers ==========================
    private static String[] getNumbers(int count)
    {
        String[] numArray = new String[3];
        
        // Keyboard input
        Scanner input = new Scanner(System.in);
        
        for(int index = 0; index < numArray.length; index++)
        {
            System.out.printf("Enter element %d for row %d: ", index, count);
            numArray[index] = input.next();
            
        }
        
        return numArray;
    }
    
    //===========  updateArray ==========================
    private static void updateArray(String[] numbers, int row)
    {
        double[] sortArray = new double[3];
        
        for(int index = 0; index < numbers.length; index++)
        {
            sortArray[index] = Double.parseDouble(numbers[index]);
        }
        
        Arrays.sort(sortArray);
        
        for(int index2 = 0; index2 < numbers.length; index2++)
        {
            twoDimArray[row][index2] = sortArray[index2];
        }
    }
    
    //===========  displayRow ==========================
    private static void displayRow()
    {
        System.out.print("Row Array is sorted is ");
        for(int index = 0; index < twoDimArray.length; index++)
        {
            System.out.print(twoDimArray[index][0] + " " + twoDimArray[index][1] + " " + twoDimArray[index][2] + "\n");

        }
        
    }
}

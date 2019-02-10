//Program: SumColumnOfElements
//This: sumcolumnofelements.java
//Date: 11/
//Author: Jason Welch
//Purpose: 

package sumcolumnofelements;

import java.util.Scanner;

public class SumColumnOfElements 
{
    private static double[][] twoDimArray = new double[3][4];
    
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Call Program Menu 
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
                   "\t(1) Enter a 3 by 4 Matrix row by row. \n" +
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
                updateArray(numbers, index);
            }
        }
        sumColumns();
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
        String[] numArray = new String[4];
        
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
        for(int index = 0; index < numbers.length; index++)
        {
            twoDimArray[row][index] = Double.parseDouble(numbers[index]);
        }
        
    }
    
    //===========  sumColumns ==========================
    private static void sumColumns()
    {
        double[] columnTotal = new double[4];
        
        for(int column = 0; column < 4; column++)
        {
            for(int row = 0; row < 3; row++)
            {
                columnTotal[column] += twoDimArray[row][column];
            }
        }
        
        for(int index = 0; index < columnTotal.length; index++)
        {       
            System.out.printf("Sum of elements at column %d is %.2f: \n", index, columnTotal[index]);
        }
    }
}

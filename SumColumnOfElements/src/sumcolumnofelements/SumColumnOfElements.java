//Program: SumColumnOfElements
//This: sumcolumnofelements.java
//Date: 11/
//Author: Jason Welch
//Purpose: 

package sumcolumnofelements;

import java.util.Scanner;

public class SumColumnOfElements 
{
    
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // TODO code application logic here
    }
    
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
    
    private static String[] getNumbers(int count)
    {
        String[] numArray = new String[4];
        
        // Keyboard input
        Scanner input = new Scanner(System.in);
        
        for(int index = 1; index <= 5; index++)
        {
            System.out.printf("Enter digit %d for row %d: ", index, count);
            numArray[index - 1] = input.next();
            
        }
        
        return numArray;
    }
}

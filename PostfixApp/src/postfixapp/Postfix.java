//Program: postfixapp
//This: Postfix.java
//Date: 4/9/2016
//Author: Jason Welch
//Purpose: A class to calculate Postfix notation

package postfixapp;

import java.util.Scanner;


public class Postfix 
{
    private Scanner userInput;
    
    //=============== Default Constructor =================
    public Postfix()
    {
        userInput = new Scanner(System.in);
    }
    
    public String[] getPostfix()
    {
        String postfixStatement;
        String[] statementBreakdown;
        boolean isValid = false;
        do
        {
            System.out.print("Enter a Postfix Expression: ");
            postfixStatement = userInput.nextLine();

            statementBreakdown = postfixStatement.split(" ");
            for(int index = 0; index < statementBreakdown.length; index++)
            {
                isValid = validateData(statementBreakdown[index]);
                if(isValid == false)
                {
                    break;
                }
            }
            if(statementBreakdown[statementBreakdown.length - 1].length() > 1 
                    || statementBreakdown[statementBreakdown.length - 1].charAt(0) != Expression.EQUALS.valueOf())
            {
                isValid = false;                
            }
        } while(isValid == false);
            
        return statementBreakdown;
    }
    
    private boolean validateData(String element)
    {
        char[] charArray = element.toCharArray();
        //boolean isValid = false;
        
        if(charArray.length == 1)
        {
            if(Character.isDigit(charArray[0]))
            {
                return true;
            }
            else if(charArray[0] == Expression.ADD.valueOf() || charArray[0] == Expression.SUBTRACT.valueOf() 
                    || charArray[0] == Expression.MULTIPLY.valueOf() || charArray[0] == Expression.DIVID.valueOf() || charArray[0] == Expression.EQUALS.valueOf())
            {
                return true;
            }
            else
            {
                return false;
            }
        }    
        else
        {
            for(int index = 0; index < charArray.length; index++)
            {
                if(!Character.isDigit(charArray[index]))
                {
                    return false;
                }
                else if(!(charArray[index] == Expression.ADD.valueOf() || charArray[index] == Expression.SUBTRACT.valueOf() 
                        || charArray[index] == Expression.MULTIPLY.valueOf() || charArray[index] == Expression.DIVID.valueOf() || charArray[index] == Expression.EQUALS.valueOf() 
                        || charArray[index] == Expression.DECIMAL.valueOf()))
                {
                    return false;
                }                
            }
            return true;
        }
                      
    }

    public double calculatePostfix(String[] arrayToConvert)
    {
        double result = convertToNumber(arrayToConvert[0]), nextNumber = 0.0;
        int index = 1;
        
        do
        {
            
            index++;
        } while(arrayToConvert[index].charAt(0) != Expression.EQUALS.valueOf());

        return result;
    }

    private double convertToNumber(String element)
    {
        return Double.parseDouble(element);
    }
}

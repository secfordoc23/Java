//Program: ElementaryMath
//This: elementarymath.java
//Date: 9/29/2015
//Author: Jason Welch
//Purpose: To Create Addition Subtraction Multiplicaton Division math problems based on 
//      two inputed numbers from the user and the type of math problem selected.

package elementarymath;

import java.util.Scanner;

public class ElementaryMath 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        int selection = 0;
        int count = 0;
        double firstNum = 0;
        double secondNum = 0;
        double answer = 0;
        String mathProblem = "";
        String userCont = "";
        char playAgain;
        
        // Scanner
        Scanner input = new Scanner(System.in);
        
        do
        {
            System.out.print("Enter two numbers for the math problem:");
            firstNum = input.nextDouble();
            secondNum = input.nextDouble();
            
            System.out.println("Enter the number for the type of Math problem you want to create: ");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.print("Enter Selection: ");
            selection = input.nextInt();
            
            switch(selection)
            {
                case 1: answer = firstNum + secondNum;
                    mathProblem = firstNum + " + " + secondNum + " = " + answer;
                    break;
                case 2: answer = firstNum - secondNum;
                    mathProblem = firstNum + " - " + secondNum + " = " + answer;
                    break;
                case 3: answer = firstNum * secondNum;
                    mathProblem = firstNum + " * " + secondNum + " = " + answer;
                    break;
                case 4: answer = firstNum / secondNum;
                    mathProblem = firstNum + " / " + secondNum + " = " + answer;
                    break;
                
            }  // End switch          
            
            System.out.println("Math Problem: " + mathProblem);
            
            System.out.print("Do you want to run again(y/n): ");
            userCont = input.next();
            playAgain = userCont.charAt(0);
            
            count++;
        }while (playAgain == 'y' || playAgain == 'y');

        System.out.println("The Program ran: " + count + " times.");
    } // end Main

}

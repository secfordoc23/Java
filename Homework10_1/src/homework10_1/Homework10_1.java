//Program: Homework10_1
//This: Homework10_1.java
//Date: 4/2/2017
//Author: Jason Welch
//Purpose: Driver to test the GenericStack Class 

package homework10_1;

import java.util.LinkedList;
import java.util.Scanner;

public class Homework10_1 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        boolean quit = false;        
        char choice;
        GenericStack<String> testStack = new GenericStack<>();
        Scanner input = new Scanner(System.in);
        
        String[] choices = {"Quit", "POP", "PEEK", "PUSH", "REMOVE(n) elements"};
        
        Menu myMenu = new Menu(choices);
        
        do
        {
            choice = myMenu.getChoice(); 
            
            switch(choice)
            {
                case '0': quit = true;
                   break;
                case '1': // POP
                    System.out.println(testStack.pop());
                    break;
                case '2': // PEEK
                    System.out.println(testStack.peek());
                    break;
                case '3': // PUSH
                    System.out.print("Enter a string into the stack: ");
                    String userInput = input.nextLine();
                    testStack.push(userInput);
                    break;                    
                case '4': // REMOVE(n)                         
                    System.out.print("Enter a number of elements to remove from the stack: ");
                    int numToRemove = input.nextInt();
                    testStack.remove(numToRemove);
                    break;            
            
            
            }
                        
        }while(quit == false); 
    }

}

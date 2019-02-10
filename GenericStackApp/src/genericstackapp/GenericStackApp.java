//Program: GenericStackApp
//This: GenericStackApp.java
//Date: 2/21/2016
//Author: Jason Welch
//Purpose: Test the Generic Stack Class

package genericstackapp;

import java.util.Scanner;

public class GenericStackApp 
{
    private static GenericStack<String> myTest = new GenericStack();
    
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        boolean quit = false;        
        char choice;
        String element;
        
        // Keyboard Input
        Scanner userInput = new Scanner(System.in);
        
        String[] choices = {"Quit", "Push", "Pop", "Top", "toString"};
        
        Menu myMenu = new Menu(choices);
        
        do
        {
            System.out.println("*** Test the Generic Stack Class using Strings ***");
            choice = myMenu.getChoice(); 
            
            switch(choice)
            {
                case '0': quit = true;
                   break;
                //Push    
                case '1': 
                    System.out.print("Enter a String to add an element to the stack: ");
                    element = userInput.next();
                    myTest.push(element);
                    break;
                //Pop
                case '2':
                    if(!myTest.isEmpty())
                    {
                        System.out.println("Results of Pop: ");
                        myTest.pop();
                        System.out.println(myTest.toString());
                    }
                    else
                    {
                        System.out.println("Stack is empty. Please add an element!");
                    }
                    break;
                //Top
                case '3': 
                    if(!myTest.isEmpty())
                    {
                        System.out.println("Results of Top: " + myTest.top());

                    }
                    else
                    {
                        System.out.println("Stack is empty. Please add an element!");
                    }
                    break;
                //toString
                case '4': System.out.println(myTest.toString());
                    break;            
            }
                        
        }while(quit == false);        
    }

}

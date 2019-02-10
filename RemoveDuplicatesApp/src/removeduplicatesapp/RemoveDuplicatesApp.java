//Program: RemoveDuplicatesApp
//This: RemoveDuplicatesApp.java
//Date: 2/21/2016
//Author: Jason Welch
//Purpose: Test for the 

package removeduplicatesapp;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicatesApp 
{
    private static ArrayList<String> testList = new ArrayList();
    
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        boolean quit = false;        
        char choice;
        String element;
        
        //Keyboard input
        Scanner userInput = new Scanner(System.in);
        
        String[] choices = {"Quit", "Add Element to Array List", "Test Remove Duplucates Method", "Display ArrayList"};
        
        Menu myMenu = new Menu(choices);
        
        do
        {
            System.out.println("*** Test Application to remove Dublicates from a String ArrayList ***");
            choice = myMenu.getChoice(); 
            
            switch(choice)
            {
                case '0': quit = true;
                   break;
                // Add to ArrayList
                case '1':
                    System.out.print("Enter a String to add to the ArrayList: ");
                    element = userInput.next();
                    testList.add(element);
                    break;
                //Remove Duplicates    
                case '2':
                    CheckDuplicates<String> newTest = new CheckDuplicates();
                    testList = newTest.removeDuplicates(testList);
                    break;
                // Display ArrayList    
                case '3': displayList();
                    break;
            }
           
        }while(quit == false); 
    }

    //============== displayList ========================
    private static void displayList()
    {
        for(String element : testList)
        {
            System.out.println(element);
        }
    }
    

} // end Class

//Program: StringBagApp
//This: StringBagApp.java
//Date: 3/13/2016
//Author: Jason Welch
//Purpose: A class the test the StringBag Class

package stringbagapp;

import java.util.Scanner;

public class StringBagApp 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        boolean quit = false;        
        char choice;
        String item, searchItem, name;
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.print("Enter the name of the String Bag: ");
        name = userInput.next();
        
        StringBag myBag = new StringBag(name);
        
        String[] choices = {"Quit", "Add Item", "Check to see if the bag is Full", "Check Size of Bag",
            "See if Item is in the Bag", "Empty Bag", "Get Name of Bag", "Return Items in Bag"};
        
        Menu myMenu = new Menu(choices);
        
        do
        {
            choice = myMenu.getChoice(); 
            
            switch(choice)
            {
                case '0': quit = true;
                   break;
                case '1': System.out.print("Enter the item to Add to bag: ");
                    item = userInput.next(); 
                    myBag.insert(item);
                    break;
                case '2': System.out.println("Is the bag full: " + myBag.isFull());
                    break;
                case '3': System.out.println("Bag Size: " + myBag.size());
                    break;
                case '4': System.out.print("Enter an item to Search for: ");
                    searchItem = userInput.next(); 
                    myBag.insert(searchItem);
                    System.out.printf("%s is in the bag: %b\n", searchItem, myBag.contains(searchItem));
                    break;
                case '5': myBag.clear();
                    System.out.println("Bag has been emptied!");
                    break;
                case '6': System.out.printf("The bag name is %s.\n", myBag.getName());
                    break;
                case '7': System.out.println("Listing Contents of Bag....");
                    System.out.println(myBag.toString());
                    break;                    
            }
                        
        }while(quit == false); 
    }

}

//Program: Portfolio
//This: menu.java
//Date: 11/17/2015
//Author: Jason Welch
//Purpose: Class for creating a menu

package portfolio;

import java.util.Scanner;

//================ Menu ==========================
public class Menu 
{
    
    // Array Declaration
    private String[] choices;
    
    //================ Menu  w/ param ==========================
    public Menu(String[] choices)
    {
	
	this.choices = choices;
    }
    
    //================ getChoice ==========================
    public char getChoice()
    {
	displayMenu();
        return validateChoice();
        
    }
    
    //================ displayMenu ==========================
    private void displayMenu()
    {
        System.out.println("Choose: ");
        // walk through the array and display each choice with a number
	for (int i = 0; i < this.choices.length; i++)
        {
            System.out.println("\t" + i + ".  " + this.choices[i]);
        }
    }
    
    //================ buildChoices ==========================
    private String buildChoices()
    {
        String numbers = "";
	for (int i = 0; i < this.choices.length; i++)
        {    
            numbers += i;
        }
        return numbers;
    }
    
    //================ validateChoice ==========================
    private char validateChoice()
    {
	String input;
	char choice = ' ';
	Scanner scan = new Scanner(System.in);
	
        String numbers = buildChoices();

	System.out.print("\n\nEnter your choice as a digit 0 - "
            + (this.choices.length - 1) + ": ");
	
        // check that only single characters are entered
	input = scan.nextLine();
	if (input.length() == 1)
	{
            choice = input.charAt(0);
	}

	// repeat request if entry not valid
	while (numbers.indexOf(choice) == -1)
	{
            System.out.println();
            System.out.print("\n"
		+ "Input not recognized. Please enter a digit 0 - "
		+ (this.choices.length - 1) + ": ");	
            input = scan.nextLine();
            
            if (input.length() == 1)
            {
		choice = input.charAt(0);
            }
            
            System.out.println();
	}
        
	return choice;
    }
}

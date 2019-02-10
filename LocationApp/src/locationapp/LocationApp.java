//Program: LocationApp
//This: locationapp.java
//Date: 2/8/2016
//Author: Jason Welch
//Purpose: Test the location Class

package locationapp;

import java.util.Scanner;

public class LocationApp 
{
    private static double[][] twoDimArray;
    
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Call the Menu Method
        menu();
    }
    
    //============= menu ===================
    private static void menu()
    {
        // Variable Declaration
        boolean quit = false;
        char choice;
        
        String[] choices = {"Quit", "Test Location Class"};
        
        // Call the Menu Class
        Menu myMenu = new Menu(choices);
        
        do
        {   

            choice = myMenu.getChoice(); 
            switch(choice)
            {
                case '0': quit = true;
                   break;
                case '1': 
                   optionOne();
                   break;
               
            }
            
        }while(quit == false);
    }
 
    //============= optionOne ===================
    private static void optionOne()
    {
        //Variable Declaration
        int row, column;
        
        //Keyboard input
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter Dimensions of a 2 dimensional array: ");        
        
        System.out.print("Enter row: ");
        while(!input.hasNextInt())
        {
            System.out.println("Please enter a Valid Row!: ");
            input.next();
        }
        row = input.nextInt();

        System.out.print("Enter Columns: ");
        while(!input.hasNextInt())
        {
            System.out.println("Please enter a Valid Column!: ");
            input.next();                
        }
        column = input.nextInt();
        
        // Call the CreateArray Class
        CreateArray array = new CreateArray(row, column);
        
        twoDimArray = array.fillArray();
        
        // Call the Location Class
        Location test = new Location();
        
        test.locateLargest(twoDimArray);
        
        //Display Array
        array.displayArray();
        
        // Display information from Location Class
        System.out.println(test.toString());
        
    }

    //============= validateNumber ===================
    private static boolean validateNumber(String number)
    {
        

        if(number.length() == 1)
        {
            if(Character.isDigit(number.charAt(0)) == false)
            {
                System.out.println("Please Enter an Integer!");
                return false;
            }

        }
        
        else
        {
            for(int index2 = 0; index2 < number.length(); index2++)
            {
                if(Character.isDigit(number.charAt(index2)) == false)
                {
                    System.out.println("Please Enter an Integer!");
                    return false;
                }
            }
        }
        
        return true;
    }    
}

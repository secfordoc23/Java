//Program: FanApp
//This: fanapp.java
//Date: 11/17/2015
//Author: Jason Welch
//Purpose: Test Application for the Fan Class

package fanapp;

import java.util.Scanner;

public class FanApp 
{
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
        
        String[] choices = {"Quit", "Test 1", "Test 2", "Custom Fan"};
        
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
                case '2':
                    optionTwo();
                   break;
                case '3':
                    optionThree();
                    break;
               
            }
        }while(quit == false);
    }
    
    //============= optionOne ===================
    private static void optionOne()
    {
        Fan testOne = new Fan(3, true, 10, "yellow");
        System.out.println(testOne.toString());
    }
    
    //============= optionTwo ===================
    private static void optionTwo()
    {
        Fan testTwo = new Fan(2,false, 5, "blue");
        System.out.println(testTwo.toString());
    }
    
    //============= optionThree ===================
    private static void optionThree()
    {
        // Variable Declaration
        int speed, statusChoice;
        boolean status, isValid;
        double radius;
        String color, inputRadius;
        
        // Array Declaration
        String[] numbers = new String[4];
        String[] speeds = {"Slow", "Medium", "Fast"};
        String[] onOff = {"On", "Off"};
        
        // Call the Menu Class
        Menu speedMenu = new Menu(speeds);
        Menu statusMenu = new Menu(onOff);

        // Keyboard input
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter Fan speed:");
        speed = speedMenu.getChoice();
        
        System.out.println("Enter Fan status:");
        statusChoice = statusMenu.getChoice();
        
        if(statusChoice == 1)
        {
            status = true;
        }
        
        else
        {
            status = false;
        }
        
        System.out.print("Enter the Fan color:");
        color = input.next();
        
        do
        {
            System.out.print("Enter the Fan radius:");
            inputRadius = input.next();            
            
            isValid = validateNumber(inputRadius);
            
        } while (isValid == false);
        
        radius = Double.parseDouble(inputRadius);
        
        Fan customFan = new Fan((speed + 1), status, radius, color);
        System.out.println(customFan.toString());
        
    }
    
    //============= validateNumber ===================
    private static boolean validateNumber(String number)
    {
        

        if(number.length() == 1)
        {
            if(Character.isDigit(number.charAt(0)) == false)
            {
                System.out.println("Please Enter a Number!");
                return false;
            }

        }
        
        else
        {
            for(int index2 = 0; index2 < number.length(); index2++)
            {
                if(Character.isDigit(number.charAt(index2)) == false && number.charAt(index2) != '.')
                {
                    System.out.println("Please Enter a Number!");
                    return false;
                }
            }
        }
        
        return true;
    }
}

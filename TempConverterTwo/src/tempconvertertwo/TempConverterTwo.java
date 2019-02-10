//Program: TempConverterTwo
//This: tempconvertertwo.java
//Date: 10/19/2015
//Author: Jason Welch
//Purpose: Display the converted temp from Kelvin, Celsius, or Fahrenheit to either 
//  Kelvin, Celsius, or Fahrenheit

package tempconvertertwo;

import java.util.Scanner;

public class TempConverterTwo 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        int enteredTemp = 0;
        char fromScale = 0;
        char choice;
        boolean quit = false;
        
        
        // Scanner
        Scanner input = new Scanner(System.in);
        
        do
        {
           choice = startMenu();
           
           switch(choice)
           {
               case '0': quit = true;
                   break;
               case '1':
                   System.out.print("Enter in a tempurature: ");
                   enteredTemp = input.nextInt();
                   System.out.println("Select the scale the tempurature is in.");
                   fromScale = scaleMenu();
                   break;
               case '2':
                   process(enteredTemp,fromScale);
                   break;
               default: System.out.println("Not valid - Choose again!");
           }
           
        } while(quit == false);
    }
    
    // =============== startMenu ===============
    private static char startMenu()
    {
        // Variable Declaration
        char choice;
        String choose;
        
        // Scanner
        Scanner input = new Scanner(System.in);
            
        System.out.print("Choose:\n " +
            "\t(1) Enter a temperature to convert \n" +
            "\t(2) Process Tempurature Convertion\n" +
            "\t(0) Quit \n");
           
        System.out.print("Enter choice: ");
        choose = input.next();
           
        choice = choose.charAt(0);
                    
        return choice;
    }
    
    // ================ scaleMenu ================
    private static char scaleMenu()
    {
        // Variable Declaration
        char choice;
        String choose;
        boolean isValid = false;
        
        // Scanner
        Scanner input = new Scanner(System.in);
        
        do
        {
            System.out.print("Choose:\n " +
                "\t(K) for Kelvin \n" +
                "\t(C) for celcius \n" +
                "\t(F) for Fahrenheit \n");
           
            System.out.print("Enter choice: ");
            choose = input.next();
           
            choice = choose.toLowerCase().charAt(0);
        
            if(choice == 'k' || choice == 'c' || choice == 'f')
            {
                isValid = true;
            }
            else
            {
                System.out.println("Not valid - Choose again!");
                isValid = false;
            }
        } while (isValid == false);
        
        return choice;
    }
    
    // ================ process ========================
    private static void process(int temp, char fromScale)
    {
        // variable declaration
        char toScale;
        System.out.println("Select the scale you want to convert to.");
        toScale = scaleMenu();
        if(toScale == '0' && temp == 0)
        {
            System.out.println("Please enter in a Tempurature first!");
        }
        else if(toScale == 'c')
        {
            convertToCelsius(temp, fromScale);
        }
        else if(toScale == 'k')
        {
            convertToKelvin(temp, fromScale);
        }
        else
        {
            convertToFahrenheit(temp, fromScale);
        }
        
    }
    // ================ convertToKelvin ================
    private static void convertToKelvin(int temp, char fromScale)
    {
        // Variable Declaration
        double convertedTemp = 0.0;
        
        if(fromScale == 'c')
        {
            convertedTemp = temp + 273.15;
            System.out.println("The Converted temp is: " + convertedTemp);
        }
        else if(fromScale == 'f')
        {
            convertedTemp = (temp - 32) * (5.0/9.0) + 273.15;
            System.out.println("The Converted temp is: " + convertedTemp);
        }
        else
        {
            System.out.println("No Conversion needed tempurature is: " + temp);        
        }       
        
    }
    
    // ================ convertToCelsius ================
    private static void convertToCelsius(int temp, char fromScale)
    {
        // Variable Declaration
        double convertedTemp = 0.0;
        
        if(fromScale == 'k')
        {
            convertedTemp = temp - 273.15;
            System.out.println("The Converted temp is: " + convertedTemp);
        }
        else if(fromScale == 'f')
        {
            convertedTemp = 5.0/9.0 * (temp -32);
            System.out.println("The Converted temp is: " + convertedTemp);
        }
        else
        {
            System.out.println("No Conversion needed tempurature is: " + temp); 
        }       
        
    } 
    
    // ================ convertToFahrenheit ================
    private static void convertToFahrenheit(int temp, char fromScale)
    {
        // Variable Declaration
        double convertedTemp = 0.0;
        
        if(fromScale == 'k')
        {
            convertedTemp =(temp - 273.15) * 1.8 + 32;
            System.out.println("The Converted temp is: " + convertedTemp);
        }
        else if(fromScale == 'c')
        {
            convertedTemp = (1.8 * temp) + 32;
            System.out.println("The Converted temp is: " + convertedTemp);
        }
        else
        {
            System.out.println("No Conversion needed tempurature is: " + temp); 
        }       
        
    }     
}

/*Program: Test Triangle Class
*This: TestTriangleClass.java
*Date:2/15/16
*Author: Kyle Bloyd, Jason Welch, Brandon Onken
*Purpose: Prompts the user to enter information for a triangle then instantiates
*         a triangle object with the given information and displays the info
*           
*/
package testtriangleclass;
import java.util.Scanner;

public class TestTriangleClass 
{
    // Keyboard input
    private static Scanner input = new Scanner(System.in);    
    
    //private static Triangle triangle = new Triangle(); //instantiates a triangle
                                       
    //=====================main()==================================================
    public static void main(String[] args) 
    {
        //Variable Declaration
        boolean quit = false;        
        char choice;
        
        // Arrays
        String[] options = {"Quit", "Default Triangle", "Custom Triangle"};
        
        Menu mainMenu = new Menu(options);
        
        do {
           //main menu
           choice = mainMenu.getChoice(); 
           switch(choice) 
           {
               case '0': quit = true;
                   break;
               // Default Triangle    
               case '1': Triangle defaultTriangle = new Triangle();
                   System.out.println(defaultTriangle.toString());
                   break;
               // Custom Triangle
               case '2': Triangle customTriangle;
                   String color = selectColor(); //prompt user to select color
                   boolean filled = selectFilled(); //prompt user to select filled or not                   
                   double[] triangleSides = inputSides();
                   customTriangle = new Triangle(color,filled, triangleSides[0], triangleSides[1], triangleSides[2]);
                   while(customTriangle.triangleSumTheorem() == false)
                   {
                       System.out.println("Please enter sides of a triangle whose sum of 2 sides is greater than the other!");
                       triangleSides = inputSides();
                       customTriangle.setSide1(triangleSides[0]);
                       customTriangle.setSide1(triangleSides[1]);
                       customTriangle.setSide1(triangleSides[2]);
                   }
                   
                   System.out.println(customTriangle.toString());
                   break;

           }                    
        }while(quit == false);     
    }
    
    
    //======================== inputSides =======================================   
    private static double[] inputSides()
    {
        double[] triangleSides = new double[3];
        
        for(int index = 1; index < 4; index++)
        {
            do
            {
                System.out.printf("Enter the length(a number > 0) of side %d: ", index);
                while(!input.hasNextDouble())
                {
                    System.out.printf("Please enter a valid number for side %d: \n", index);
                    input.next();
                }
                triangleSides[(index - 1)] = input.nextDouble();
            } while(triangleSides[(index - 1)] <= 0);
        }
        
        return triangleSides;
    }
    
    //========================= selectColor ===================================
    private static String selectColor()
    {
        //boolean quit = false;
        char colorChoice;
        String color;
        
        String[] colorOptions = {"Red", "Orange", "Yellow", "Green", "Blue", "Purple", "White"};
        
        Menu colorMenu = new Menu(colorOptions);
        
        colorChoice = colorMenu.getChoice();
        
        color = Colors.values()[(colorChoice - '0')].name();
        return color;

    }
    
    //======================== selectFilled ====================================
    private static boolean selectFilled()
    {
        // Variable Declaration
        char choice;
        boolean filled = false;
        String[] fillOptions = {"Filled", "Not Filled"};
       
        Menu filledMenu = new Menu(fillOptions);
        
        choice = filledMenu.getChoice();
        switch(choice) 
        {
           case '0': filled = false;
               break;
           case '1': filled = true;
               break;
        }
        return filled;
    }
}

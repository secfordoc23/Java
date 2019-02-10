//Program: Circle2DApp
//This: circle2dapp.java
//Date: 2/15/2016
//Author: Jason Welch
//Purpose: Front end application to test the Circle2D Class

package circle2dapp; 

import java.util.Scanner;

 
public class Circle2DApp 
{ 
    private static Scanner userInput = new Scanner(System.in);
    private static Circle2D[] myCircle;
    
    //===========  main ==========================
    public static void main(String[] args) 
    { 
        // Variable Declaration
        boolean quit = false;
        
        char choice;
        double x,y;
        
        String[] choices = {"Quit", "Get Area", "Get Perimeter", "Check if X, Y coordinates are in Circle", "Check if a circle is in a Circle", "Check if a Circle Overlaps a Circle"};
        
        Menu myMenu = new Menu(choices);
        
        do
        {
            myCircle = new Circle2D[1];            
            
            choice = myMenu.getChoice(); 
            
            switch(choice)
            {
                case '0': quit = true;
                   break;
                // Area
                case '1': 
                    createCircle(0);
                    myCircle[0].getArea();
                   break;
                //Perimeter    
                case '2':
                    createCircle(0);
                    myCircle[0].getPerimeter();
                   break;
                //Check x,y    
                case '3':                     
                    createCircle(0);
                    System.out.println("Enter the Center coordinates for the Custom Circle: ");
                    System.out.print("Enter the a value for x: ");
                    while(!userInput.hasNextDouble())
                    {
                       System.out.println("Please enter a number!: ");
                       userInput.next();
                    }
                    x = userInput.nextDouble();
                    System.out.print("Enter the a value for y: ");
                    while(!userInput.hasNextDouble())
                    {
                       System.out.println("Please enter a number!: ");
                       userInput.next();
                    }
                    y = userInput.nextDouble();
                    myCircle[0].contains(x, y);
                   break;
                // Check Circle    
                case '4':
                    System.out.println("*** Circle One ***");
                    createCircle(0);
                    System.out.println("*** Circle Two ***");
                    createCircle(1);
                    System.out.println("Circle One contains Circle Two: " + myCircle[0].contains(myCircle[1]));
                   break;                    
                // Check Overlap
                case '5': 
                    System.out.println("*** Circle One ***");
                    createCircle(0);
                    System.out.println("*** Circle Two ***");
                    createCircle(1);
                    System.out.println("Circle One overlaps Circle Two: " + myCircle[0].overlaps(myCircle[1]));
                   break;                    
            
            }
        }while(quit == false);        
    }
    
    private static void createCircle(int index)
    {
        char choice;
        double x,y, radius;
        
        String[] circleChoices = {"Exit", "Custom Circle", "Default Circle"};
        
        Menu customCircle = new Menu(circleChoices);
        
        choice = customCircle.getChoice();
        
        switch(choice)
        {
            case '0':
                break;
            case '1':
                System.out.println("Enter the Center coordinates for the Custom Circle: ");
                System.out.print("Enter the a value for x: ");
                while(!userInput.hasNextDouble())
                {
                   System.out.println("Please enter a number!: ");
                   userInput.next();
                }
                x = userInput.nextDouble();
                System.out.print("Enter the a value for y: ");
                while(!userInput.hasNextDouble())
                {
                   System.out.println("Please enter a number!: ");
                   userInput.next();
                }
                y = userInput.nextDouble();
                System.out.print("Enter the radius of the circle: ");
                while(!userInput.hasNextDouble())
                {
                   System.out.println("Please enter a number!: ");
                   userInput.next();
                }
                radius = userInput.nextDouble();
                
                myCircle[index] = new Circle2D(x,y,radius);
                break;
            case '2':
                myCircle[index] = new Circle2D();
                break;
        }

    }
} 
//Program: GeometricObjectApp
//This: GeometricObjectApp.java
//Date: 1/26/2017
//Author: Jason Welch
//Purpose: Used for testing the ComparableGeometricObject class and its sub classes

package geometricobjectapp;

public class GeometricObjectApp 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        boolean quit = false;        
        char choice;
        
        //Circle Radii
        double radius1 = 4;
        double radius2 = 8;
        
        //Rectangle Length and width
        double length1 = 2;
        double length2 = 4;
        double width1 = 6;
        double width2 = 8;
        
        String[] choices = {"Quit", "Circle", "Rectangle"};
        
        Menu myMenu = new Menu(choices);
        
        do
        {
            choice = myMenu.getChoice(); 
            
            switch(choice)
            {
                case '0': quit = true;
                   break;
                case '1':// ComparableCircle
                    ComparableCircle circle1 = new ComparableCircle(radius1);
                    ComparableCircle circle2 = new ComparableCircle(radius2);
                    System.out.println("Circle1:\n" + circle1.toString());
                    System.out.println("Circle2:\n" + circle2.toString());
                    System.out.println("Which is Larger Circle 1 or 2: \n" + (ComparableGeometricObject.max(circle1, circle2)).toString());

                    break;
                case '2':// ComparableRectangle
                    ComparableRectangle rect1 = new ComparableRectangle(width1,length1);
                    ComparableRectangle rect2 = new ComparableRectangle(width2,length2);
                    System.out.println("Rectangle1:\n" + rect1.toString());
                    System.out.println("Rectangle2:\n" + rect2.toString());
                    System.out.println("Which is Larger  Rectangle 1 or 2: \n" + (ComparableGeometricObject.max(rect1, rect2)).toString());

                    break;
            }
                        
        }while(quit == false); 
    }

}

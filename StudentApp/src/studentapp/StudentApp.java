//Program: StudentApp
//This: studentapp.java
//Date: $(date)
//Author: Jason Welch
//Purpose: 

package studentapp; 

import java.util.Scanner;

 
public class StudentApp 
{ 

    //===========  main ==========================
    public static void main(String[] args) 
    { 
        // Variable Declaration
        boolean quit = false;
        char choice;
        
        String[] choices = {"Quit", "Generate Student Username"};
        
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

    //============= optionOne() ===================
    private static void optionOne()
    {
        String firstName, lastName, studentID, semesterEnrolled;
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.print("Enter Student's First Name: ");
        firstName = userInput.next();
        
        System.out.print("Enter Student's Last Name: ");
        lastName = userInput.next();
        
        System.out.print("Enter Student's ID Number: ");
        studentID = userInput.next();
        
        System.out.print("Enter the semester that the Student is enrolled: ");
        semesterEnrolled = userInput.next();
        
        Students myStudent = new Students(firstName, lastName, studentID, semesterEnrolled);
        
        System.out.printf("The Student's Username is: %s", myStudent.createUsername());
        
        System.out.println(myStudent.toString());
    }
} 
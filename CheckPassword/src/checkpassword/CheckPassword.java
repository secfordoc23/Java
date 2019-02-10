//Program: CheckPassword
//This: checkpassword.java
//Date: 10/13/2015
//Author: Jason Welch
//Purpose: To check to see if a password meets Password complexity

package checkpassword; 

import java.util.Scanner;

 
public class CheckPassword 
{ 

    //===========  main ==========================
    public static void main(String[] args) 
    { 
        // Variable Declaration
        String password = "";
        String lengthMsg;
        String letterMsg;
        String digitMsg;
        String specialMsg;
        

        boolean quit = false;
        
        
        // Scanner
        Scanner input = new Scanner(System.in);
        do
        {
           System.out.print("Choose:\n " +
                   "\t(1) Check Password Complexity \n" +
                   "\t(0) Quit \n");
           
           System.out.print("Enter choice: ");
           String choose = input.next();
           
           char choice = choose.charAt(0);
           
           switch(choice)
           {
               case '0': quit = true;
                   break;
               case '1':
                   System.out.print("Enter in a Password to check to see if it is valid: ");
                   password = input.next();
                   lengthMsg = checkLength(password);
                   System.out.println(lengthMsg);
                   letterMsg = checkLetter(password);
                   System.out.println(letterMsg);
                   digitMsg = checkDigit(password);
                   System.out.println(digitMsg);
                   specialMsg = checkSpecial(password);
                   System.out.println(specialMsg);
                   break;
               default: System.out.println("Not valid - Choose again!");
           }
           
        } while(quit == false);
    } 
    
    //===========  checkLength ==========================
    // Check Password Length to see if it is 8 characters
    private static String checkLength(String password)
    {
        // Variable Declaration
        String message = "";
        
            if(password.length() >= 8)
            {
                message = "Password meets length requirements.";
            }
            else
            {
                message = "Invalid Password.  Must be at least 8 Characters.";
            }
        
        return message;
    }
    
    //===========  checkLetter ==========================
    //Check Password to see if it has at least One alphabetic character
    private static String checkLetter(String password)
    {
        //Variable Declaration
        String message = "";
        boolean isValid = false;
        int index = 0;
        
        do
        {
            if(password.charAt(index) >= 'A' && password.charAt(index) <= 'Z')
            {
                isValid = true;
            }
            else if(password.charAt(index) >= 'a' && password.charAt(index) <= 'z')
            {
                isValid = true;
            }
            else
            {
                isValid = false;
            }
            index++;
        } while(isValid == false && index < password.length());
        
        if(isValid == true)
        {
            message = "Password meets Letter requirements.";
        }
        else
        {
            message = "Invalid Password.  Must have at least 1 Letter.";
        }
        return message;
    }
    
    //===========  checkDigit ==========================
    // Check Password to see if it has a least one digit
    private static String checkDigit(String password)
    {
        //Variable Declaration
        String message = "";
        boolean isValid = false;
        int index = 0;
        
        do
        {
            if(password.charAt(index) >= '0' && password.charAt(index) <= '9')
            {
                isValid = true;
            }
            else
            {
                isValid = false;
            }
            index++;
        } while(isValid == false && index < password.length());
        
        if(isValid == true)
        {
            message = "Password meets Number requirements.";
        }
        else
        {
            message = "Invalid Password.  Must have at least 1 Digit.";
        }
        
        return message;
    }
    
    //===========  checkSpecial ==========================
    //Check Password to see if it has a least one special character
    private static String checkSpecial(String password)
    {
        //Variable Declaration
        String message = "";
        boolean isValid = false;
        int index = 0;
        
        do
        {
            if(password.charAt(index) >= '!' && password.charAt(index) <= '/')
            {
                isValid = true;
            }
            else if(password.charAt(index) >= ':' && password.charAt(index) <= '@')
            {
                isValid = true;
            }
            else if(password.charAt(index) >= '[' && password.charAt(index) <= '`')
            {
                isValid = true;
            }
            else if(password.charAt(index) >= '{' && password.charAt(index) <= '~')
            {
                isValid = true;
            } 
            else
            {
                isValid = false;
            }
            index++;
        } while(isValid == false && index < password.length());
        
        if(isValid == true)
        {
            message = "Password meets Special Character requirements.";
        }
        else
        {
            message = "Invalid Password.  Must have at least 1 Special Character.";
        }
        
        return message;
    }   
    
} 
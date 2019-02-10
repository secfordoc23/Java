/*
Program: Build a Menu

 */
package buildamenu;

import java.util.Random;
import java.util.Scanner;


public class BuildAMenu 
{
    //==================Main====================
    public static void main(String[] args) 
    {
       // Variable Declaration
       boolean quit = false;
       int rollTotal = 0;
       String userMsg = "";
       
       // Scanner
       Scanner getInput = new Scanner(System.in);
      
       do
       {
           System.out.print("Choose:\n " +
                   "\t(1)Roll \n" +
                   "\t(2)Evaluate Roll \n" +
                   "\t(3)Win or Lose \n" +
                   "\t(0) Quit \n");
           
           System.out.print("Enter choice: ");
           String choose = getInput.next();
           
           char choice = choose.charAt(0);
           
           switch(choice)
           {
               case '0': quit = true;
                   break;
               case '1': 
                   rollTotal = rollChoice();
                   System.out.println("Total: " + rollTotal);
                   break;
               case '2': 
                   userMsg = evalRoll(rollTotal);
                   System.out.println(userMsg);
                   break;
               case '3': 
                   winOrLose(userMsg);
                   break;
               default: System.out.println("Not valid - Choose again!");
           }
                   
       } while(quit == false);
      
    }
    
   //=================================
    private static int rollChoice()
    {
        // Initiate Random Number method
        Random randNum = new Random();
        
        //Variable declaration
        int die1 = randNum.nextInt(6) + 1;
        int die2 = randNum.nextInt(6) + 1;
        int total = die1 + die2;
        
        System.out.printf("Die1: %d Die2: %d\n", die1, die2);
        return total;
    }
    
    //================================
    private static String evalRoll(int diceTotal)
    {
        //Variable Declaration
        String message;
        
        if(diceTotal == 7 || diceTotal == 11)
        {
            message = "Winner";
        }
        else if(diceTotal == 2 || diceTotal == 3 || diceTotal == 12)
        {
            message = "Loser";
        }
        else if ( diceTotal > 0)
        {
            message = "In real craps you would continue to Roll.";
        }
        else
        {
            message = "You have not even rolled yet!!!";
        }
        
        return message;
    }
    
    //=================================
    private static void winOrLose(String message)
    {
        // Variable declaration
        char msg = message.charAt(0);
        
        if(msg == 'W')
        {
            System.out.println("A millionaire as such a young age!");
        }
        else if(msg == 'L')
        {
            System.out.println("Its as shame, bankrupt at such a young age!");
        }
        else if(msg == 'I')
        {
            System.out.println("You have not won or Lost.");
        }
        else
        {
            System.out.println("Idiot! You have not rolled or evaluated or evaluated your roll.");
        }
        
    }
    
}

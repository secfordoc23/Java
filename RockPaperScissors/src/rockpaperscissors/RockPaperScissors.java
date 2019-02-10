//Program: Rock Paper Scissors
//This: rockPaperScissors.java
//Date: 9/8/2015
//Author: Jason Welch
//Purpose: This program is designed for the User to play Rock Paper Scissors 
//  against the Computer.

package rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        Random myRand = new Random();
        Scanner scan = new Scanner(System.in);
        
        int computerNum;
        int userNum;
        String computerChose = "";
        String userChose = "";
        String whoWon = "";
        
        computerNum = myRand.nextInt(3) + 1;
        System.out.println("Scissor(1), Rock(2), Paper(3)");
        System.out.print("Enter a number: ");
        userNum = scan.nextInt();

        switch(computerNum)
        {
            case 1: computerChose = "Scissor"; 
                break;
            case 2: computerChose = "Rock"; 
                break;
            case 3: computerChose = "Paper"; 
                break;
        } // End Switch computerNum
        
        switch(userNum)
        {
            case 1: userChose = "Scissor"; 
                break;
            case 2: userChose = "Rock"; 
                break;
            case 3: userChose = "Paper"; 
                break;
        } // end Switch userNum     

        if(computerNum == 3 && userNum == 1)
        {
            whoWon = "You Won!";
        }
        else if(computerNum == 1 && userNum == 3)
        {
            whoWon = "You Lost!";
        }
        else if(computerNum == 1 && userNum == 2)
        {
            whoWon = "You Won!";
        }
        else if(computerNum == 2 && userNum == 1)
        {
            whoWon = "You Lost!";
        }
        else if(computerNum == 2 && userNum == 3)
        {
            whoWon = "You Won!";
        }
        else if(computerNum == 3 && userNum == 2)
        {
            whoWon = "You Lost!";
        }
        else
        {
            whoWon = "Draw!";
        }
        
        System.out.println("Computer Chose: " + computerChose);
        System.out.println("You Chose: " + userChose);
        System.out.println("Outcome: " + whoWon);
    }

}

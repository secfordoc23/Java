//Program: Lottery
//This: lottery.java
//Date: 9/14/2015
//Author: Jason Welch
//Purpose: To get a 3 digit number from the user and match it with a 
//  randomly genterated 3 digit number
package lottery;

import java.util.Random;
import java.util.Scanner;

public class Lottery
{

    //===========  main ==========================
    public static void main(String[] args)
    {
        // Scanner
        Scanner input = new Scanner(System.in);

        // Randomizer
        Random lottery = new Random();

        //Variable Declaration
        int userInput;
        int userFirstDigit;
        int userSecondDigit;
        int userThirdDigit;
        int lotteryNum = lottery.nextInt(999) + 1;
        int lotteryFirstDigit;
        int lotterySecondDigit;
        int lotteryThirdDigit;
        String results;

        // Get User input
        System.out.print("Enter your Lottery pick(Three Digits): ");
        userInput = input.nextInt();

        // Find user Digits
        userFirstDigit = userInput / 100;
        userSecondDigit = (userInput - (userFirstDigit * 100)) / 10;
        userThirdDigit = (userInput - (userFirstDigit * 100)) % 10;

        // Find Lottery digits
        lotteryFirstDigit = lotteryNum / 100;
        lotterySecondDigit = (lotteryNum - (lotteryFirstDigit * 100)) / 10;
        lotteryThirdDigit = (lotteryNum - (lotteryFirstDigit * 100)) % 10;

        // Find if user won
        if (userInput == lotteryNum)
        {
            results = "Exact Match: you win $10,000";
        }
        
        else if (userFirstDigit == lotteryFirstDigit || userFirstDigit == lotterySecondDigit || userFirstDigit == lotteryThirdDigit)            
        {
            results = "Match one digit: You win $3,000";
        }
        
        else if (userSecondDigit == lotteryFirstDigit || userSecondDigit == lotterySecondDigit || userSecondDigit == lotteryThirdDigit)            
        {
            results = "Match one digit: You win $3,000";
        }
        
        else if (userThirdDigit == lotteryFirstDigit || userThirdDigit == lotterySecondDigit || userThirdDigit == lotteryThirdDigit)            
        {
            results = "Match one digit: You win $3,000";
        }
        else
        {
            results = "Sorry: no match";
        }


        // Display output
        System.out.println("The Lottery number is: " + lotteryNum);
        System.out.println(results);

    }

}

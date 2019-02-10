//Program: TheBankClass
//This: checking.java
//Date: 2/8/2016
//Group: 4
//Author: Jason Welch, Brandon Onken, Kyle Bloyd
//Purpose: Class for typical checking transactions

package thebankclass;

import java.util.Scanner;


//====================================================================
public class Checking 
{
    // Class Variable Declaration
    protected double balance = 0;
    
    //Keyboard input
    Scanner input = new Scanner(System.in);
    
  //=====================Checking() default===========================
    public Checking()
    {
        balance = 0;
    }
    
  //=====================Checking() parameterized====================
    public Checking(double balance)
    {
        this.balance = balance;
    }
    
  //======================sets and gets=============================

    public double getBalance() 
    {
        return balance;
    }

    public void setBalance(double balance) 
    {
        this.balance = balance;
    }
  //=====================end of sets and gets=======================
    
  //====================double deposit()============================
    public void deposit()
    {
        double depositAmount;
        
        System.out.print("Enter the deposit amount: ");
        while(!input.hasNextDouble())
        {
            System.out.println("Please enter a number!");
            input.next();
        }
        depositAmount = input.nextDouble();
        
        balance = balance + depositAmount;

    }
    
  //====================double withdrawal()============================
    public void withdrawal()
    {
        double withdrawalAmount;
        
        System.out.print("Enter the withdrawal amount: ");
        while(!input.hasNextDouble())
        {
            System.out.println("Please enter a number!");
            input.next();
        }
        withdrawalAmount = input.nextDouble();

        if(withdrawalAmount > balance)
        {
            System.out.println("\nInsufficient funds! Please make a deposit");
        }
        else
        {
            balance = balance - withdrawalAmount;
        }
        
    }

    public double transfer()
    {
        double transferAmount;
        
        System.out.print("Enter the transfer amount: ");
        while(!input.hasNextDouble())
        {
            System.out.println("Please enter a number!");
            input.next();
        }
        transferAmount = input.nextDouble();

        if(transferAmount > balance)
        {
            System.out.println("\nInsufficient funds!");
            return 0;
        }
        
        balance = balance - transferAmount;
        
        return transferAmount;
        
    }
    
  //=================String toString()========================================
    @Override
    public String toString()
    {
        String display = "";
        display = "Your checking account balance is $" + 
                (int)(balance * 100) / 100.0;
        return display;
    }  
}

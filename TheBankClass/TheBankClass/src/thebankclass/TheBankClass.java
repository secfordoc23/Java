//Program: TheBankClass
//This: TheBankClass.java
//Date: 2/8/2016
//Group: 4
//Author: Jason Welch, Brandon Onken, Kyle Bloyd
//Purpose: Frontend app that utilizes the Checking, Savings and Loan Classes to 
//  simulate a typical Banking transaction

package thebankclass;
import java.util.Scanner;

public class TheBankClass 
{
    // Keyboard input
    private static Scanner input = new Scanner(System.in);
    
    //instantiate checking, savings, and loan objects
    private static Checking checks = new Checking();
    private static Savings saving = new Savings();
    private static Loan loan = new Loan();
    
    
//========================main()========================================
    public static void main(String[] args) 
    {
        boolean quit = false;                 
        char choice;
        String[] choices = {"Exit", "Checking", "Savings","Loans"};
        
        Menu startMenu = new Menu(choices);
        
        do 
        {
           choice = startMenu.getChoice();
           
           switch(choice) 
           {
               case '0': quit = true;
                   break;
               case '1': Checking(); //takes you to the checking menu
                   break;
               case '2': Savings(); //takes you to the savings menu
                   break;
               case '3': Loans(); //takes you to the loan calculator
                   break;
           }                    
        }while(quit == false);      
    }
    
    //================void Loans()==========================================
    public static void Loans()
    {
        //Variable declaration
        double loanAmount;
        int numYears;
        
        // Prompt the user to enter the loan amount and period
        System.out.print("Enter the loan amount: ");
        while(!input.hasNextDouble())
        {
            System.out.println("Please enter a number!");
            input.next();
        }

        loanAmount = input.nextDouble();
        
        loan.setAmount(loanAmount);
        
        System.out.print("Enter the number of years for the loan: ");
        while(!input.hasNextInt())
        {
            System.out.println("Please enter a number!");
            input.next();
        }
        numYears = input.nextInt();
                    
        loan.setNumOfYears(numYears);
        
        // Print the header
        System.out.printf("\n%-16s%-18s%-15s\n", "Interest Rate", "Monthly Payment", "Total Payment");
        
        loan.compareLoans(); 
        //displays the monthly and total payments for each 
        //interest rate starting from 5% to 8%, with an increment of 1/8.
    }
    
    //================void Savings()=========================================
    public static void Savings() 
    {
        //Variable declaration
        boolean quit = false;                 
        char choice;
        double depositAmount, withdrawalAmount, transferAmount;
        int numMonths;
        
        String[] choices = {"Main Menu", "Deposit", "Withdrawal","Calculate future balance", "check balance", "Transfer to Checking"};
        
        Menu savingsMenu = new Menu(choices);
        do 
        {
           choice = savingsMenu.getChoice();
            
           switch(choice) 
           {
               case '0': quit = true;
                   break;
                   
               //Deposit    
               case '1': 
                    saving.deposit();
                    
                    //show the current balance
                    System.out.println(saving.toString());
                   break;
                   
               //Withdrawl    
               case '2':                    
                    saving.withdrawal();
                    //show the current balance
                    System.out.println("\n" + saving.toString());
                   break;
                   
               //Calculate Balance    
               case '3': 
                    System.out.print("Enter the number of months you would like to save: ");
                    while(!input.hasNextInt())
                    {
                        System.out.println("Please enter a number!");
                        input.next();
                    }                   
                    numMonths = input.nextInt();

                    System.out.println(saving.futureBalance(numMonths));
                            //shows the balance and interest accrued 
                            //in a given number of months
                   break;
                   
               //Check Balance    
               case '4':
                   System.out.println(saving.toString());
                   break;
                   
               // Transfer to Checking    
               case '5':
                    checks.balance += saving.transfer();

                    //show the current of Savings balance
                    System.out.println("\n" + saving.toString());
                    
                    //show the current of Checking balance
                    System.out.println("\n" + checks.toString());   
                   break;

           }                    
        }while(quit == false);      
    }
    
    //================void Checking()========================================  
    public static void Checking() 
    {
        // Variable Declaration
        boolean quit = false;                 
        char choice;
        double depositAmount, withdrawalAmount, transferAmount;
        
        String[] choices = {"Main Menu", "Deposit", "Withdrawal", "Check Balance", "Transfer to Savings"};
        
        Menu checkingMenu = new Menu(choices);
        
        do 
        {
           choice = checkingMenu.getChoice();

           switch(choice) 
           {
               case '0': quit = true;
                   break;
               //Deposit    
               case '1': 
                    checks.deposit();
                    
                    System.out.println("\n" + checks.toString());
                   break;
                   
               // Withdrawal    
               case '2': 
                    checks.withdrawal();
                    System.out.println("\n" + checks.toString());
                   break;
                   
              // Check Balance     
              case '3':
                    System.out.println(checks.toString());
                    break;
                  
              // Transfer to Savings    
              case '4':
                    saving.balance += checks.transfer();
                    
                    //show the current of Savings balance
                    System.out.println("\n" + saving.toString());
                    
                    //show the current of Checking balance
                    System.out.println("\n" + checks.toString());  
                    break;
           }                    
        }while(quit == false);      
    }


} // end Class

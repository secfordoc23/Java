//Program: Portfolio
//This: portfolio.java
//Date: 11/17/2015
//Author: Jason Welch
//Purpose: Test Application for the stock class
package portfolio;

import java.util.Scanner;


public class Portfolio 
{

    //================ main ======================
    public static void main(String[] args) 
    {
        // Call the Menu Method
        menu();
    }
    
    //============= menu ===================
    private static void menu()
    {
        // Variable Declaration
        boolean quit = false;
        char choice;
        
        String[] choices = {"Quit", "Enter A Stock"};
        
        Menu myMenu = new Menu(choices);
        
        choice = myMenu.getChoice();
        
        do
        {
           switch(choice)
           {
               case '0': quit = true;
                   break;
               case '1': 
                   optionOne();
                   choice = myMenu.getChoice();
                   break;
               
           }
        }while(quit == false);
    }
    
    //============= optionOne ===================
    private static void optionOne()
    {
        Stock myStock = new Stock();
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter stock name: ");
        myStock.setName(input.next());
        
        System.out.print("Enter stock symbol: ");
        myStock.setSymbol(input.next());
        
        System.out.print("Enter current stock price: ");
        myStock.setCurrPrice(input.nextDouble());
        
        System.out.print("Enter yesturday's closing stock price: ");
        myStock.setClosePrice(input.nextDouble());
        
        myStock.calcPotChange();
        
        System.out.println(myStock.toString());        
    }
    
}

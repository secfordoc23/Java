//Program: TheBankClass
//This: savings.java
//Date: 2/8/2016
//Group: 4
//Author: Jason Welch, Brandon Onken, Kyle Bloyd
//Purpose: Sub Class of Checking that adds typical Savings transactions

package thebankclass;


public class Savings extends Checking
{
    // Class Variable declaration
    private double intRate = 1;
    
    
  //=====================Savings() default===========================
    public Savings()
    {
        super();
    }
    
  //=====================Savings() parameterized====================
    public Savings(double balance, double intRate)
    {
        super(balance);
        this.intRate = intRate;
    }
    
  //======================sets and gets=============================

    public double getIntRate() 
    {
        return intRate;
    }

    public void setIntRate(double intRate) 
    {
        this.intRate = intRate;
    }
    
    
  //=================String toString()========================================
    @Override
    public String toString()
    {
        String display = "";
        display = "Your savings account balance is $" + 
                (int)(balance * 100) / 100.0;
        return display;
    }
    
  //================String futureBalance()======================================
    public String futureBalance(int months)
    {
        String str = "";
        double interest = 0;
        double myBal = balance;
        double totalInt = 0;
        for(int month = 1; month <= months; month++) 
        {
            interest = myBal * intRate / 1200.0;
            myBal = myBal + interest;
            totalInt = totalInt + interest;
        }
        str = "\nAfter " + months + " months, your balance will be $" + 
                (int)(myBal * 100) / 100.0 +
                "\n and the interest accrued will be $" + 
                (int)(totalInt * 100) / 100.0;
        
        return str;           
    }
}

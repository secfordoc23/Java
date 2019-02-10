//Program: TheBankClass
//This: loan.java
//Date: 2/8/2016
//Group: 4
//Author: Jason Welch, Brandon Onken, Kyle Bloyd
//Purpose: Class for calculating Loan payments

package thebankclass;

//=========================================================================
public class Loan 
{
    private double intRate = 5;
    private int numOfYears = 5;
    private double increment = 0.125;
    private int numOfRates = 25;
    private double amount = 15000.0;
    
  //================Loan() default=========================================
    public Loan()
    {
        
    }
    
  //===============Loan() parameterized===================================
    public Loan(double rate, int numYears, double increment, 
            int numOfRates, double amount)
    {
        this.intRate = rate;
        this.numOfYears = numYears;
        this.increment = increment;
        this.numOfRates = numOfRates;
        this.amount = amount;
    }
    
  //===================sets and gets======================================

    public double getIntRate() 
    {
        return intRate;
    }

    public void setIntRate(double intRate) 
    {
        this.intRate = intRate;
    }

    public int getNumOfYears() 
    {
        return numOfYears;
    }

    public void setNumOfYears(int numOfYears) 
    {
        this.numOfYears = numOfYears;
    }

    public double getIncrement() 
    {
        return increment;
    }

    public void setIncrement(double increment) 
    {
        this.increment = increment;
    }

    public int getNumOfRates() 
    {
        return numOfRates;
    }

    public void setNumOfRates(int numOfRates) 
    {
        this.numOfRates = numOfRates;
    }
    
    public double getAmount() 
    {
        return amount;
    }

    public void setAmount(double amount) 
    {
        this.amount = amount;
    }
  //==================end of sets and gets===================================
    
  //===================void compareLoans()====================================
    public void compareLoans()
    {    
        double annualInterestRate = 0;
        String annualIntRateString = " ";
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = 0;
        double totalPayment = 0;
        int count = 0;
        
        while (count < numOfRates) 
        {
            annualInterestRate = intRate + count * increment;
            annualIntRateString = 
                    (int)(annualInterestRate * 1000) / 1000.0 + "%";
            monthlyInterestRate = annualInterestRate / 1200;
            monthlyPayment = (int)((amount * monthlyInterestRate / (1 - 1 / 
                    Math.pow(1 + monthlyInterestRate, numOfYears * 12))) * 100) 
                    / 100.0;
            totalPayment =  (int)((monthlyPayment * numOfYears * 12) * 100) 
                    / 100.0;
            System.out.printf("%-16s%-18.2f%-15.2f\n", annualIntRateString,
                    monthlyPayment, totalPayment);
            count++;
        }
    }
}

//Program: Portfolio
//This: stock.java
//Date: 11/17/2015
//Author: Jason Welch
//Purpose: Class for calculating stock price change 
package portfolio;


public class Stock 
{
    //Variable Declaration
    private String name;
    private String symbol;
    private double currPrice = 0;
    private double closePrice = 0;
    private double potChange = 0;
    
    
    //================ Stock default===================
    public Stock()
    {
        
    }
    
    //================ Stock with Parameters===================
    public Stock(String name, String symbol, double currPrice, double closePrice)
    {
        this.name = name;
        this.symbol = symbol;
        this.currPrice = currPrice;
        this.closePrice = closePrice;
    }
    
    //================ calcPotChange===================
    public void calcPotChange()
    {
        potChange = (currPrice - closePrice) / closePrice * 100;
        System.out.println("Test: " + potChange);
    }
    
    //========== Setters and Getters ================
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }
    public String getSymbol()
    {
        return this.symbol;
    }
    public void setCurrPrice(double currPrice)
    {
        this.currPrice = currPrice;
    }
    public double getCurrPrice()
    {
        return this.currPrice;
    }
    public void setClosePrice(double closePrice)
    {
        this.closePrice = closePrice;
    }
    public double getClosePrice()
    {
        return this.closePrice;
    }
    
    //========== toString ================
    public String toString()
    {
        String display = "\n=== Stock Calculation ===" +
                "\nName: " + name +
                "\nSymbol: " + symbol +
                "\nCurrent Price: " + currPrice +
                "\nClose Price: " + closePrice +
                "\nPot Change: " + potChange +
                "\n============================\n";
        
        return display;
    }
    
}

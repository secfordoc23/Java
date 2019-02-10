//Program: LocationApp
//This: location.java
//Date: 2/8/2016
//Author: Jason Welch
//Purpose: Class to find the Highest Value in a 2 dimensional Array

package locationapp;


public class Location 
{
    private int row;
    private int column;
    private double maxValue;
    
    // ============ Location default constructor =================
    public Location()
    {
        
    }
    
    // ============ locateLargest =================
    public void locateLargest(double[][] twoDimArray)
    {
        // Clear Class Variables
        row = 0;
        column = 0;
        maxValue = twoDimArray[0][0];
        
        // Index through array and compare maxValue with current value
        for(int arrayRow = 0; arrayRow < twoDimArray.length; arrayRow++)
        {
            for(int arrayColumn = 0; arrayColumn < twoDimArray[arrayRow].length; arrayColumn++)
            {
                
                if(twoDimArray[arrayRow][arrayColumn] > maxValue)
                {
                    row = arrayRow;
                    column = arrayColumn;
                    maxValue = twoDimArray[arrayRow][arrayColumn];
                }
                
            }
        }
    }

    // ================ Getters ===============
    public int getRow() 
    {
        return row;
    }

    public int getColumn() 
    {
        return column;
    }

    public double getMaxValue() 
    {
        return maxValue;
    }

    // =============== toString =============
    @Override
    public String toString() 
    {
        return "***Location***"
                + "\n\tRow = " + row
                + "\n\tColumn = " + column
                + "\n\tMax Value = " + maxValue;
    }

    
    
    
}

//Program: LocationApp
//This: createArray.java
//Date: 2/8/2016
//Author: Jason Welch
//Purpose: Class to create a 2 dimensional Array

package locationapp;

import java.util.Random;

public class CreateArray 
{
    // Class Variable Decalration
    int row;
    int column;
    private double[][] twoDimArray;
    
    //=========== CreateArray params ==========================
    public CreateArray(int row, int column)
    {
        this.row = row;
        this.column = column;
        
        this.twoDimArray = new double[row][column];
    }
    
    //=========== fillArray ==========================
    public double[][] fillArray()
    {
        Random myRand = new Random();
        
        for(int index = 0; index < row; index++)
        {
            for(int index2 = 0; index2 < column; index2++)
            {
                twoDimArray[index][index2] = (myRand.nextInt(99) + 1) + myRand.nextDouble();               
            }

        }
        return twoDimArray;
    }
    
    //=========== displayArray ==========================
    public void displayArray()
    {
        System.out.println("***** Two Dimensional Array Values *****");
        
        for(int index = 0; index < row; index++)
        {
            for(int index2 = 0; index2 < column; index2++)
            {
                System.out.printf("%.2f\t", twoDimArray[index][index2]);               
            }
            System.out.println();
        }
    }

}

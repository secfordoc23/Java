//Program: sortarraylist
//This: SortList.java
//Date: 3/6/2016
//Author: Jason Welch
//Purpose: A class to sort an Array List

package sortarraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class SortList
{
    private ArrayList<Integer> intList = new ArrayList<Integer>();

    //=================== default Constructor =========================
    public SortList()
    {
        
    }
    
    //================== Constructor w/ Param =========================
    public SortList(ArrayList<Integer> intList)
    {
        this.intList = intList;
    }

    //================= sort ================================
    public void sort()
    {        
        Collections.sort(intList);

    }

    //============ Getters and Setters =====================
    public ArrayList<Integer> getIntList()
    {
        return intList;
    }

    public void setIntList(ArrayList<Integer> intList)
    {
        this.intList = intList;
    }
    
    //================= fillArrayList =======================
    public void fillArrayList(int size)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.printf("Please enter %d Integers to fill the ArrayList\n", size);
        
        for(int index = 0; index < size; index++)
        {            
            System.out.printf("Enter Integer %d: ", index);
            while(!input.hasNextInt())
            {
                System.out.print("Please Enter a valid Integer!: ");
                input.next();
            }
            intList.add(input.nextInt());
        }
    }
    
    //=========== displayList =========================
    public void displayList()
    {
        System.out.println("Contents of ArrayList: ");
        for(int element : intList)
        {
            System.out.println("\t" + element);
        }
    }
}

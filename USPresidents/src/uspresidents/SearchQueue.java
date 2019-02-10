//Program: uspresidents
//This: SearchQueue.java
//Date: 3/23/2016
//Author: Jason Welch
//Purpose: A class for searching an Array Queue

package uspresidents;

import java.util.ArrayList;

public class SearchQueue 
{
    private String searchString;
    private int prezNumber;

    //========================= Default Constructor ========================= 
    public SearchQueue()
    {
        this.searchString = "";
        this.prezNumber = 0;
    }

    //======================== Constructor w/ Param ========================
    public SearchQueue(String searchString)
    {
        this.searchString = searchString;
    }
    
    public SearchQueue(int prezNumber)
    {
        this.prezNumber = prezNumber;
    }
    
    //======================= Setters ======================================
    public void setSearchString(String searchString)
    {
        this.searchString = searchString;
    }
    
    public void setPrezNumber(int prezNumber)
    {
        this.prezNumber = prezNumber;
    }
    
    //=======================getNumber() =================================
   
    
    public USPrez searchNumber(ArrayUnboundedQueue<USPrez> presidentQueue)
    {
        int index = 0;
        
        while(!presidentQueue.isEmpty())
        {            
            index++;
            USPrez nextPresident = presidentQueue.dequeue();
            if(index == prezNumber)
            {
                return nextPresident;
            }
            
        }
        
        return null;
    }
    
    public ArrayList<USPrez> searchState(ArrayUnboundedQueue<USPrez> presidentQueue)
    {
        //int index = 0;
        
        ArrayList<USPrez> results = new ArrayList<>();
        
        while(!presidentQueue.isEmpty())
        {            
            //index++;
            USPrez nextPresident = presidentQueue.dequeue();
            if((nextPresident.getHomeState().toLowerCase()).contains(searchString.toLowerCase()))
            {
                results.add(nextPresident);
            }
            
        }
        
        return results;
    } 
    
    
    
}

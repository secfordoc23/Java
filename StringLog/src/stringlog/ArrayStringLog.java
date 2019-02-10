// Program: StringLog
// This: ArrayStringLog.java
// Date: 2/1/2016
// Author: Jason Welch
// Purpose: implements an interface using an array to hold a log of Strings


package stringlog;


public class ArrayStringLog implements StringLogInterface
{
    protected String name; // Name of the log
    protected String[] log; // array that holds strings
    protected int lastIndex = -1; // index of last String in Array
    
    // ================== Constructors =======================
    public ArrayStringLog(String name) 
    {
        super();
        this.name = name;
        log = new String[3];
        
    }
    
    public ArrayStringLog(String name, int maxSize) 
    {
        this.name = name;
        log = new String[maxSize];
        
    }  
    
    // ================== void insert() =======================
    public void insert(String element)
    {
        // procondition: log is not full
        //places element into the log
        
        lastIndex++;
        log[lastIndex] = element;
    }
    
    // ================== boolean isFull() =======================
    public boolean isFull()
    {
        //returns true if the Log is full
        if(lastIndex == log.length - 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    // ================== int size() =======================
    public int size()
    {
        // returns the number of Strings in Log
        return (lastIndex + 1);
    }
    
    // ================== boolean contains() =======================
    public boolean contains(String element)
    {
        // returns true if element found in Log
        //ignores case differences
        int location = 0;
        
        while(location <= lastIndex)
        {
            if(element.equalsIgnoreCase(log[location]))
            {
                return true;
            }
            else
            {
                location++;
            }
        }
                
        return false;
    }
    
    // ================== void clear() =======================
    public void clear()
    {
        //makes the Log empty
        for(int index = 0; index <= lastIndex; index++)
        {
            log[index] = null;
        }
        lastIndex = -1;
        
    }
    
    // ================== String getName() =======================
    public String getName()
    {
        // returns name of Log
        return this.name;
    }
    
    // ================== String toString() =======================
    public String toString()
    {
        // returns a nicely formatted String representing 
        //  this StringLog
        String logString = "Log: " + this.name + "\n\n";
        
        for(int index = 0; index <= lastIndex; index++)
        {
            logString = logString + (index + 1) +
                    ". " + log[index] + "\n";
        }
        
        return logString;
    }
    
}

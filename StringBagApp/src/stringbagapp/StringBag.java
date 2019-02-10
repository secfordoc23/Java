//Program: stringbagapp
//This: StringBag.java
//Date: 
//Author: Jason Welch
//Purpose: 

package stringbagapp;


public class StringBag implements StringBagInterface
{
    protected String name; // Name of the log
    protected String[] myBag; // array that holds strings
    protected int lastIndex = -1; // index of last String in Array
    
    //===================== Constructors ==========================
    public StringBag(String name)
    {
        super();
        this.name = name;
        myBag = new String[5];
    }
    
    public StringBag(String name, int maxSize) 
    {
        this.name = name;
        myBag = new String[maxSize];
        
    }
    
    // ================== void insert() =======================
    public void insert(String element)
    {
        // procondition: log is not full
        //places element into the log
        
        lastIndex++;
        myBag[lastIndex] = element;
    }
    
    // ================== boolean isFull() =======================
    public boolean isFull()
    {
        //returns true if the Log is full
        if(lastIndex == myBag.length - 1)
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
            if(element.equalsIgnoreCase(myBag[location]))
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
            myBag[index] = null;
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
        String bagString = "Bag: " + this.name + "\n\n";
        
        for(int index = 0; index <= lastIndex; index++)
        {
            bagString = bagString + (index + 1) +
                    ". " + myBag[index] + "\n";
        }
        
        return bagString;
    }
}

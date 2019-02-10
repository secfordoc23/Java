// Program: StringLog
// This: stringLogInterface.java
// Date: 2/1/2016
// Author: Jason Welch
// Purpose: Interface for a class that impliments a log of strings

package stringlog;


public interface StringLogInterface 
{
    void insert(String element);
    //Precondition: The Log is not full
    //Places as element in the Log
    
    
    boolean isFull();
    //returns true if Log is full
    
    int size();
    //returns the number of Strings in this Log
    
    boolean contains(String element);
    //returns true if the elemnt is in the Log
    //ignores case differences
    
    void clear();
    //makes the Log empty
    
    String getName();
    // returns name of Log
    
    String toString();
    //returns a nicely formatted output of the Log
    
}

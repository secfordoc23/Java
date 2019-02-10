// Program: StringLog
// This: StringLog.java
// Date: 2/1/2016
// Author: Jason Welch
// Purpose: instantiates the StringLog object 
// and allows us to utilize the new object

package stringlog;


public class StringLog 
{

    public static void main(String[] args) 
    {
        // Variable Declaration
        
        ArrayStringLog myLog = new ArrayStringLog("Jason");
        
        myLog.insert("Elephant");
        myLog.insert("Water Buffelo");
        myLog.insert("Hippo");
        
        System.out.println(myLog);
        
        System.out.println("Elephant is in the Log: " + 
                myLog.contains("elephant"));
        
        System.out.printf("This log contains %d items.\n", myLog.size());
        
        System.out.printf("The name of the log is %s.\n",myLog.getName());
    
        System.out.printf("The %s is full: %s\n", myLog.getName(), myLog.isFull());
        
        myLog.clear();
        
        System.out.printf("This log contains %d items.\n", myLog.size());
    }
    
    
}

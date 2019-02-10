/*
Project: BBQueue
This: BBqueue.java
Date: PI-Day
Author: Jason J Welch
Purpose: A queue of grilling meats
*/

package bbqueue;


public class BBQueue 
{


    public static void main(String[] args) 
    {
        ArrayBoundQueue<String> myDinner = new ArrayBoundQueue<>(4);
        
        myDinner.enqueue("Short Ribs");
        myDinner.enqueue("Ribeye Steak");
        myDinner.enqueue("Squirrel");
        myDinner.enqueue("Possum");
        
        myDinner.enqueue("Rabbit");
        
        for(int index = 0; index < 5; index++)
        {
            System.out.println(myDinner.dequeue());
        }
        
    }
    
}

/*
Project: BBQueue
This: QueueInterface.java
Date: PI-Day
Author: Jason J Welch
Purpose: Interface for a class that implements a queue <T>
*/

package bbqueue;


public interface QueueInterface<T> 
{
    T dequeue() throws QueueUnderflowException;
    // exception if the queue is empty
    // else, removes front element
    
    boolean isEmpty();
    //true if empty queue
    
    
}

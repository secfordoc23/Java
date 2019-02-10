/*
Project: BBQueue
This: BoundedQueueInterface.java
Date: PI-Day
Author: Jason J Welch
Purpose: Interface for a FIFO class tjat implements a queue of a bound size
*/

package bbqueue;


public interface BoundedQueueInterface<T> extends QueueInterface<T>
{
    void enqueue(T element) throws QueueOverflowException;
    // exception if queue is full
    // else, adds element to queue
    
    boolean isFull();
    //returns true if queue full
    
    
}

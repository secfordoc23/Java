/*
Project: BBQueue
This: QueueOverflowException.java
Date: PI-Day
Author: Jason J Welch
Purpose: a class extend the RuntimeException if the queue is full and action is taken
*/

package bbqueue;


public class QueueOverflowException extends RuntimeException
{
    public QueueOverflowException()
    {
        super();
    }
    
    public QueueOverflowException(String message)
    {
        super(message);
    }
    
    
}

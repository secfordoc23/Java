/*
Project: BBQueue
This: QueueUnderflowException.java
Date: PI-Day
Author: Jason J Welch
Purpose: a class extend the RuntimeException if the queue is empty and action is taken
*/

package uspresidents;


public class QueueUnderflowException extends RuntimeException
{
    public QueueUnderflowException()
    {
        super();
    }
    
    public QueueUnderflowException(String message)
    {
        super(message);
    }
    
    
}

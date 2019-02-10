/*
Project: BBQueue
This: ArrayBoundQueue.java
Date: PI-Day
Author: Jason J Welch
Purpose: Implements the BoundedQueueInterface with an array to hold the queue
*/

package bbqueue;


public class ArrayBoundQueue<T> implements BoundedQueueInterface<T>
{
    protected final int DEFCAP = 100; // default Capacity
    protected T[] queue; // array that holds elements
    protected int numElements = 0; // elements in queue
    protected int front = 0; // index of front of queue
    protected int rear; // index of rear of queue
    protected int origCap;
    
    //============== Constructors =================================
    public ArrayBoundQueue()
    {
        queue = (T[]) new Object[DEFCAP];
        rear = DEFCAP -1;
    }
    
    public ArrayBoundQueue(int origCap)
    {
        queue = (T[]) new Object[origCap];
        this.origCap = origCap;
        //origCap = maxSize;
    }
    
    //==================== enQueue() =============================
    public void enqueue(T element)
    {
//        if(isFull())
//        {
//            throw new QueueOverflowException("Enqueue attempted an a full queue!");
//            
//        }
        // Alternate if Statement for UnboundedArrayQueue        
        if(numElements == queue.length)
        {
            enlarge();
        }
        // AND Remove Else Statement but leave code in else statement        
//        else
//        {
            rear = (rear + 1) % queue.length;
            queue[rear] = element;
            numElements++;
//        }
    }
    
    //================= isFull ===================================
    public boolean isFull()
    {
        return (numElements == queue.length);
    }
    
    //================= isEmpty ==================================
    public boolean isEmpty()
    {
        return (numElements ==0);
    }
    
    //================= dequeue =================================
    public T dequeue()
    {
        if(isEmpty())
        {
            throw new QueueUnderflowException("Dequeue attempted on an empty queue!");
        }
        else
        {
            T toReturn = queue[front];
            queue[front] = null;
            front = (front + 1) % queue.length;
            numElements = numElements - 1;
            return toReturn;
        }
    }
    
    //-============== enlarge ==================================
    private void enlarge()
    {
        T[] larger = (T[]) new Object[queue.length + origCap]; 
    
        int currSmaller = front;
        for(int currLarger = 0; currLarger < numElements; currLarger++)
        {
            larger[currLarger] = queue[currSmaller];
            currSmaller = (currSmaller + 1) % queue.length;
        }
        
        queue = larger;
        front = 0;
        rear = numElements - 1;
    }
    
    
}

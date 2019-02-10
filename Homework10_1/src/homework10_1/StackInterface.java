//Program: Homework10_1
//This: MyQueue.java
//Date: 4/2/2017
//Author: Jason Welch
//Purpose: An Interface for a generic queue 

package homework10_1;


public interface StackInterface<T>
{
    T pop();
    // Removes and returns the first element of the queue
    
    T peek();
    // Return the first element of the queue
    
    void push(T element);
    // Adds an element to the head of the queue
    
    void remove(int n);
    // Removes the top n entries from a queue
    
    boolean isEmpty();
    // Returns TRUE if stack is empty;
    
    boolean isFull();
    // Returns TRUE if stack is full;
}

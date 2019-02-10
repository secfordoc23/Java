//Program: GenericStackApp
//This: GenericStack.java
//Date: 2/22/2016
//Author: Jason Welch
//Purpose: a class to to create a generic array stack

package genericstackapp;


public class GenericStack<T> 
{
    protected final int DEFCAP = 15; // default capacity
    protected final int MULTIPLIER = 2;
    protected T[] stack; //array to hold stack elements
    protected int topIndex = -1; // index of top element
    
    
    //============ Default Constructor ==================
    public GenericStack()
    {
        stack = (T[]) new Object[DEFCAP];
    }

    //============ Constructor w/ param ==================
    public GenericStack(int maxSize)
    {
        stack = (T[]) new Object[maxSize];
    }
    
    //============ push ====================
    public void push(T element)
    {
        int newLength = 0;
        
        // place element on top of stack
        if(!isFull())
        {
           topIndex++;
           stack[topIndex] = element;
        }
        else
        {
            newLength = stack.length * MULTIPLIER;
            T[] temp = (T[]) new Object[newLength];
            
            for(int index = 0; index < stack.length; index++)
            {
                temp[index] = stack[index];
            }
            
            stack = temp;
            
            topIndex++;
            stack[topIndex] = element;
        }

    }
    
    //============ pop ========================
    public void pop()
    {

        //remove top element from stack

        stack[topIndex] = null;
        topIndex--;        

    }
    
    //============ top ========================
    public T top()
    {
        // returns top element of stack
        
        T topOfStack = null;

        topOfStack = stack[topIndex];
   
        return topOfStack;
    }
    
    //============ isEmpty ========================
    public boolean isEmpty()
    {
        //returns true if stack empty
        if(topIndex == -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //============ isFull ========================
    public boolean isFull()
    {
        //returns true if the stack is full
        if(topIndex == (stack.length - 1))
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    //============ toString =========================
    public String toString()
    {
        //returns a nicely formatted string
        String display = "Elements: \n";
        for(int index = 0; index < stack.length; index++)
        {
            display += stack[index] + "\n";
                    
        }
        
        return display;
    }
}

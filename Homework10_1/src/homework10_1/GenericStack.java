//Program: homework10_1
//This: MyStack.java
//Date: 4/2/2017
//Author: Jason Welch
//Purpose: A custom Stack class the implements the interface MyQueue

package homework10_1;


public class GenericStack<T> implements StackInterface<T>
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
    public GenericStack(int initSize)
    {
        stack = (T[]) new Object[initSize];
    }    
    
     //============ isEmpty ========================
    @Override
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
    @Override
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
    
    //============ pop ==================
    @Override
    public T pop()
    {
        //remove and return top element from stack
        if(!isEmpty() == true)
        {    
            T topOfStack = null;
            topOfStack = stack[topIndex];

            stack[topIndex] = null;
            topIndex--;
            return topOfStack;
        }
        
        return null;        
    }

    //============ peek ==================
    @Override
    public T peek()
    {
        // returns top element of stack        
        if(!isEmpty() == true)
        {
            T topOfStack = null;

            topOfStack = stack[topIndex];

            return topOfStack;
        }
        
        return null;
    }

    //============ push ==================
    @Override
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

    //============ remove ==================
    @Override
    public void remove(int n)
    {
        // Remove n elements from the top of the Stack.  If stack is < n
        // Remove all elements from the stack
        int removeNum = 0;
        if(n > topIndex)
        {
            removeNum = topIndex;
        }
        else
        {
            removeNum = n;
        }
        
        for(int index = 0; index <= removeNum; index++)
        {
            stack[index] = null;
            topIndex--;            
        }
    }

}

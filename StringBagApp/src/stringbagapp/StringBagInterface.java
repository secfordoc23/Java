//Program: StringBagApp
//This: StringBagApp.java
//Date: 3/13/2016
//Author: Jason Welch
//Purpose: An interface for the StringBag Class 

package stringbagapp;


public interface StringBagInterface
{
    void insert(String item);
    //precondition: the bag is not full - places object in the bag
    
    boolean isFull();
    //returns true if the bag is full, otherwise false
    
    int size();
    //returns the number of items in the bag
    
    boolean contains(String item);
    //returns true if item is in bag, ignores case differences
    
    void clear();
    //empties the bag
    
    String getName();
    //returns the name of the bag
    
    @Override
    String toString();
    //returns a nicely formatted display of what is contained in the bag
}

//Program: RemoveDuplicatesApp
//This: CheckDuplicates.java
//Date: 2/21/2016
//Author: Jason Welch
//Purpose: A Generic Class to check duplicates in an ArrayList

package removeduplicatesapp;

import java.util.ArrayList;


public class CheckDuplicates<T> 
{
    //================ Default Constructor ====================
    CheckDuplicates()
    {
        
    }
    
    //============== removeDuplicates ========================
    public ArrayList<T> removeDuplicates(ArrayList<T> list)
    {
        // Remove Duplicates: place them in new list (see above example).
	ArrayList<T> results = new ArrayList<>();
	
	for( T item : list) 
        {
	    if (!results.contains(item)) 
            {
		results.add(item);
		
	    }
	}
	return results;
    }
    
    
}

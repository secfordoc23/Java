//Program: Assignment7
//This: MyMap.java
//Date: 3/3/2017
//Author: Jason Welch
//Purpose: 

package assignment7;

import java.util.Set;


public interface MyMap<T,E>
{
    /** Remove all of the entries from this map */
    public void clear();
    
    /** Return true if the specified key is in the map */        
    public boolean containsKey(T key);
    
    /** Return true if this map contains the specified value */
    public boolean containsValue(E value);
    
    /** Return a set of entries in the map */
    public Set<Entry<T,E>> entrySet();
    
    /** Return the first value that matches the specified key */
    public E get(T key);
    
    /** Return true if this map contains no entries */
    public boolean isEmpty();
    
    /** Return a set consisting of the keys in this map */
    public Set<T> keySet();
    
    /** Add an entry (key, value) into the map */
    public E put(T key, E value);
    
    /** Remove the entries for the specified key */
    public void removeOne(T key);
    
    /** Return the number of mappings in this map */
    public int size();
    
    /** Return a set consisting of the values in this map */
    public Set<E> values();
    
    //====================== Entry Class ====================================
    /** Define inner class for Entry */
    public static class Entry<T, E>
    {
        T key;
        E value;
        
        //============== default contructor ================
        public Entry(T key, E value)
        {
            this.key = key;
            this.value = value;
        }
        
        //=========== Getters =============================
        public T getKey()
        {
            return key;
        }
        
        public E getValue()
        {
            return value;
        }
        
        //============ toString ==========================
        @Override
        public String toString()
        {
            return  "[" + key + ", " + value + ']';
        }
        
        
    }
}

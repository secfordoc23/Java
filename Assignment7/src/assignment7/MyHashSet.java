//Program: assignment7
//This: MyHashSet.java
//Date: 
//Author: Jason Welch
//Purpose: 

package assignment7;

import java.util.Iterator;
import java.util.Set;


public class MyHashSet<T> extends MyHashMap<T,T> implements Iterable<T>  
{

    //=================== clear =============================
    public void clear()
    {
        super.clear();
    }
    
    //=================== contains ==========================
    public boolean contains(T element)
    {
        return super.containsKey(element);
    }
    
    //=================== add ===============================
    public boolean add(T element)
    {
        if (super.containsKey(element))
        {
            return false;
        }
        else
        {
            super.put(element, element);
            return true;
        }
    }
    
    //=================== remove ===========================
    public boolean remove(T element)
    {
        if (!super.containsKey(element))
        {
            return false;
        }
        else
        {
            super.removeOne(element);
            return true;
        }
    }
    
    //=================== isEmpty =========================
    public boolean isEmpty() 
    {
        return super.isEmpty();
    }
    
    //=================== size ============================
    public int size()
    {
        return super.size();
    }
    
    //=================== iterator ===========================
    @Override
    public Iterator<T> iterator()
    {
        return new MapIterator<T>();
    }

    //=================== toString ===========================
    @Override
    public String toString()
    {
        String result = "[";
        for (T element : this)
        {
            result += element + ", ";
        }
        if(result.length() > 1) 
        {
            result = result.substring(0, result.length() - 2);
        }
        return result + "]";
    }
     
    //====================== MapIterator =====================
    private class MapIterator<T> implements Iterator<T> 
    {
        private Set<T> values;
        Iterator<T> it;
        
        //===================
        @SuppressWarnings("unchecked")
        public MapIterator()
        {
            values = (Set<T>) keySet();
            it = values.iterator();
        }

        //=================== hasNext ========================
         public boolean hasNext()
         {
             return it.hasNext();
         }

        //=================== next ===========================
        public T next()
        {
            return it.next();
        }

        //=================== remove =========================
        public void remove() 
        {
            throw new UnsupportedOperationException("Remove not allowed!");
        }
    }    
}

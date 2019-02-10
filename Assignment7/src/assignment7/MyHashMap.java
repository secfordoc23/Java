//Program: assignment7
//This: MyHashMap.java
//Date: 3/3/2017
//Author: Jason Welch
//Purpose: 

package assignment7;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class MyHashMap<T,E> implements MyMap<T,E> 
{
    // Define the default hash table size. Must be a power of 2
    private static int DEFAULT_INIT_CAP = 4;
    // Define the maximum hash table size. 1 << 30 is same as 2^30
    private static int MAX_CAP = 1 << 30;
    // Define default load factor
    private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;
    // Current hash table capacity. Capacity is a power of 2
    private int capacity;
    // Specify a load factor used in the hash table
    private float loadFactorThreshold;
    // The number of entries in the map
    private int size = 0;

    // Hash table is an array with each cell that is a linked list
    LinkedList<MyMap.Entry<T, E>>[] table;

    //================== default constructor =========================
    public MyHashMap() 
    {
        this(DEFAULT_INIT_CAP, DEFAULT_MAX_LOAD_FACTOR);
    }

    //================== constructor w/ initial capacity =============
    public MyHashMap(int initialCapacity) 
    {
        this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
    }

    //================== constructor w/ initial capacity and loadFactorThreshold =============
    @SuppressWarnings("unchecked")
    public MyHashMap(int initialCapacity, float loadFactorThreshold)
    {
        if (initialCapacity > MAX_CAP)
        {
            this.capacity = MAX_CAP;
        }
        else
        {
            this.capacity = trimToPowerOf2(initialCapacity);
        }
        this.loadFactorThreshold = loadFactorThreshold;
        table = new LinkedList[capacity];
    }
    
    //==================== clear =============================
    @Override
    public void clear()
    {
        size = 0;
        removeEntries();
    }

    //==================== containsKey =======================
    @Override
    public boolean containsKey(T key)
    {
        if (get(key) != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //==================== containsValue =====================
    @Override
    public boolean containsValue(E value)
    {
        for (int index = 0; index < capacity; index++)
        {
            if (table[index] != null)
            {
                LinkedList<Entry<T, E>> bucket = table[index];
                for (Entry<T, E> entry : bucket)
                {
                    if (entry.getValue().equals(value))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //==================== entrySet =========================
    @Override
    public Set<Entry<T, E>> entrySet()
    {
        Set<MyMap.Entry<T, E>> set = new HashSet<MyMap.Entry<T, E>>();
        for (int index = 0; index < capacity; index++)
        {
            if (table[index] != null)
            {
                LinkedList<Entry<T, E>> bucket = table[index];
                for (Entry<T, E> entry : bucket)
                {
                    set.add(entry);
                }
            }
        }
        return set;
    }

    //==================== get =============================
    @Override
    public E get(T key)
    {
        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] != null)
        {
            LinkedList<Entry<T, E>> bucket = table[bucketIndex];
            for (Entry<T, E> entry : bucket)
            {
                if (entry.getKey().equals(key))
                {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    //==================== isEmpty =========================
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    //==================== keySet ==========================
    @Override
    public Set<T> keySet()
    {
        Set<T> set = new java.util.HashSet<T>();
        for (int index = 0; index < capacity; index++)
        {
            if (table[index] != null)
            {
                LinkedList<Entry<T, E>> bucket = table[index];
                for (Entry<T, E> entry : bucket)
                {
                    set.add(entry.getKey());
                }
            }
        }
        return set;
    }

    //==================== put =============================
    @Override
    public E put(T key, E value)
    {
        if (get(key) != null)
        {
            int bucketIndex = hash(key.hashCode());
            LinkedList<Entry<T, E>> bucket = table[bucketIndex];
            for (Entry<T, E> entry : bucket)
            {
                if (entry.getKey().equals(key))
                {
                    E oldValue = entry.getValue();
                    entry.value = value;
                    return oldValue;
                }
            }
        }
        
        if (size >= capacity * loadFactorThreshold)
        {
            if (capacity == MAX_CAP)
            {
                throw new RuntimeException("Exceeding maximum capacity");
            }
            rehash();
        }
        
        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] == null)
        {
            table[bucketIndex] = new LinkedList<Entry<T, E>>();
        }
        
        table[bucketIndex].add(new MyMap.Entry<T, E>(key, value));
        size++;
        return value;
    }

    //==================== remove ==========================
    @Override
    public void removeOne(T key)
    {
        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] != null)
        {
            LinkedList<Entry<T, E>> bucket = table[bucketIndex];
            for (Entry<T, E> entry : bucket)
            {
                if (entry.getKey().equals(key))
                {
                    bucket.remove(entry);
                    size--;
                    break;
                }
            }
        }
    }

    //==================== size =========================
    @Override
    public int size()
    {
        return size;
    }

    //==================== values =======================
    @Override
    public Set<E> values()
    {
        Set<E> set = new java.util.HashSet<E>();
        for (int index = 0; index < capacity; index++)
        {
            if (table[index] != null)
            {
                LinkedList<Entry<T, E>> bucket = table[index];
                for (Entry<T, E> entry : bucket)
                {
                    set.add(entry.getValue());
                }
            }
        }
        return set;
    }

    //==================== hash ========================
    private int hash(int hashCode)
    {
        return supplementalHash(hashCode) & (capacity - 1);
    }

    //==================== supplementalHash ============
    private static int supplementalHash(int hashCode)
    {
        hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
        return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4);
    }
    
    //==================== trimToPowerOf2 ==============
    private int trimToPowerOf2(int initialCapacity)
    {
        int capacity = 1;
        while (capacity < initialCapacity)
        {
            capacity <<= 1;
        }
        return capacity;
    }
    
    //==================== removeEntries ===============
    private void removeEntries()
    {
        for (int index = 0; index < capacity; index++)
        {
            if (table[index] != null)
            {
                table[index].clear();
            }
        }
    }
    
    //==================== rehash ======================
    @SuppressWarnings("unchecked")
    private void rehash()
    {
        Set<Entry<T, E>> set = entrySet();
        capacity <<= 1;
        table = new LinkedList[capacity];
        size = 0;
        for (Entry<T, E> entry : set)
        {
            put(entry.getKey(), entry.getValue());
        }
    }
    
    //==================== toString ====================
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("[");
        for (int index = 0; index < capacity; index++)
        {
            if (table[index] != null && table[index].size() > 0)
            {
                for (Entry<T, E> entry : table[index])
                {
                    builder.append(entry);
                }
            }
        }
        builder.append("]");
        return builder.toString();
    }
    
}

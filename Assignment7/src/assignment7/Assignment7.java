//Program: Assignment7
//This: Assignment7.java
//Date: 3/3/2017
//Author: Jason Welch
//Purpose: 

package assignment7;

public class Assignment7 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        boolean quit = false;        
        char choice;

        
        String[] choices = {"Quit", "Test MyHashSet"};
        
        Menu myMenu = new Menu(choices);
        
        do
        {
            choice = myMenu.getChoice(); 
            
            switch(choice)
            {
                case '0': quit = true;
                   break;
                case '1':
                    MyHashSet<String> set = new MyHashSet<String>();
                    set.add("Jason");
                    set.add("Justin");
                    set.add("Eric");
                    set.add("Krista");
                    set.add("Emma");
                    
                    System.out.println("Elements in set: " + set);
                    set.clear();
                    
                    System.out.println("\nElements in set: " + set);
                    break;
            }
                        
        }while(quit == false); 
    }

}

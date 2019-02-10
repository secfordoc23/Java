//Program: SortArrayList
//This: SortArrayList.java
//Date: 
//Author: Jason Welch
//Purpose: 

package sortarraylist;

public class SortArrayList 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        boolean quit = false;        
        char choice;
        int size = 5;// Used to set Size of Test ArrayList
        
        String[] choices = {"Quit", "ArrayList Sort Test"};
        
        Menu myMenu = new Menu(choices);
        
        do
        {
            choice = myMenu.getChoice(); 
            
            switch(choice)
            {
                case '0': quit = true;
                   break;
                case '1': SortList testList = new SortList();
                    testList.fillArrayList(size);
                    System.out.println("Unsorted ArrayList: ");
                    testList.displayList();
                    testList.sort();
                    System.out.println("Sorted ArrayList: ");
                    testList.displayList();
                    break;
            }
                        
        }while(quit == false); 
    }

}

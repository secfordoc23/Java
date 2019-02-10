//Program: HomeworkW9
//This: HomeworkW9.java
//Date: 
//Author: Jason Welch
//Purpose: 

package homework.w9;

public class HomeworkW9 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        boolean quit = false;        
        char choice;

        
        String[] choices = {"Quit", "Option 1"};
        
        Menu myMenu = new Menu(choices);
        
        do
        {
            choice = myMenu.getChoice(); 
            
            switch(choice)
            {
                case '0': quit = true;
                   break;
                case '1':
                    break;
            }
                        
        }while(quit == false); 
    }

}

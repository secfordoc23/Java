//Program: GettysburgAddressCount
//This: GettysburgAddressCount.java
//Date: 
//Author: Jason Welch
//Purpose: 

package gettysburgaddresscount;

import java.io.IOException;

public class GettysburgAddressCount 
{
    //===========  main ==========================
    public static void main(String[] args) throws IOException 
    {
        // Variable Declaration
        boolean quit = false;        
        char choice;
        String webPage = "http://cs.armstrong.edu/liang/data/Lincoln.txt";
        
        
        String[] choices = {"Quit", "Get Gettysburg Word Count"};
        
        Menu myMenu = new Menu(choices);
        
        do
        {
            choice = myMenu.getChoice(); 
            
            switch(choice)
            {
                case '0': quit = true;
                   break;
                case '1': TextFromWeb gettysburg = new TextFromWeb(webPage);
                    System.out.println(gettysburg.toString());
                    break;
            }
                        
        }while(quit == false); 
    }

}

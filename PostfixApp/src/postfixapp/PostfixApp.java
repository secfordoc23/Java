//Program: PostfixApp
//This: PostfixApp.java
//Date: 4/9/2016
//Author: Jason Welch
//Purpose: A program to run a stack of postfix math problems

package postfixapp;

public class PostfixApp 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        boolean quit = false;        
        char choice;

        
        String[] choices = {"Quit", "Enter a Postfix equation to Calculate."};
        
        Menu myMenu = new Menu(choices);
        
        do
        {
            choice = myMenu.getChoice(); 
            
            switch(choice)
            {
                case '0': quit = true;
                   break;
                case '1': Postfix test = new Postfix();
                    String [] testArray = test.getPostfix();
                    System.out.println(test.validateData(testArray[0]));
                    break;
            }
                        
        }while(quit == false); 
    }

}

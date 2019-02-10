//Program: Baby Names
//This: BabyRank.java
//Date: 3/1/2016
//Author: Jason Welch, Kyle Bloyd, Brandon Onken
//Purpose: Prompts user for year, gender, and name, and then displays the 
//          rank for the name

package babynames;

import java.util.ArrayList;

public class BabyNames 
{
//===================main()====================================================
    public static void main(String[] args) 
    {
        //Variable Declaration
        boolean quit = false;        
        char choice, gender;
        int rank, year;
        String filePath, name;
        ArrayList<BabyRank> babyList;
        
        // Array of menu choices
        String[] options = {"Quit", "Default Baby Name Ranking", "Get a Baby's Name Ranking"};
        
        Menu mainMenu = new Menu(options);
        
        do 
        {
           //main menu
           choice = mainMenu.getChoice(); 
           switch(choice) 
           {
               case '0': quit = true;
                   break;
               // Default Test Case     
               case '1': gender = 'M'; 
                  name = "Jacob"; 
                  year = 2001;
                  filePath =  ".\\babynameranking" + year + ".txt";
                  RecordReader testList = new RecordReader(filePath);
                  babyList = testList.readFile();
                  rank = getRank(gender, name, babyList);
                  displayOutput(rank, name, year);
                   break;                   
               // Custom Case    
               case '2': InputValidator babyInput = new InputValidator();
                   year = babyInput.getYear();
                   gender = babyInput.getGender();
                   name = babyInput.getName();
                   filePath = ".\\babynameranking" + year + ".txt";
                   RecordReader newList = new RecordReader(filePath);
                   babyList = newList.readFile();
                   rank = getRank(gender, name, babyList);
                   displayOutput(rank, name, year);                   
                   break;
           }                    
        }while(quit == false);                              
    }

    private static int getRank(char gender, String name, ArrayList<BabyRank> babyList)
    {
        int rank = 0;
        
        //checks to see if name is in the list
        if (gender == 'M')
        {
            for (BabyRank element : babyList)
            {
               if (element.getMaleName().equalsIgnoreCase(name))
               {
                    return element.getRank();
               }            
            } 
        }
        else
        {
            for (BabyRank element : babyList)
            {
               if (element.getFemaleName().equalsIgnoreCase(name))
               {
                    return element.getRank();
               }            
            }
        }        
                
        return 0;        
    }
    
    private static void displayOutput(int rank, String name, int year)
    {
        if(rank == 0)
        {
            System.out.println("Name was not found!");
        }
        else
        {
            System.out.printf("\n %s is ranked #%d in the year %d.\n", name, rank, year);
        }
    }
}
//=============================================================================
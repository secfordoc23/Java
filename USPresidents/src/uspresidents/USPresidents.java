//Program: USPresidents
//This: USPresidents.java
//Date: 3/23/2016
//Author: Jason Welch
//Purpose: Main Class to search for US Presidents

package uspresidents;

import java.util.ArrayList;
import java.util.Scanner;

public class USPresidents 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        boolean quit = false;        
        char choice;
        String filePath = ".\\uspresidents.txt";
        RecordReader records = new RecordReader(filePath);
        String[] choices = {"Quit", "Search for President by Number", "Search for Presidents by Home State"};
        
        //keyboard input
        Scanner userInput = new Scanner(System.in);
        
        Menu myMenu = new Menu(choices);
        
        do
        {
            ArrayUnboundedQueue<USPrez> presidentQueue = records.readFile();
            
            SearchQueue prezSearch = new SearchQueue();
            
            choice = myMenu.getChoice(); 
            
            switch(choice)
            {
                case '0': quit = true;
                   break;
                case '1':
                    System.out.print("Enter the Number of the US President: ");
                    while(!userInput.hasNextInt())
                    {
                        System.out.print("Please enter a valid number!: ");
                        userInput.next();
                    }
                    int prezNumber = userInput.nextInt();
                    if(prezNumber > presidentQueue.numElements)
                    {
                        System.out.printf("The number %d is greater than the number of Presidents on Record!", prezNumber);
                    }
                    else
                    {
                        prezSearch.setPrezNumber(prezNumber);
                        USPrez numPresident = prezSearch.searchNumber(presidentQueue);
                        System.out.printf("President number %d is: \n  ", prezNumber);
                        System.out.println(numPresident.toString());
                    }
                    break;
                case '2':
                    System.out.print("Enter a US State for a list of Presidents from that state: ");
                    String homeState = userInput.next();
                    prezSearch.setSearchString(homeState);
                    ArrayList<USPrez> presidentList = prezSearch.searchState(presidentQueue);
                    if(presidentList.isEmpty())
                    {
                        System.out.printf("No President found with a home state like: %s \n", homeState);
                    }
                    else
                    {
                        System.out.printf("Presidents with a Home State like %s: \n", homeState);
                        for(USPrez president : presidentList)
                        {
                            System.out.printf("State: %s\t Name: %s\t DOB: %s\tParty: %s\tTerm Start: %s\n",president.getHomeState(), president.getName(),president.getDob(), president.getParty(),president.getTermStart());
                        }
                    }
                    break;
            }
                        
        }while(quit == false); 
    }

}

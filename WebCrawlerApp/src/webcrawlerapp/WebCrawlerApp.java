//Program: WebCrawlerApp
//This: WebCrawlerApp.java
//Date: 2/7/2017 
//Author: Jason Welch
//Purpose: A program to list all urls on a site and sub sites.

package webcrawlerapp;

import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class WebCrawlerApp 
{
    //===========  main ==========================
    public static void main(String[] args) 
    {
        // Variable Declaration
        boolean quit = false;        
        char choice;
        String url;

        
        String[] choices = {"Quit", "Enter a URL"};
        
        Menu myMenu = new Menu(choices);
        
        do
        {
            choice = myMenu.getChoice(); 
            
            switch(choice)
            {
                case '0': quit = true;
                   break;
                case '1': // Enter in a URL
                    Scanner keyBoard = new Scanner(System.in);
                    System.out.print("Enter a url: ");
                    url = keyBoard.nextLine();
                    crawler(url);
                    break;
            }
                        
        }while(quit == false); 
    }
    
    //=========== crawler ===========================
    private static void crawler(String startingURL)
    {
        ArrayList<String> listOfPendingURLs = new ArrayList<>();
        ArrayList<String> listOfTraversedURLs = new ArrayList<>();
        String url;
        
        listOfPendingURLs.add(startingURL);
        while(!listOfPendingURLs.isEmpty() && listOfTraversedURLs.size() <= 100)
        {
            url = listOfPendingURLs.remove(0);
            if(!listOfTraversedURLs.contains(url))
            {
                listOfTraversedURLs.add(url);
                System.out.println("Crawl: " + url);
                
                for(String subURL : getSubURLs(url))
                {
                    if(!listOfTraversedURLs.contains(subURL))
                    {
                        listOfPendingURLs.add(subURL);
                    }
                }
            }
        } // end while
        
    } // end crawler
    
    //=========== getSubURL =========================
    private static ArrayList<String> getSubURLs(String url)
    {
        ArrayList<String> list = new ArrayList<>();
        int current, endIndex;
        String line;
        
        try
        {
            URL webAddress = new URL(url);
            Scanner urlStream = new Scanner(webAddress.openStream());
            current = 0;
            while(urlStream.hasNext())
            {
                line = urlStream.nextLine();
                current = line.indexOf("http:", current);
                while(current > 0)
                {
                    endIndex = line.indexOf("\"", current);
                    if(endIndex > 0)
                    {
                        list.add(line.substring(current, endIndex));
                        current = line.indexOf("http:", endIndex);
                    }
                    else
                    {
                        current = -1;
                        
                    }
                }
            }
        } // end try
        catch (Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return list;
    }
} // end WebCrawlerApp

    

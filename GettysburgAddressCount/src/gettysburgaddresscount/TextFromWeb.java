//Program: gettysburgaddresscount
//This: TextFromWeb.java
//Date: 3/6/2016
//Author: Jason Welch
//Purpose: A class to get Text from a given URL

package gettysburgaddresscount;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;


public class TextFromWeb 
{
    private URL webPage;
    private int lineCount;
    private int wordCount;
    
    public TextFromWeb(String webPage) throws IOException
    {
        lineCount = 0;
        wordCount = 0;
        try
        {
            this.webPage = new URL(webPage);
        }
        catch (MalformedURLException ex)
        {
            System.out.println("Invalid URL!");          
        }
        getWebText();
    }
    
    //=============== Setters and Getters ==================
    public URL getWebPage()
    {
        return webPage;
    }

    public void setWebPage(URL webPage)
    {
        this.webPage = webPage;
    }

    public int getLineCount()
    {
        return lineCount;
    }

    public int getWordCount()
    {
        return wordCount;
    }
    
    //============ getWebText ===========================
    private void getWebText() throws IOException
    {
        String line;
        Scanner webInput = new Scanner(webPage.openStream());
        
        while(webInput.hasNext())
        {
            line = webInput.nextLine();
            lineCount++;
            wordCount += getStringBreakDown(line);
        }
        
    }
    
    //================= getStringBreakDown ==================
    private int getStringBreakDown(String line)
    {
       int count = 0;
       
       ArrayList<String> validWords = new ArrayList<>();
       String[] words = line.split("[ ,.]");
       
       for(int index = 0; index < words.length; index++)
       {
           if(words[index].length() != 0 && words[index].charAt(0) != '-')
           {
               validWords.add(words[index]);
           }
       }
       count = validWords.size();
       return count;
    }
    //============ toString =============================
    @Override
    public String toString()
    {
        String display =  "TextFromWeb:" 
                + "\n\twebPage=" + webPage 
                + "\n\tlineCount=" + lineCount 
                + "\n\twordCount=" + wordCount;
        return display;
    }
    
}
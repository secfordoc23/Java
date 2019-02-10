//Program: uspresidents
//This: RecordReader.java
//Date: 3/23/2016
//Author: Jason Welch
//Purpose: 

package uspresidents;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


public class RecordReader 
{
    private String filePath;
    
    //==================== default Constructor ==================
    public RecordReader()
    {
        filePath = "";
    }

    //====================== Constructor W/ params ==============
    public RecordReader(String filePath)
    {
        this.filePath = filePath;
    }
    
    // Setter
    public void setFilepath(String filePath)
    {        
        this.filePath = filePath;
    }
    
    //===================== readFile ===========================
    public ArrayUnboundedQueue<USPrez> readFile()
    {
        ArrayUnboundedQueue<USPrez> presidentQueue = new ArrayUnboundedQueue<>();
        
        File newFile = new File(filePath);
        USPrez president;
        String[] prezInfo;
        try
        {
            Scanner fileInput = new Scanner(newFile);
            //fileInput.useDelimiter(",");
            while (fileInput.hasNext()) 
            {
                //instantiates new Presidents object
                president = new USPrez();
                
                prezInfo = (fileInput.nextLine()).split(",");

                president.setName(prezInfo[0]);
                president.setHomeState(prezInfo[1]);
                president.setDob(prezInfo[2]);
                president.setParty(prezInfo[3]);
                president.setTermStart(prezInfo[4]);
                presidentQueue.enqueue(president);                
            }
            fileInput.close();
        }
        catch(IOException ex)
        {
            System.out.printf("\nUnable to read %s!\n", filePath);
        }

        return presidentQueue;
    }
}

//Program: babynames
//This: RecordReader.java
//Date: 3/9/2016
//Author: Jason Welch
//Purpose: A class to Read a record from a Text file

package babynames;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


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
    
    //===================== readFile ===========================
    public ArrayList<BabyRank> readFile()
    {
        ArrayList<BabyRank> rankList = new ArrayList<>();
        
        File newFile = new File(filePath);
        
        try
        {
            Scanner fileInput = new Scanner(newFile);
            while (fileInput.hasNextLine()) 
            {
                //instantiate new BabyRank object
                BabyRank myNames = new BabyRank();
                //set the rank, male name, and female name
                myNames.setRank(fileInput.nextInt());
                myNames.setMaleName(fileInput.next());
                myNames.setFemaleName(fileInput.next());

                rankList.add(myNames);                
            }            
        }
        catch(IOException ex)
        {
            System.out.printf("\nUnable to read %s!\n", filePath);
        }

        return rankList;
    }
    
} // end class

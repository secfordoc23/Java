//Program: BinaryDataFile
//This: BinaryDataFile.java
//Date: 
//Author: Jason Welch
//Purpose: 

package binarydatafile;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class BinaryDataFile 
{
    //===========  main ==========================
    public static void main(String[] args) throws IOException 
    {
        // Variable Declaration
        boolean quit = false;        
        char choice;
        String filePath = ".\\Excercise17_02.dat";
        
        String[] choices = {"Quit", "Write 100 Integers to a Binary Data File.", "Read File"};
        
        Random myRand = new Random();
        
        File randIntFile = new File(filePath);
        
        Menu myMenu = new Menu(choices);
        
        do
        {
            choice = myMenu.getChoice(); 
            
            switch(choice)
            {
                case '0': quit = true;
                   break;
                case '1': 
                    if(!randIntFile.exists())
                    {
                        randIntFile.createNewFile();
                    }
                    try(DataOutputStream randOutput = new DataOutputStream(new FileOutputStream(filePath,true)))
                    {
                        for(int index = 0; index < 100; index++)
                        {
                            randOutput.writeInt(myRand.nextInt(100));
                        }
                        randOutput.close();
                    }
                    catch(IOException ex)
                    {
                        ex.printStackTrace();
                    }
                    break;
                case '2':                   
                    try(DataInputStream readFile = new DataInputStream(new FileInputStream(filePath)))
                    {
                        while(true)
                        {
                            System.out.println(readFile.readInt());
                        }
                    }
                    catch(EOFException ex)
                    {
                        System.out.println("All the data was read.");
                    }
                    break;
            }
                        
        }while(quit == false); 
    }
    
}

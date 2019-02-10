//Program: chatserver
//This: FileReadWriter.java
//Date: 
//Author: Jason Welch
//Purpose: 

package chatserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;


public class FileReadWriter 
{
    private String filePath;
    BufferedReader fileInput;
    BufferedWriter  fileOutput;
    File userFile;
    
    //=================== Default Constructor =========================
    public FileReadWriter()
    {
        filePath = ".\\userList.txt";
        
        userFile = new File(filePath);
        if(!userFile.exists())
        {
            try
            {
                PrintWriter newFile = new PrintWriter(userFile);
            }
            catch(Exception ex)
            {
                ChatServer.gui.messageReceived("*** File Cannot be Created. ***");
            }
        }  
    }
    
    //================== readUserFile =========================
    public HashSet<Credential> readUserFile()
    {
        HashSet<Credential> userList = new HashSet<>();
        try
        {
            fileInput = new BufferedReader(new FileReader(userFile));
        }
        catch(Exception ex)
        {
            ChatServer.gui.messageReceived("*** Cannot Access the File. ***");
        }  
        
        String line, username, password;
        try
        {
            while((line = fileInput.readLine()) != null)
            {
                username = line.split(" ")[0];
                password = line.split(" ")[1];
                Credential user = new Credential(username, password);
                userList.add(user);

            }
            fileInput.close();
        }
        catch(Exception ex)
        {
            ChatServer.gui.messageReceived("*** Cannot Read the File. ***");
        }
        return userList;
    }
    
    //================== writeUserFile ========================
    public void writeUserFile(HashSet<Credential> userList)
    {
        String line;
        try
        {
            fileOutput = new BufferedWriter(new FileWriter(userFile));
        }
        catch(Exception ex)
        {
            ChatServer.gui.messageReceived("*** Cannot Access the File. ***");
        }          
        
        try
        {
            for(Credential user : userList)
            {
                line = user.getUsername() + " " + user.getPassword();
                
                fileOutput.write(line);
                fileOutput.newLine();
                fileOutput.flush();
            }
            fileOutput.close(); 
        }
        catch(Exception ex)
        {
            ChatServer.gui.messageReceived("*** Cannot Write to the File. ***");
        }
    }
    
}

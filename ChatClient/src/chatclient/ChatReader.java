//Program: chatclient
//This: ChatReader.java
//Date: $(date)
//Author: Jason Welch
//Purpose: 

package chatclient;


import java.net.Socket;
import java.util.Scanner;

public class ChatReader implements Runnable
{

    private Socket connectedSocket;
    //================ Task Constructor =========================
    public ChatReader(Socket connectedSocket)
    {
        this.connectedSocket = connectedSocket;
    }
    
    //=============== run ====================================
    // Default for Thread Task Template
    public void run()
    {
        String message = "";
        try
        {
            Scanner receivedMessages = new Scanner(connectedSocket.getInputStream());
            while(true)
            {
                if(receivedMessages.hasNext())
                {
                    message = receivedMessages.nextLine();
                    //Server shut down code...
                    if(message.contains("**##!:")) {
                        //Kill listener thread - server has shut down.
                        ChatClient.gui.appendTextArea("SERVER: The Chat Server has gone offline.");
                        ChatClient.gui.disconnectedFromServer();
                        return; 
                    }
                    //Bad auth code received...
                    else if(message.contains("!!##&:")){
                        //Kill listener thread - we didn't authenticate.
                        ChatClient.gui.appendTextArea("ERROR: Failed to authenticate. Check username / password.");
                        ChatClient.gui.disconnectedFromServer();
                        return;
                    }
                    //Normal message received...
                    else {
                        ChatClient.gui.appendTextArea(message);
                    }
                }
            }
        }
        catch(Exception ex)
        {
            message = "Unable to read message!";
            ChatClient.gui.appendTextArea(message);
        }
        //Update displayTextPane
    }
}

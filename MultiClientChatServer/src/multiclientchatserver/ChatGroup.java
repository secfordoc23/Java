//Program: multiclientchatserver
//This: ChatGroup.java
//Date: 
//Author: Jason Welch
//Purpose: 

package multiclientchatserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ChatGroup 
{
    private Socket connectedSocket;
    private Scanner streamInput;
    private PrintWriter streamOutput;
    private String message;
    
    public ChatGroup(Socket connectedSocket)
    {
        this.connectedSocket = connectedSocket;
    }
    
    private void checkConnection() throws IOException
    {
        if(!connectedSocket.isConnected())
        {
            for(int index = 1; index <= MultiClientChatServer.connectedSockets.size(); index++)
            {
                if(MultiClientChatServer.connectedSockets.get(index) == connectedSocket)
                {
                    MultiClientChatServer.connectedSockets.remove(index);
                }
            }
            // Break into a method
            for(int index2 = 1; index2 <= MultiClientChatServer.connectedSockets.size(); index2++)
            {
                Socket tempSocket = (Socket)MultiClientChatServer.connectedSockets.get(index2 - 1);
                streamOutput = new PrintWriter(tempSocket.getOutputStream());
                streamOutput.println(tempSocket.getLocalAddress().getHostAddress() + " has Disconnected.");
                streamOutput.flush();
                System.out.println(tempSocket.getLocalAddress().getHostAddress() + " has Disconnected.");
            }
        }
    }
    
    public void startChat()
    {
        try
        {
            try
            {
                streamInput = new Scanner(connectedSocket.getInputStream());
                streamOutput = new PrintWriter(connectedSocket.getOutputStream());
                while(true)
                {
                    checkConnection();
                    if(streamInput.hasNext())
                    {
                        message = streamInput.nextLine();
                        System.out.println("Client said: " + message);
                        
                        for(int index = 1; index <= MultiClientChatServer.connectedSockets.size(); index++)
                        {
                            Socket tempSocket = (Socket)MultiClientChatServer.connectedSockets.get(index - 1);
                            streamOutput = new PrintWriter(tempSocket.getOutputStream());
                            streamOutput.println(message);
                            streamOutput.flush();
                            System.out.println("Sent to: " + tempSocket.getLocalAddress().getHostAddress());                           
                        }
                    }
                    else
                    {
                        return;
                    }
                }

            }
            finally
            {
                connectedSocket.close();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}

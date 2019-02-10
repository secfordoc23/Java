//Program: chatserver
//This: ClientListener.java
//Date: 
//Author: Jason Welch
//Purpose: 

package chatserver;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ClientListener implements Runnable
{
    private Socket client;
    private Scanner chatInput;
    private PrintWriter chatOutput;
    
    //============= Default Constructor =================
    public ClientListener(Socket client)
    {
        this.client = client;
    }
    
    //=========== Task Template overrides Run ===========
    @Override
    public void run()
    {
        String message;
        try
        {
            try
            {                
                while(true)
                {
                    
                    chatInput = new Scanner(client.getInputStream());
                    
                    if(!chatInput.hasNext())
                    {
                        ChatServer.gui.messageReceived("Nothing in InputStream.");
                        return;
                    }
                    message = chatInput.nextLine();
                    for(Socket connectedSocket : ChatServer.connectedSockets)
                    {
                        chatOutput = new PrintWriter(connectedSocket.getOutputStream());
                        ChatServer.gui.messageReceived(message);
                        chatOutput.println(message);
                        chatOutput.flush();
                    }                    
                }
            }
            finally
            {
                ChatServer.gui.messageReceived("Closing Socket connected to: " + client.getRemoteSocketAddress());
                client.close();
                removeConnection();
            }
        }
        catch (Exception ex)
        {
            ChatServer.gui.messageReceived("***Error with Input / Output to Clients.***");
        }             
    }
    
    //====================== removeConnection ======================
    private void removeConnection() throws Exception
    {
        if(client.isClosed())
        {
            for(int index = 0; index < ChatServer.connectedSockets.size(); index++)
            {
                if(ChatServer.connectedSockets.get(index) == client)
                {
                    ChatServer.connectedSockets.remove(index);
                    ChatServer.gui.messageReceived("Removing:" + client.getRemoteSocketAddress() + " from connection list.");
                }
            }
        }
    }
}

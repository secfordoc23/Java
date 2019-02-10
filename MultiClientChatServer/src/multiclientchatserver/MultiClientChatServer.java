//Program: MultiClientChatServer
//This: MultiClientChatServer.java
//Date: 
//Author: Jason Welch
//Purpose: 

package multiclientchatserver;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiClientChatServer
{
    public static ArrayList<Socket> connectedSockets = new ArrayList<>();
    private static ArrayList<String> userList = new ArrayList<>();
    
    private static int port = 80;
    private static ServerSocket server;
    
    //===========  main ==========================
    public static void main(String[] args) 
    {
        String username;
        try
        {
            server = new ServerSocket(port);
            System.out.println("Waiting for Clients to connect...");
            
            while(true)
            {
                Socket connectedSocket = server.accept();
                connectedSockets.add(connectedSocket);
                System.out.println("Client Connected: " + connectedSocket.getLocalAddress().getHostName());
                
                username = getUsername(connectedSocket);
                if(validateUser(username) == true)
                {
                    ChatGroup connectedUser = new ChatGroup(connectedSocket);
                    Thread client = new Thread((Runnable) connectedUser);
                    client.start();
                }
            }            
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    //================== getUsername ========================
    private static String getUsername(Socket connectedSocket)
    {
        return "test";
    }
    
    //================= validateuser ========================
    private static boolean validateUser(String username)
    {
        return true;
    }
}

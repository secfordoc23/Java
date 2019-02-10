//Program: chatserver
//This: ChatServer.java
//Date: 
//Author: Jason Welch
//Purpose: 

package chatserver;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class ChatServer 
{
    private static ServerSocket server;
    private static int port = 80;
    private static HashSet<Credential> userList = new HashSet<>();
    public static ArrayList<Socket> connectedSockets = new ArrayList<>();
    public static ChatServerGUI gui;
    
    //==================== Main ==========================
    public static void main(String args[])
    {
        String username,password;
        gui = new ChatServerGUI(port);//.setVisible(true);
        gui.setVisible(true);

        boolean validUser = false;

        try
        {
            server = new ServerSocket(port);
            gui.messageReceived("Waiting a for Client to Connect...");

            while(true)
            {
                Socket connectedClient = server.accept();
                connectedSockets.add(connectedClient);
                gui.messageReceived("Received Connection request from: " + connectedClient.getRemoteSocketAddress());
                
                //Authenticate user                
                Scanner credentials = new Scanner(connectedClient.getInputStream());
                String line = credentials.nextLine();
                username = line.split(" ")[0];
                password = line.split(" ")[1];
                Credential user = new Credential(username,password);
                gui.messageReceived("Attempting to authenticate user: " + username);
                
                userList = gui.getUserList();

                if(userList.contains(user))
                {
                    gui.messageReceived(username + " has Authenticated.");
                        
                    //Start Thread
                    ClientListener client = new ClientListener(connectedClient);
                    Thread clientThread = new Thread(client);
                    clientThread.start();
                    gui.messageReceived("Connection Thread Started.");
                }
                else
                {
                    gui.messageReceived(username + " Failed to Authenticate. ");
                    PrintWriter toClient = new PrintWriter(connectedClient.getOutputStream());
                    toClient.println("!!##&:Failed to Authenticate: Bad Username or Password.");                    
                    toClient.flush();
                    connectedSockets.remove(connectedClient);
                    gui.messageReceived("Removed:" + connectedClient.getRemoteSocketAddress() + " from connection list.");                  
                    //connectedClient.close();
                }
                
            }
        }
        catch (Exception ex)
        {
            gui.messageReceived("***ERROR: A Client Failed to Connect.***");
        }
    }        

}


package chatclient;


public class ChatClient 
{
    public static ChatClientGUI gui;
    
    public static void main(String args[])
    {
        gui = new ChatClientGUI();
        gui.setVisible(true);
    }    
}
